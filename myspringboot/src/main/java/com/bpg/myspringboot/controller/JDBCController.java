package com.bpg.myspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author zhaohq
 */
@RestController
@RequestMapping("/jdbc")
class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    public List<Map<String,Object>> userList(){
        String sql = "select * from employee";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
     }
     @GetMapping("/add")
    public String adduser(){
        String sql = "insert into employee (last_name,emile,gender,department,birth"+
                "value('大帅哥','1718539208@qq.com',1,101,'\"+ new Date().toLocaleString() +\"')";
        jdbcTemplate.update(sql);
        return "addOK";
     }
     @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update employee set last_name = ?,emile = ? where id = "+id;
        Object[] objects = new Object[2];
        objects[0] = "赵汉青";
        objects[1] = "66666@qq.com";
        jdbcTemplate.update(sql,objects);
        return "updateOK";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "update from employee where id = ?";
        jdbcTemplate.update(sql,id);
        return "deleteOK";
    }

}
