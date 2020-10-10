package com.bpg.service;

import com.bpg.log.spring.boot.starter.annotation.MyOperationLog;
import com.bpg.log.spring.boot.starter.enums.OperationType;
import com.bpg.pojo.Book;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@Service
public class HelloService {

    @MyOperationLog(value = "查询书籍信息",userName = "#book.name",type = OperationType.BASE_DATA)
    public Book addBook(Book book){
        System.out.println("HHHH");
        return book;
    }

}
