package com.bpg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Description
 * @Author zhaohq
 * @Date 2020/8/14
 */
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String dateTime;

}
