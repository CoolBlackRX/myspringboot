package com.bpg.myspringboot;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.bpg.myspringboot.mapper")
class MyspringbootApplicationTests {

    @Test
    void contextLoads() {
    }

}
