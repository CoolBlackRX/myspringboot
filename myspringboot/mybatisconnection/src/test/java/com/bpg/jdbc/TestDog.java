package com.bpg.jdbc;

import com.bpg.bean.Dog;
import com.bpg.mapper.DogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDog {
    @Autowired
    DogMapper dogMapper;

    @Test
    public void TestListDog() {
        List<Dog> dogs = dogMapper.listDog();
        Iterator<Dog> iterator = dogs.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void TestInsertDog() {
        Dog dog = new Dog();
        dog.setName("二哈");
        dog.setAge(6);
        System.out.println(dogMapper.insertDog(dog));
    }

    @Test
    public void TestGetDogByID() {
        System.out.println(dogMapper.getDogByID(1));
    }
}
