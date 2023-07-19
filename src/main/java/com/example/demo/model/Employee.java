package com.example.demo.model;

import org.springframework.web.bind.annotation.RequestMapping;


public class Employee {
	private Integer employeeID;
	private String firstName;
	private String lastName;
	private Integer salary;
	
	public Employee() {
		super();
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer EmployeeID) {
		employeeID = EmployeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Employee(Integer EmployeeID, String FirstName, String LastName, Integer Salary) {
		super();
		this.employeeID = EmployeeID;
		this.firstName = FirstName;
		this.lastName = LastName;
		this.salary = Salary;
	}
	
}
	
	

