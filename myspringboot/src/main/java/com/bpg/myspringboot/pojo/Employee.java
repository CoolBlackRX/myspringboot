package com.bpg.myspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author zhaohq
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String last_name;
    private String email;
    private Integer gender;
    private Integer department;
    private Date birth;
    //冗余设计
    private Department eDepartment;

}
