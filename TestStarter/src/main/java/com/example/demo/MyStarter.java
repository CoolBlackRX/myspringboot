package com.example.demo;

import com.bpg.spring.boot.log.config.ZhaoDemoAutoConfig;
import com.bpg.spring.boot.log.service.ZhaoDemoService;

/**
 * @author zhaohq
 * @date 2020/9/28
 **/
public class MyStarter {
    public static void main(String[] args) {
        ZhaoDemoAutoConfig config = new ZhaoDemoAutoConfig();
        ZhaoDemoService service = config.demoService();
        String user = service.getUser();
        System.out.println(user);
    }
}
