package com.bpg.spring.boot.log.service;

import com.bpg.spring.boot.log.entity.MethodMessage;

/**
 * @author zhaohq
 * @date 2020/9/29
 **/
public interface MethodMessageService {
    /**
     * 将日志信息写入到文件或是数据库
     * @param message 日志信息
     * @return boolean
     */
    boolean writeLog(MethodMessage message);

}
