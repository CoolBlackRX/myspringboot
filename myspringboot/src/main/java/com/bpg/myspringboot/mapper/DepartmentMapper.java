package com.bpg.myspringboot.mapper;

import com.bpg.myspringboot.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhaohq
 */
@Mapper
@Repository
public interface DepartmentMapper {
    /**
     * 获取所有部门信息
     * @return List<Department>
     */
    List<Department> getDepartments() ;

    /**
     * 通过id获取部门
     * @param id
     * @return Department对象
     */
    Department getDepartment(Integer id);

}
