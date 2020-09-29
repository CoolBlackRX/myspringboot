package com.bpg.spring.boot.log.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaohq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException{
    private String className;
    private String message;

    @Override
    public String toString() {
        return  "className: " + className + '\n' +
                "                   message: " + message ;
    }
}
