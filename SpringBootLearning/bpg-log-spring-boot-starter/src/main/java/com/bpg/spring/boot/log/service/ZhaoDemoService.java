package com.bpg.spring.boot.log.service;

import com.bpg.spring.boot.log.entity.ZhaoDemoProperties;

/**
 * @author zhaohq
 * @date 2020/9/28
 **/
public class ZhaoDemoService {
    private String username;
    private String password;

    public ZhaoDemoService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUser() {
        ZhaoDemoProperties person = new ZhaoDemoProperties();

        return this.username + ":" + this.password;
    }
}
