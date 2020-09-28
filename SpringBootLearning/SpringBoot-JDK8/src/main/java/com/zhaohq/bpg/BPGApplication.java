package com.zhaohq.bpg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhaohq
 * @date 2020/9/28
 **/
@SpringBootApplication
//@ComponentScan("com.bpg.spring.boot.log.config")
public class BPGApplication {
    public static void main(String[] args) {
        SpringApplication.run(BPGApplication.class, args);
    }
}
