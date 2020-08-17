package com.bpg.controller;

import com.bpg.pojo.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/book")
    public String addBook(@RequestBody Book book){
        return book.toString();
    }

}
