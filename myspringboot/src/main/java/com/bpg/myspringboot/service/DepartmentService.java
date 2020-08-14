package com.bpg.myspringboot.service;

import com.bpg.myspringboot.mapper.DepartmentMapper;
import com.bpg.myspringboot.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaohq
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getDepartments(){
        return departmentMapper.getDepartments();
    }

    public Department getDepartment(Integer id){
        return departmentMapper.getDepartment(id);
    }



}
