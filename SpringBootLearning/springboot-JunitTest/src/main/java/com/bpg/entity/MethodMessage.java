package com.bpg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.JoinPoint;

/**
 * @author zhaohq
 * @date 2020/9/29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodMessage {
    /**
     * 注解位置
     */
    private JoinPoint joinPoint;
    /**
     * 方法所属的类
     */
    private String className;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 方法使用注解
     */
    private String annotations;
    /**
     * 请求方式
     */
    private String requestMethod;
    /**
     * 方法的参数
     */
    private String args;
    /**
     * 方法的返回值
     */
    private String methodResultValue;
    /**
     * 方法的返回值类型
     */
    private String methodRequestType;

    @Override
    public String toString() {
        return  "==============" + '\n' +
                "MethodMessage:" + '\n' +
                "========================================================================" + '\n' +
                "        ClassName: " + className + '\n' +
                "       MethodName: " + methodName + '\n' +
                "      Annotations: " + annotations + '\n' +
                "    RequestMethod: " + requestMethod + '\n' +
                "             Args: " + args + '\n' +
                "MethodResultValue: " + methodResultValue + '\n' +
                "MethodRequestType: " + methodRequestType + '\n' +
                "========================================================================";
    }
}
