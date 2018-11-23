package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.beans.Employee;
import com.cg.repository.EmployeeRepository;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List <Employee> getAllEmployees ()
	{
		List <Employee> employees = new ArrayList <Employee> ();
		employeeRepository.findAll ().forEach (employees::add);
		return employees;
	}
	
	public Optional <Employee> getEmployee (int id)
	{
		return employeeRepository.findById (id);
	}
	
	public List <Employee> getEmployeeMinSalary (double salary)
	{
		return getAllEmployees ().stream ().filter (emp -> emp.getSalary () > salary).collect (Collectors.toList ());
	}
	
	public List <Employee> getEmployeeSalaryRange (double min, double max)
	{
		return getAllEmployees ().stream ().filter (emp -> emp.getSalary () >= min && emp.getSalary () <= max).collect (Collectors.toList ());
	}
	
	public List <Employee> getEmployeeDesignation (String designation)
	{
		return getAllEmployees ().stream ().filter (emp -> emp.getDesignation ().equalsIgnoreCase (designation)).collect (Collectors.toList ());
	}
	
	public void addEmployee (Employee employee)
	{
		employeeRepository.save (employee);
	}
	
	public void updateEmployee (Employee employee)
	{
		employeeRepository.save (employee);
	}
	
	public void deleteEmployee (int id)
	{
		employeeRepository.delete (getEmployee (id).get ());
	}
}
