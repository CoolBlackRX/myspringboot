package com.bpg.aspect;

import com.alibaba.fastjson.JSON;
import com.bpg.annotation.OperationLogDetail;
import com.bpg.entity.OperationLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author zhaohq
 * @date 2020/9/28
 **/
@Aspect
@Component
@Order(0)
public class OperationLogAspect {
    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.wwj.springboot.service.impl.*.*(..))")'
     */
    @Pointcut("@annotation(com.bpg.annotation.OperationLogDetail)")
    public void operationLog() {
    }

    /**
     * 环绕增强，相当于MethodInterceptor
     */
    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object res = null;
        long time = System.currentTimeMillis();
        try {
            res = joinPoint.proceed();
            time = System.currentTimeMillis() - time;
            return res;
        } finally {
            try {
                //方法执行完成后增加日志
                addOperationLog(joinPoint, res, time);
            } catch (Exception e) {
                System.out.println("LogAspect 操作失败：" + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void addOperationLog(JoinPoint joinPoint, Object res, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        OperationLog operationLog = new OperationLog();
        operationLog.setRunTime(time);
        operationLog.setReturnValue(JSON.toJSONString(res));
        operationLog.setLogId(UUID.randomUUID().toString());
        operationLog.setArgs(JSON.toJSONString(joinPoint.getArgs()));
        operationLog.setCreateTime(LocalDateTime.now());
        operationLog.setMethod(signature.getDeclaringTypeName() + "." + signature.getName());
        operationLog.setUserId("#{currentUserId}");
        operationLog.setUserName("#{currentUserName}");
        OperationLogDetail annotation = signature.getMethod().getAnnotation(OperationLogDetail.class);
        if (annotation != null) {
            operationLog.setLevel(annotation.level());
            operationLog.setDescribe(getDetail(((MethodSignature) joinPoint.getSignature()).getParameterNames(), joinPoint.getArgs(), annotation));
            operationLog.setOperationType(annotation.operationType().getValue());
            operationLog.setOperationUnit(annotation.operationUnit().getValue());
        }
        // TODO 这里保存日志
        System.out.println("记录日志:" + operationLog.toString());
        // operationLogService.insert(operationLog);
    }

    /**
     * 对当前登录用户和占位符处理
     *
     * @param argNames   方法参数名称数组
     * @param args       方法参数数组
     * @param annotation 注解信息
     * @return 返回处理后的描述
     */
    private String getDetail(String[] argNames, Object[] args, OperationLogDetail annotation) {

        Map<Object, Object> map = new HashMap<>(4);
        for (int i = 0; i < argNames.length; i++) {
            map.put(argNames[i], args[i]);
        }

        String detail = annotation.detail();
        try {
            detail = "'" + "#{currentUserName}" + "'=》" + annotation.detail();
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                Object k = entry.getKey();
                Object v = entry.getValue();
                detail = detail.replace("{{" + k + "}}", JSON.toJSONString(v));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detail;
    }

    @Before("operationLog()")
    public void doBeforeAdvice(JoinPoint joinPoint) throws NoSuchMethodException {
        System.out.println("进入方法前执行.....");
        System.out.println("================================================================================");
        //用的最多通知的签名
        Signature signature = joinPoint.getSignature();
        MethodSignature msg = (MethodSignature) signature;
        // 获取注解标记的方法所在的类
        Object target = joinPoint.getTarget();
        //获取注解标注的方法
        Method method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());
        //输出调用的类
        System.out.println("Class：" + target.getClass().getName());
        //输出调用的类的方法
        System.out.println("Method： " + method.getName());
        //通过方法获取注解
        Annotation[] annotations = method.getAnnotations();
        System.out.print("Annotations: ");
        String requestMethod = null;
        for (Annotation annotation : annotations) {
            // 获取注解的具体类型
            Class<? extends Annotation> annotationType = annotation.annotationType();

            System.out.print(annotationType.getCanonicalName() + " ;");

            if (annotationType.toString().contains("PostMapping")) {
                requestMethod = "RequestMethod: POST";
            }
            if (annotationType.toString().contains("GetMapping")) {
                requestMethod = "RequestMethod: GET";
            }
            if (annotationType.toString().contains("PutMapping")) {
                requestMethod = "RequestMethod: PUT";
            }
            if (annotationType.toString().contains("DeleteMapping")) {
                requestMethod = "RequestMethod: DELETE";
            }
            if (annotationType.toString().contains("RequestMapping")) {
                requestMethod = "RequestMethod: REQUEST";
            }
        }
        System.out.println();
        if (requestMethod != null) {
            System.out.println(requestMethod);
        }

        // 获取该方法的参数
        System.out.print("Args： ");
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.print(obj + " ;");
        }
        System.out.println();

    }

    /**
     * 处理完请求，返回内容
     *
     * @param resultValue
     */
    @AfterReturning(returning = "resultValue", pointcut = "operationLog()")
    public void doAfterReturning(Object resultValue) {
        System.out.println("方法的返回值 ........");
        System.out.println("MethodResultValue: "+ resultValue);
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing("operationLog()")
    public void doAfterThrows(JoinPoint joinPoint) {
        System.out.println("方法异常时执行.....");
    }


    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("operationLog()")
    public void after(JoinPoint jp) {
        System.out.println("方法最后执行.....");
    }

}
