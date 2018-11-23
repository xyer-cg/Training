package com.cg.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee
{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private double salary;
	private String designation;

	public Employee ()
	{
		super ();
	}
	
	public Employee (int id, String name, double salary, String designation)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}

	public int getId ()
	{
		return id;
	}

	public void setId (int id)
	{
		this.id = id;
	}

	public String getName ()
	{
		return name;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public double getSalary ()
	{
		return salary;
	}

	public void setSalary (double salary)
	{
		this.salary = salary;
	}

	public String getDesignation ()
	{
		return designation;
	}

	public void setDesignation (String designation)
	{
		this.designation = designation;
	}

	@Override
	public String toString ()
	{
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", designation=" + designation + "]";
	}
}
