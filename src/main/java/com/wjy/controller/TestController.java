package com.wjy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjy.model.Employee;
import com.wjy.server.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Controller
@Api(value = "查看用户信息")
public class TestController {
    @Autowired
    private EmployeeService employeeService;

    @ApiIgnore
    @RequestMapping(method = RequestMethod.GET, value = "hello")
    public String hello(@RequestParam(value = "pn", defaultValue = "1") int pn, ModelMap map){
        PageHelper.startPage(pn,5);
        List<Employee> employees = employeeService.getAll();
        PageInfo<Employee> info = new PageInfo<>(employees,5);
        map.put("info", info);
        return "index";
    }

    @ApiOperation(value = "获取分页信息")
    @GetMapping("getAll")
    public @ResponseBody PageInfo<Employee> getAll(@RequestParam(value = "pn", defaultValue = "1") int pn){
        PageHelper.startPage(pn,5);
        List<Employee> employees = employeeService.getAll();
        PageInfo<Employee> info = new PageInfo<>(employees,5);
        return info;
    }
}
