package com.bpg.controller;


import com.bpg.spring.boot.log.annotation.OperationLogDetail;
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
    @OperationLogDetail()
    @PostMapping("/book")
    public src.main.java.com.bpg.pojo.Book addBook(@RequestBody src.main.java.com.bpg.pojo.Book book){
        //System.out.println(3/0);
        return book;
    }

}
