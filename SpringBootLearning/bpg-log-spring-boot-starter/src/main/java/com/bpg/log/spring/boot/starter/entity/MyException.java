package com.bpg.log.spring.boot.starter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaohq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException {
    private String exceptionLocation;
    private String className;
    private String message;

    @Override
    public String toString() {
        return  "exceptionLocation: " + exceptionLocation + '\n' +
                "                 className: " + className + '\n' +
                "                   message: " + message ;
    }
}
