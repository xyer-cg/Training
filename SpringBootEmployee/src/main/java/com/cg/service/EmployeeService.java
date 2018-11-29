package com.cg.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.cg.beans.Employee;
import com.cg.repository.EmployeeRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostConstruct
	public void init ()
	{
		try
		{
			BufferedReader reader = new BufferedReader (new InputStreamReader (new ClassPathResource ("employees.json").getInputStream ()));
			List <Employee> employees = new Gson ().fromJson (reader, new TypeToken <List <Employee>> () {}.getType ());
			employees.stream ().forEach (employee -> addEmployee (employee));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
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
