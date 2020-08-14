package com.bpg.myspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

/**
 * @author zhaohq
 */
@Controller
public class TestController {

    @RequestMapping("/t1")
    public String test1(Model model){
        model.addAttribute("msg","赵汉青是大帅哥");
        return "test";
    }
    @GetMapping("/t2")
    public String test2(Map<String,Object> map){
        map.put("msg","<h1>Hello</h1>");
        map.put("users", Arrays.asList("赵汉青","大帅哥"));
        return "test";
    }
}
