package com.bpg.spring.boot.log.service.impl;

import com.bpg.spring.boot.log.entity.MethodMessage;
import com.bpg.spring.boot.log.service.MethodMessageService;

/**
 * @author zhaohq
 * @date 2020/9/29
 **/
public class MethodMessageServiceImpl implements MethodMessageService {
    @Override
    public boolean writeLog(MethodMessage message) {
        return false;
    }
}
