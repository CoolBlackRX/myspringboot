package com.bpg.controller;

import com.bpg.pojo.Book;
import com.bpg.spring.boot.log.annotation.MyOperationLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.SunHints;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(String name){
        return "Hello"+name+"!";
    }
    @MyOperationLog("查询书籍信息")
    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        //System.out.println(3/0);
        return book;
    }

}
