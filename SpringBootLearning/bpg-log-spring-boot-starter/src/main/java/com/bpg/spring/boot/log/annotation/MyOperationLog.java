package com.bpg.spring.boot.log.annotation;


import com.bpg.spring.boot.log.enums.OperationType;

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
     * 方法描述,可参考@ApiOperation(value = "描述")
     */
    String value() default "";

}
