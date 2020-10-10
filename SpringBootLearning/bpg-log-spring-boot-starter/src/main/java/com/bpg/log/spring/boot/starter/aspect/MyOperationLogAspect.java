package com.bpg.log.spring.boot.starter.aspect;


import com.bpg.log.spring.boot.starter.util.MyLogAnnotationUtil;
import com.bpg.log.spring.boot.starter.annotation.MyOperationLog;
import com.bpg.log.spring.boot.starter.entity.MethodMessage;
import com.bpg.log.spring.boot.starter.entity.MyException;
import com.bpg.log.spring.boot.starter.service.MethodMessageService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    MyLogAnnotationUtil myUtil = new MyLogAnnotationUtil();

    @Autowired
    MethodMessageService service;
    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.wwj.springboot.service.impl.*.*(..))")'
     */
    @Pointcut("@annotation(com.bpg.log.spring.boot.starter.annotation.MyOperationLog)")
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
        time = System.currentTimeMillis();

        MethodSignature msg = (MethodSignature) joinPoint.getSignature();
        // 获取注解标记的方法所在的类
        Object target = joinPoint.getTarget();
        // 获取注解标注的方法
        Method method = target.getClass().getMethod(msg.getName(), msg.getParameterTypes());



        // EL表达式
        MyOperationLog myLog = method.getAnnotation(MyOperationLog.class);
        String userName = myUtil.myParseExpression(myLog.userName(), method, joinPoint.getArgs());
        System.out.println(userName);
        System.out.println(myLog.type().getValue());
        System.out.println(myLog.moduleName());
        System.out.println(myLog.pageName());


        methodMessage.setValue(myLog.value());
        methodMessage.setAnnotations(myUtil.getAllAnnotation(method));
        methodMessage.setArgs(myUtil.getAllArgs(joinPoint));
        methodMessage.setUrl(myUtil.getUrl(target.getClass(),method));

        methodMessage.setType(myLog.type().getValue());
        methodMessage.setModuleName(myLog.moduleName());
        methodMessage.setPageName(myLog.pageName());
        methodMessage.setUserName(userName);
    }

    /**
     * 环绕增强，相当于MethodInterceptor
     */
    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }

//

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     * 方法最后执行
     */
    @After("operationLog()")
    public void after(JoinPoint joinPoint) {
        time = System.currentTimeMillis() - time;
        methodMessage.setUseTime(time + "ms");
        methodMessage.setJoinPoint(joinPoint.toString());
    }

    /**
     * 处理完请求，返回内容
     *
     * @param resultValue 切点的返回值
     */
    @AfterReturning(returning = "resultValue", pointcut = "operationLog()")
    public void doAfterReturning(Object resultValue) {
        methodMessage.setMethodResultValue(resultValue.toString());
        methodMessage.setMethodRequestType(resultValue.getClass().getCanonicalName());
        System.out.println(methodMessage.toString());
        // 执行下一步操作
        // 将日志信息输出到文件中或是写入到数据库

        boolean flag = service.addMyOperationLog(methodMessage);
        if(flag){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
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
        MyException e = new MyException(joinPoint.toString(),exception.getClass().getName(), exception.getMessage());
        methodMessage.setException(e);
        System.out.println(methodMessage.toString());

        // 执行下一步操作
        // 将日志信息输出到文件中或是写入到数据库
        boolean flag = service.addMyOperationLog(methodMessage);
        if(flag){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }


}
