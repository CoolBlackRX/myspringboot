package com.bpg.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@Data
@Component
@Lazy
public class Dog {
    @Value("二哈")
    private String name;
    @Value("3")
    private Integer age;
}
