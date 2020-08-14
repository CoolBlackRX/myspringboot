package com.bpg.myspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohq
 */
@RestController
public class HelloController {

    @RequestMapping ("/hello")
    public String hello(){
        return "Hello World";
    }


}
