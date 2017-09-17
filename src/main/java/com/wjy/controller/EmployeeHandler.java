package com.wjy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjy.dao.Msg;
import com.wjy.model.Employee;
import com.wjy.server.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Controller(value="employeeHandler")
public class EmployeeHandler {
	@Autowired
	private EmployeeService employeeService;
	
	/*@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value="getAll")
	public Msg getEmployeeWithDepartment(@RequestParam(value="pn",defaultValue="1")Integer pn){
		PageHelper.startPage(pn,5);
		List<Employee> emps = employeeService.getEmployeeWithDepartment();
		PageInfo<Employee> info = new PageInfo<>(emps,5);
		return Msg.success().add("pageInfo",info);
	}*/
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value="addEmp")
	public Msg addEmployee(@Valid Employee employee, BindingResult result){
		List<FieldError> fieldErrors = result.getFieldErrors();
		Map<String,Object> map = new HashMap<>();
		if(result.hasErrors()){
			for(FieldError f : fieldErrors){
				map.put(f.getField(), f.getDefaultMessage());
			}
			return Msg.fial().add("errors", map);
		}else{
			employeeService.addEmployee(employee);
			return Msg.success();
		}
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value="validateEmpName")
	public Msg validateEmpName(String empName){
		if(employeeService.validateEmpName(empName)){
			return Msg.success();
		}
		return Msg.fial();
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET ,value="getEmp/{id}")
	public Msg getEmployee(@PathVariable("id")Integer id){
		Employee employee = employeeService.getEmp(id);
		return Msg.success().add("employee", employee);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT,value="updateEmp/{id}")
	public Msg updateEmployee(@PathVariable("id") Integer id, Employee employee){
		employee.setEmpId(id);
		employeeService.updateEmployee(employee);
		return Msg.success();
	}
	
	/*@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE, value="deleteOne/{ids}")
	public Msg deleteOne(@PathVariable("ids") String ids){
		if(ids.contains("-")){
			List<Integer> delete_ids = new ArrayList<>();
			String[] split = ids.split("-");
			for(String s : split){
				delete_ids.add(Integer.parseInt(s));
			}
			employeeService.deleteBatch(delete_ids);
		}else{
			Integer id = Integer.parseInt(ids);
			employeeService.deleteOne(id);
		}
		return Msg.success();
	}*/
}
