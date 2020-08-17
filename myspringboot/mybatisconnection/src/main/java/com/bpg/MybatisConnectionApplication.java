package com.bpg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaohq
 */
@SpringBootApplication
@MapperScan("com.bpg.mapper")
public class MybatisConnectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisConnectionApplication.class, args);
    }

}
