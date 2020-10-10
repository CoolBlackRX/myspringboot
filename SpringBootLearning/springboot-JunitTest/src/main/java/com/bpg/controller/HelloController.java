package com.bpg.controller;

import com.bpg.log.spring.boot.starter.annotation.MyOperationLog;
import com.bpg.log.spring.boot.starter.enums.OperationType;
import com.bpg.pojo.Book;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@RestController
@RequestMapping("/About")
public class HelloController {

    @GetMapping("hello")
    public String hello(String name){
        return "Hello"+name+"!";
    }


    @MyOperationLog(value = "查询书籍信息",userName = "#book.name",type = OperationType.BASE_DATA)
    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        //System.out.println(3/0);
        return book;
    }

}
