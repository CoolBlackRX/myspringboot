package com.bpg.log.spring.boot.starter.service;


import com.bpg.log.spring.boot.starter.entity.MethodMessage;
import com.bpg.log.spring.boot.starter.entity.dto.MethodMessageDTO;
import org.springframework.data.domain.Page;

/**
 * @author zhaohq
 * @date 2020/9/29
 **/
public interface MethodMessageService {

    /**
     * 新增方法操作日志
     *
     * @param methodMessage 日志信息
     * @return boolean
     */
    boolean addMyOperationLog(MethodMessage methodMessage);

    /**
     * 模糊查询日志数据
     *
     * @param messageDTO 查询条件
     * @return Page<MethodMessage>
     */
    Page<MethodMessage> show(MethodMessageDTO messageDTO);

    /**
     * 根据用户名查询方法调用日志信息
     *
     * @param userName 用户名
     * @return Page<MethodMessage>
     */
    Page<MethodMessage> getByUserName(String userName);

    /**
     * 通过注解的value值查询方法调用日志信息
     *
     * @param logValue MyOperationLog.class.value
     * @return Page<MethodMessage>
     */
    Page<MethodMessage> getByLogValue(String logValue);
}
