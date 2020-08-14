package com.bpg.myspringboot.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zhaohq
 */
//@PropertySource(value="classpath :user.properties")calsspath后面不会能有空格，否则无法加载配置文件
@PropertySource(value = "classpath:user.properties")
@Component
@Data
public class User {
    @Value("${user.name}")
    private String name ;

    @Value("${user.age}")
    private Integer age ;

    @Value("${user.sex}")
    private String sex ;
}
