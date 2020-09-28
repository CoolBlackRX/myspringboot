package com.zhaohq.bpg;

import com.bpg.spring.boot.log.config.ZhaoDemoAutoConfig;
import com.bpg.spring.boot.log.service.ZhaoDemoService;

/**
 * @author zhaohq
 * @date 2020/9/27
 **/
public class ZhaoDemoStarter {
    public static void main(String[] args) {
        ZhaoDemoAutoConfig config = new ZhaoDemoAutoConfig();
        ZhaoDemoService demoService = config.demoService();
        String user = demoService.getUser();
        System.out.println(user);
    }
}
