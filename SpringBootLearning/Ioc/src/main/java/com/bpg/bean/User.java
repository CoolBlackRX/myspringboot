package com.bpg.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String note;
}
