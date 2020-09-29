package com.bpg.spring.boot.log.aspect;

import com.bpg.spring.boot.log.annotation.MyOperationLog;
import com.bpg.spring.boot.log.entity.MethodMessage;
import com.bpg.spring.boot.log.entity.MyException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author zhaohq
 * @date 2020/9/28
 **/
@Aspect
@Component
public class MyOperationLogAspect {
    MethodMessage methodMessage = new MethodMessage();
    long time = 0L;

    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.wwj.springboot.service.impl.*.*(..))")'
     */
    @Pointcut("@annotation(com.bpg.spring.boot.log.annotation.MyOperationLog)")
    public void operationLog() {
    }

    /**
     * 进入方法前执行.....
     *
     * @param joinPoint 切点
     * @throws NoSuchMethodException 调用方法异常
     */
    @Before("operationLog()")
    public void doBeforeAdvice(JoinPoint joinPoint) throws NoSuchMethodException {
        Signature signature = joinPoint.getSignature();
        MethodSignature msg = (MethodSignature) signature;
        // 获取注解标记的方法所在的类
        Object target = joinPoint.getTarget();
        // 获取注解标注的方法
        Method method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());
        // 通过方法获取注解
        Annotation[] annotations = method.getDeclaredAnnotations();
        // 请求方式，通过注解判断
        String requestMethod = "";
        // 保存获取的注解
        StringBuilder annotationsName = new StringBuilder();
        String printFormat = "";
        for (Annotation annotation : annotations) {
            // 获取注解的具体类型
            Class<? extends Annotation> annotationType = annotation.annotationType();
            if (annotationType == MyOperationLog.class) {
                MyOperationLog myOperationLog = method.getAnnotation(MyOperationLog.class);
                methodMessage.setAnnotationValue(myOperationLog.value());
            }
            annotationsName.append(printFormat);
            annotationsName.append(annotationType.getCanonicalName());
            printFormat = '\n' + "                   ";

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


        // 获取该方法的参数
        Object[] args = joinPoint.getArgs();
        StringBuilder argsValue = new StringBuilder();
        printFormat = "";
        for (Object obj : args) {
            argsValue.append(printFormat);
            argsValue.append(obj);
            printFormat = '\n' + "                   ";
        }
        methodMessage.setClassName(target.getClass().getName());
        methodMessage.setAnnotations(annotationsName.toString());
        methodMessage.setRequestMethod(requestMethod);
        methodMessage.setMethodName(method.getName());
        methodMessage.setArgs(argsValue.toString());
    }

    /**
     * 环绕增强，相当于MethodInterceptor
     */
    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        time = System.currentTimeMillis();
        return joinPoint.proceed();
    }

//

    /**
     * 处理完请求，返回内容
     *
     * @param resultValue 切点的返回值
     */
    @AfterReturning(returning = "resultValue", pointcut = "operationLog()")
    public void doAfterReturning(Object resultValue) {
        methodMessage.setMethodResultValue(resultValue.toString());
        methodMessage.setMethodRequestType(resultValue.getClass().getCanonicalName());
    }

    /**
     * 后置异常通知
     * 方法异常时执行
     */
    @AfterThrowing(value = "operationLog()", throwing = "exception")
    public void doAfterThrows(JoinPoint joinPoint, Throwable exception) {
        System.out.println("=====================");
        System.out.println("！！！ 出 现 异 常 ！！！");
        System.out.println("=====================");
        MyException e = new MyException(exception.getClass().getName(), exception.getMessage());
        methodMessage.setException(e);
    }


    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * 方法最后执行
     */
    @After("operationLog()")
    public void after(JoinPoint joinPoint) {
        time = System.currentTimeMillis() - time;
        methodMessage.setUseTime(time + "ms");
        methodMessage.setJoinPoint(joinPoint);
        System.out.println(methodMessage.toString());
        // 执行下一步操作
        // 将日志信息输出到文件中或是写入到数据库
    }

}
