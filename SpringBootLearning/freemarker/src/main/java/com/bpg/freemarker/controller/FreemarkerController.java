package com.bpg.freemarker.controller;

import com.bpg.freemarker.model.Person;
import com.bpg.freemarker.model.MyReport;
import com.bpg.freemarker.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohq
 * @date 2020/9/23
 **/
@RestController
public class FreemarkerController {
    @Autowired
    WordService wordService;
    @RequestMapping("/test")
    public void test(){
        Person person = new Person("zhaohq" );
        wordService.exportWord("Demo","demo.ftl",person);
    }

    @RequestMapping("/")
    public void printOutUnqualifiedReport(){
        wordService.exportWord("MyUnqualifiedReport","UnQualifiedReport.ftl",new MyReport());
    }

}
