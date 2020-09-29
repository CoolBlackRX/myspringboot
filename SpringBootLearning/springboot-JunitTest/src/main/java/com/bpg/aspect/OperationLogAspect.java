package com.bpg.aspect;

import com.alibaba.fastjson.JSON;
import com.bpg.annotation.OperationLogDetail;

import com.bpg.entity.MethodMessage;
import com.bpg.entity.OperationLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
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
public class OperationLogAspect {
    MethodMessage methodMessage = new MethodMessage();

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
        Object res = joinPoint.proceed();
//        long time = System.currentTimeMillis();
//        try {
//            res = joinPoint.proceed();
//            time = System.currentTimeMillis() - time;
//            return res;
//        } finally {
//            try {
//                //方法执行完成后增加日志
//                addOperationLog(joinPoint, res, time);
//            } catch (Exception e) {
//                System.out.println("LogAspect 操作失败：" + e.getMessage());
//                e.printStackTrace();
//            }
//        }
        return res;
    }

//    private void addOperationLog(JoinPoint joinPoint, Object res, long time) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        OperationLog operationLog = new OperationLog();
//        operationLog.setRunTime(time);
//        operationLog.setReturnValue(JSON.toJSONString(res));
//        operationLog.setLogId(UUID.randomUUID().toString());
//        operationLog.setArgs(JSON.toJSONString(joinPoint.getArgs()));
//        operationLog.setCreateTime(LocalDateTime.now());
//        operationLog.setMethod(signature.getDeclaringTypeName() + "." + signature.getName());
//        operationLog.setUserId("#{currentUserId}");
//        operationLog.setUserName("#{currentUserName}");
//        OperationLogDetail annotation = signature.getMethod().getAnnotation(OperationLogDetail.class);
//        if (annotation != null) {
//            operationLog.setLevel(annotation.level());
//            operationLog.setDescribe(getDetail(((MethodSignature) joinPoint.getSignature()).getParameterNames(), joinPoint.getArgs(), annotation));
//            operationLog.setOperationType(annotation.operationType().getValue());
//            operationLog.setOperationUnit(annotation.operationUnit().getValue());
//        }
//        // TODO 这里保存日志
//        // System.out.println("记录日志:" + operationLog.toString());
//        // operationLogService.insert(operationLog);
//    }
//
//    /**
//     * 对当前登录用户和占位符处理
//     *
//     * @param argNames   方法参数名称数组
//     * @param args       方法参数数组
//     * @param annotation 注解信息
//     * @return 返回处理后的描述
//     */
//    private String getDetail(String[] argNames, Object[] args, OperationLogDetail annotation) {
//
//        Map<Object, Object> map = new HashMap<>(4);
//        for (int i = 0; i < argNames.length; i++) {
//            map.put(argNames[i], args[i]);
//        }
//
//        String detail = annotation.detail();
//        try {
//            detail = "'" + "#{currentUserName}" + "'=》" + annotation.detail();
//            for (Map.Entry<Object, Object> entry : map.entrySet()) {
//                Object k = entry.getKey();
//                Object v = entry.getValue();
//                detail = detail.replace("{{" + k + "}}", JSON.toJSONString(v));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return detail;
//    }

    @Before("operationLog()")
    public void doBeforeAdvice(JoinPoint joinPoint) throws NoSuchMethodException {
        // System.out.println("进入方法前执行.....");
        // 用的最多通知的签名
        Signature signature = joinPoint.getSignature();
        MethodSignature msg = (MethodSignature) signature;
        // 获取注解标记的方法所在的类
        Object target = joinPoint.getTarget();
        // 获取注解标注的方法
        Method method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());
        // 调用的类
        methodMessage.setClassName(target.getClass().getName());
        // 调用的类的方法
        methodMessage.setMethodName(method.getName());
        // 通过方法获取注解
        Annotation[] annotations = method.getDeclaredAnnotations();
        // 请求方式，通过注解判断
        String requestMethod = null;
        // 保存获取的注解
        StringBuilder annotationsName = new StringBuilder();
        String printFormat = "";
        for (Annotation annotation : annotations) {
            // 获取注解的具体类型
            Class<? extends Annotation> annotationType = annotation.annotationType();
            annotationsName.append(printFormat);
            annotationsName.append(annotationType.getCanonicalName());
            printFormat ='\n' + "                   ";

            if (annotationType.toString().contains("PostMapping")) {
                requestMethod = "POST";
            }
            if (annotationType.toString().contains("GetMapping")) {
                requestMethod = "GET";
            }
            if (annotationType.toString().contains("PutMapping")) {
                requestMethod = "PUT";
            }
            if (annotationType.toString().contains("DeleteMapping")) {
                requestMethod = "DELETE";
            }
            if (annotationType.toString().contains("PatchMapping")) {
                requestMethod = "PATCH";
            }
            if (annotationType.toString().contains("RequestMapping")) {
                requestMethod = "RequestMapping";
            }
        }
        methodMessage.setAnnotations(annotationsName.toString());
        methodMessage.setRequestMethod(requestMethod);

        // 获取该方法的参数
        Object[] args = joinPoint.getArgs();
        StringBuilder argsValue = new StringBuilder();
        printFormat = "";
        for (Object obj : args) {
            argsValue.append(printFormat);
            argsValue.append(obj);
            printFormat ='\n' + "                   ";
        }
        methodMessage.setArgs(argsValue.toString());
    }

    /**
     * 处理完请求，返回内容
     *
     * @param resultValue 切点的返回值
     */
    @AfterReturning(returning = "resultValue", pointcut = "operationLog()")
    public void doAfterReturning(Object resultValue) throws NoSuchMethodException {
        // System.out.println("方法的返回值 ........");
        methodMessage.setMethodResultValue(resultValue.toString());
        methodMessage.setMethodRequestType(resultValue.getClass().getCanonicalName());
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing("operationLog()")
    public void doAfterThrows(JoinPoint joinPoint) {
        // System.out.println("方法异常时执行.....");
        System.out.println("====================");
        System.out.println("！！！ 出 现 异 常 ！！！");
        System.out.println("====================");
    }


    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("operationLog()")
    public void after(JoinPoint jp) {
        //System.out.println("方法最后执行.....");
        System.out.println(methodMessage.toString());
    }

}
