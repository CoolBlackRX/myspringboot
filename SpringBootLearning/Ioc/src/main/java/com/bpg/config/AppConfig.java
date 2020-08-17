package com.bpg.config;

import com.bpg.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@Configuration
public class AppConfig {
    @Bean(name = "user")
    public User initUser(){
        User user = new User();
        user.setId(1L);
        user.setUsername("zhaohq");
        user.setNote("h");
        return user;
    }
}
