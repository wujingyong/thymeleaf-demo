package com.wjy.dao;

import com.wjy.model.Employee;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface EmployeeMapper extends Mapper<Employee> {
    @Select(value = "select * from tbl_emp e left join tbl_dept d on e.did = d.dept_id")
    List<Employee> getEmployeeWithDepartment();
}