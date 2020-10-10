package com.bpg.log.spring.boot.starter.annotation;


import com.bpg.log.spring.boot.starter.enums.OperationType;

import java.lang.annotation.*;

/**
 * @author zhaohq
 * @date 2020/9/28
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyOperationLog {
    /**
     * 操作描述
     */
    String value() default "";
    /**
     * 业务类型
     */
    OperationType type() default OperationType.DEFAULT;
    /**
     * 操作角色名称 支持EL表达式
     */
    String userName() default "";
    /**
     * 模块名称
     */
    String moduleName() default "";
    /**
     * 页面
     */
    String pageName() default "";



}
