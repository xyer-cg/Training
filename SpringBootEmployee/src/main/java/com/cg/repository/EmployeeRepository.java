package com.cg.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.beans.Employee;

public interface EmployeeRepository extends CrudRepository <Employee, Integer>
{
	
}
