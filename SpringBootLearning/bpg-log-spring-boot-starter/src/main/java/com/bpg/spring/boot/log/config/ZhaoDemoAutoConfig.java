package com.bpg.spring.boot.log.config;

import com.bpg.spring.boot.log.entity.ZhaoDemoProperties;
import com.bpg.spring.boot.log.service.ZhaoDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaohq
 * @date 2020/9/28
 **/
@Configuration
@EnableConfigurationProperties(ZhaoDemoProperties.class)
public class ZhaoDemoAutoConfig {
    @Autowired
    private ZhaoDemoProperties person;

    @Bean(name = "demo")
    public ZhaoDemoService demoService(){
        return new ZhaoDemoService(person.getUsername(),person.getPassword());
    }
}
