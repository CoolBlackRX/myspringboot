package com.bpg.annotation;



import com.bpg.enums.OperationType;
import com.bpg.enums.OperationUnit;

import java.lang.annotation.*;

/**
 * @author zhaohq
 * @date 2020/9/28
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLogDetail {
    /**
     * 方法描述
     */
    String value() default "";
}
