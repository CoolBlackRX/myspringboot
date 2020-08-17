package com.bpg.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    private Integer id;
    @Value("二哈")
    private String name;
    @Value("3")
    private Integer age;
}
