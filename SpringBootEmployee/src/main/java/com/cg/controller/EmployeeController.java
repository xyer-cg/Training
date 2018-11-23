package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.beans.Employee;
import com.cg.service.EmployeeService;

@RestController
public class EmployeeController
{
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping ("/emp")
	public List <Employee> getAllEmployees ()
	{
		return employeeService.getAllEmployees ();
	}
	
	@RequestMapping ("/emp/{id}")
	public Optional <Employee> getEmployee (@PathVariable int id)
	{
		return employeeService.getEmployee (id);
	}
	
	@RequestMapping ("/emp/salary/{salary}")
	public List <Employee> getEmployeeMinSalary (@PathVariable double salary)
	{
		return employeeService.getEmployeeMinSalary (salary);
	}
	
	@RequestMapping ("/emp/salary/{min}/{max}")
	public List <Employee> getEmployeeSalaryRange (@PathVariable ("min") double min, @PathVariable ("max") double max)
	{
		return employeeService.getEmployeeSalaryRange (min, max);
	}
	
	@RequestMapping ("/emp/designation/{designation}")
	public List <Employee> getEmployeeDesignation (@PathVariable String designation)
	{
		return employeeService.getEmployeeDesignation (designation);
	}
	
	@RequestMapping (method = RequestMethod.POST, value = "/emp")
	public void addEmployee (@RequestBody Employee employee)
	{
		employeeService.addEmployee (employee);
	}

	@RequestMapping (method = RequestMethod.PUT, value = "/emp")
	public void updateEmployee (@RequestBody Employee employee)
	{
		employeeService.updateEmployee (employee);
	}
	
	@RequestMapping (method = RequestMethod.DELETE, value = "/emp/{id}")
	public void deleteEmployee (@PathVariable int id)
	{
		employeeService.deleteEmployee (id);
	}
}
