package com.bpg.myspringboot.service;

import com.bpg.myspringboot.mapper.EmployeeMapper;
import com.bpg.myspringboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author zhaohq
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getEmployees(){
        return employeeMapper.getEmployees();
    }

    public int save(){
        Employee employee = new Employee();
        employee.setLast_name("ZhaoHanQing");
        employee.setEmail("1718539208@qq.com");
        employee.setGender(1);
        employee.setDepartment(1);
        employee.setBirth(new Date());
        return employeeMapper.save(employee);
    }
    public Employee get(Integer id){
        return employeeMapper.get(id);
    }

    public int delete(Integer id ){
        return employeeMapper.delete(id);
    }






}
