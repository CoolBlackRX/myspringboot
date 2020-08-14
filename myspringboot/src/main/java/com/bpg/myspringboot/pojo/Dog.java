package com.bpg.myspringboot.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhaohq
 */
@Component //注入到容器中
@Data
public class Dog {

    @Value("大黄")
    private String Name;
    @Value("3")
    private Integer Age;

   /* public Dog() {
    }

    public Dog(String name, Integer age) {
        Name = name;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }*/
}
