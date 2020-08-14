package com.bpg.myspringboot.mapper;

import com.bpg.myspringboot.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaohq
 */
@Mapper
@Repository
public interface EmployeeMapper {
    /**
     * 获取所有员工信息
     * @return
     */
    List<Employee> getEmployees();

    /**
     * 新增一个员工
     * @param employee
     * @return
     */
    int save(Employee employee);

    /**
     * 通过Id获取员工信息
     * @param id
     * @return
     */
    Employee get(Integer id);

    /**
     * 通过ID删除员工
     * @param id
     * @return
     */
    int delete(Integer id);

}
