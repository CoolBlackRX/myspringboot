package com.bpg.log.spring.boot.starter.entity.dto;

import com.bpg.log.spring.boot.starter.entity.MethodMessage;
import lombok.Data;

/**
 * @author zhaohq
 * @date 2020/10/10
 **/
@Data
public class MethodMessageDTO {
    private MethodMessage methodMessage;
    private Integer page;
    private Integer limit;
    private String startTime;
    private String endTime;
}
