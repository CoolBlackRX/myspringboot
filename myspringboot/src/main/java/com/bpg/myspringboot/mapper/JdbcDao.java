package com.bpg.myspringboot.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhaohq
 */
@Component
public class JdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String,Object>> userList(){
        String sql = "select * from employee";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    public String adduser(){
        String sql = "insert into employee(last_name, email,gender,department,birth)" +
                "values ('大帅哥','24736743@qq.com',1,101,'"+ new Date().toString() +"')";
        jdbcTemplate.update(sql);
        return "addOK";
    }
    public String updateUser(int id){
        String sql = "update employee set last_name = ?,email = ? where id = "+id;
        Object[] objects = new Object[2];
        objects[0] = "赵汉青";
        objects[1] = "66666@qq.com";
        jdbcTemplate.update(sql,objects);
        return "updateOK";
    }

    public String deleteUser(int id){
        String sql = "delete from employee where id = ?";
        jdbcTemplate.update(sql,id);
        return "deleteOK";
    }
}
