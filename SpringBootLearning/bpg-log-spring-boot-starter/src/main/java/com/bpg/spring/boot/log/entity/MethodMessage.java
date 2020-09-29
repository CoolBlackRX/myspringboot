package com.bpg.spring.boot.log.entity;

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
    private String id;
    /**
     * 方法执行时间
     */
    private String useTime;
    /**
     * 注解位置
     */
    private JoinPoint joinPoint;
    /**
     * 方法描述
     */
    private String annotationValue;
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
    /**
     * 异常信息
     */
    private MyException exception;
    /**
     * userId
     */
    private String userId;
    /**
     * userName
     */
    private String userName;

    @Override
    public String toString() {
        return  "======================================================================================" + '\n' +
                "MethodMessage:" + annotationValue + '\n' +
                "     Location:" + joinPoint + '\n' +
                "======================================================================================" + '\n' +
                "          UseTime: " + useTime + '\n' +
                "        ClassName: " + className + '\n' +
                "       MethodName: " + methodName + '\n' +
                "      Annotations: " + annotations + '\n' +
                "    RequestMethod: " + requestMethod + '\n' +
                "             Args: " + args + '\n' +
                "MethodResultValue: " + methodResultValue + '\n' +
                "MethodRequestType: " + methodRequestType + '\n' +
                "      MyException: " + exception + '\n' +
                "======================================================================================" + '\n' +
                "           UserID: " + userId + '\n' +
                "         UserName: " + userName + '\n' +
                "======================================================================================";
    }
}
