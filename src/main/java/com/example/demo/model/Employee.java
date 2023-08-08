package com.example.demo.model;

import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer employeeID;
	private String firstName;
	private String lastName;
	private Integer salary;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
	
	

