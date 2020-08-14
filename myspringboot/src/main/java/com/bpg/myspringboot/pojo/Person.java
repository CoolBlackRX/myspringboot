package com.bpg.myspringboot.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhaohq
 */
//@PropertySource(value = "classpath:person.properties")
//@PropertySource 注解虽然可以加载指定的配置文件，但是在注入值得时候还是需要@Value注解的配合才能把配置文件的值注入到对象中
@Component
//注入到容器中
@ConfigurationProperties(prefix = "person3")
@Data
public class Person {

    //@Value("${person.name}")
    private String Name ;
    private Integer age ;
    private Date birth ;
    private boolean happy ;
    private Map<String,Object> map ;
    private List<Object> list ;
    private Dog dog ;
}
