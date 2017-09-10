package com.wjy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjy.model.Employee;
import com.wjy.server.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET, value = "hello")
    public String hello(){
        return "index";
    }

    @RequestMapping("getAll")
    public String getAll(@RequestParam(value = "pn", defaultValue = "1") int pn, ModelMap map){
        PageHelper.startPage(pn,5);
        List<Employee> employees = employeeService.getAll();
        PageInfo<Employee> info = new PageInfo<>(employees,5);
        map.put("info", info);
        return "index";
    }
}
