package com.bpg.spring.boot.log.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhaohq
 * @date 2020/9/28
 **/
@Data
@ConfigurationProperties(prefix = "demo")
public class ZhaoDemoProperties {
    private String username = "zhaohq";

    private String password = "123";
}
