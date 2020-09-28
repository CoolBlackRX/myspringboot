package com.bpg.mapper;

import com.bpg.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zhaohq
 * @description
 * @date 2020/8/21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void selectAllUserTest() {
        System.out.println("----selectAllUserTest----");
        List<User> list = userMapper.selectList(null);
        /*Iterator<User> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        list.forEach(System.out::println);
    }

    @Test
    public void InsertTest() {
        User user = new User();
        user.setName("赵汉青是大帅哥");
        user.setAge(23);
        user.setEmail("1718539208@qq.com");
        int i = userMapper.insert(user);
        System.out.println(i);
    }
}