package com.wjy.server;

import com.wjy.dao.EmployeeMapper;
import com.wjy.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public List<Employee> getAll(){
        List<Employee> employees = employeeMapper.selectByExample(null);
        return employees;
    }
}
