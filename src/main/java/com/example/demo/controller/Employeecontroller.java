package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeReposity;

@RestController

public class Employeecontroller {
	@Autowired
	EmployeeReposity employeeReposity;
	
	private List<Employee> data = new ArrayList<Employee>();
	@GetMapping("employee")
	public List<Employee> getEmployee(){
		return employeeReposity.findAll();
	}
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee body) {
		
		return employeeReposity.save(body);
		
		}
	@GetMapping("/employee/{employeeId}")
	public Optional<Employee> getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
		
		Optional<Employee> employee = employeeReposity.findById(employeeId);
		return employee;
		
	}
	
	
	@GetMapping("/employee/{employeeID}")
	public Employee getEmployeeDetail(@PathVariable Integer employeeID) {
		
		for (int i =0; i <data.size();i++) {
			if(employeeID == data.get(i).getEmployeeID()){
				return data.get(i);	
		
	}
			
	}
		return null;
	}
	@PutMapping("/employee/{employeeID}")
	public Employee updateEmployee(@PathVariable Integer employeeID,@RequestBody Employee body ) {
		Optional<Employee> employee = employeeReposity.findById(employeeID);
		
		if(employee.isPresent()) {
			Employee employeeEdit = employee.get();
			
			employeeEdit.setFirstName(body.getFirstName());
			employeeEdit.setLastName(body.getLastName());
			employeeEdit.setSalary(body.getSalary());
			
			employeeReposity.save(employeeEdit);
			
			return employee.get();
		}else {
			return null;
		}
		
	}
		@DeleteMapping("/employee/{employeeID}")
		public String deleteEmployee(@PathVariable Integer employeeID) {
			Optional<Employee> employee = employeeReposity.findById(employeeID);
			
			if(employee.isPresent()) {
				employeeReposity.delete(employee.get());
				return "Delete Employee Success";
			}else {
				return "Employee Not Found";
			}
			
			
		}
	}

