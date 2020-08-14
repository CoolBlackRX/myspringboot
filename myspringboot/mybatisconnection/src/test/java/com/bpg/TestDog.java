package com.bpg;

import com.bpg.bean.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@SpringBootTest
public class TestDog {
    @Autowired
    Dog dog;

    @Test
    public void Test(){
        System.out.println(dog);
    }
}
