package com.bpg.myspringboot.jdbcTest;

import com.bpg.myspringboot.pojo.Employee;
import com.bpg.myspringboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class EmployeeTest {
    @Autowired
    private EmployeeService employeeService;

    @Test
    void TestGetEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }

    @Test
    void TestGet() {
        Employee employee = employeeService.get(2);
        System.out.println(employee);
    }

    @Test
    void TestSave() {
        int save = employeeService.save();
        System.out.println(save);
    }

    @Test
    void TestDelete() {
        int delete = employeeService.delete(2);
        System.out.println(delete);
    }
}
