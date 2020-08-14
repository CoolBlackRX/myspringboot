package com.bpg.myspringboot.pojoTest;

import com.bpg.myspringboot.pojo.Dog;
import com.bpg.myspringboot.pojo.Person;
import com.bpg.myspringboot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoApplicationTest {

    @Autowired
    Dog dog;

    @Test
    public void TestDogFromValue(){
        System.out.println(dog);
    }

    @Autowired
    Person person;

    @Test
    public void TestPersonFromYAML(){
        System.out.println(person);
    }

    @Autowired
    User user;

    @Test
    public void TestUserFromPropertiesWithChinese(){
        System.out.println(user);
    }
}
