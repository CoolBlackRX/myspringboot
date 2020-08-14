package com.bpg.myspringboot.jdbcTest;

import com.bpg.myspringboot.mapper.JdbcDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class JdbcTemplateTest {

    @Autowired
    JdbcDao jdbcDao;
    @Test
    public void TestJdbcTemplateAddUser(){
        String str = jdbcDao.adduser();
        System.out.println(str);
    }

    @Test
    public void TestJdbcTemplateUpdateUser(){
        String str = jdbcDao.updateUser(1);
        System.out.println(str);
    }

    @Test
    public void TestJdbcTemplateSelectAll(){
        List<Map<String, Object>> maps = jdbcDao.userList();
        Iterator<Map<String, Object>> iterator = maps.iterator();
        while(iterator.hasNext()){
            Map<String ,Object> map = iterator.next();
            System.out.println(map);
        }
    }

    @Test
    public void TestJdbcTemplateDeleteUser(){
        String str = jdbcDao.deleteUser(2);
        System.out.println(str);
    }



}



