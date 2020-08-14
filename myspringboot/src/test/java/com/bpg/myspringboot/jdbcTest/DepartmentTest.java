package com.bpg.myspringboot.jdbcTest;

import com.bpg.myspringboot.pojo.Department;
import com.bpg.myspringboot.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class DepartmentTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void TestGetDepartment(){
        Integer id = 1;
        Department department = departmentService.getDepartment(id);
        System.out.println(department);

        System.out.println("---------");

        List<Department> departments = departmentService.getDepartments();
        Iterator<Department> iterator = departments.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
