package com.wjy.server;

import com.wjy.dao.EmployeeMapper;
import com.wjy.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public List<Employee> getAll(){
        List<Employee> employees = employeeMapper.selectByExample(null);
        return employees;
    }

    public List<Employee> getEmployeeWithDepartment() {
        return employeeMapper.getEmployeeWithDepartment();
    }

    public int addEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }

    public boolean validateEmpName(String empName) {
        Example example = new Example(Employee.class);
        example.createCriteria().andEqualTo("empName",empName);
        return employeeMapper.selectByExample(example).size() > 0;
    }

    public Employee getEmp(Integer id) {
        Example example = new Example(Employee.class);
        example.createCriteria().andEqualTo("empId", id);
        return employeeMapper.selectByExample(example) == null ? null:employeeMapper.selectByExample(example).get(0);
    }

    public int updateEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }
}
