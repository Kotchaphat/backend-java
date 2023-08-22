package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Object> getEmployee(){
		try {
			List<Employee> employees= employeeReposity.findAll();
			return new ResponseEntity<>(employees,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PostMapping("/employee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee body) {
		try {
			Employee employees= employeeReposity.save(body);
			return new ResponseEntity<>(employees,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	
		}
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
		try {
			Optional<Employee> employee = employeeReposity.findById(employeeId);
			if (employee.isPresent()) {
				return new ResponseEntity<>(employee,HttpStatus.OK);
				
				
			}
			else {
				return new ResponseEntity<>("Employee not found",HttpStatus.BAD_REQUEST);
			}
				
			
		
			
		} catch (Exception e) {
			return new ResponseEntity<>("Internal Server error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
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
		public ResponseEntity<Object> deleteEmployee(@PathVariable Integer employeeID) {
			try {
				Optional<Employee> employee = employeeReposity.findById(employeeID);
			if (employee.isPresent()) {
				employeeReposity.delete(employee.get());
				return new ResponseEntity<>("Delete Sucsess",HttpStatus.OK);
				
			}	else {
				return new ResponseEntity<>("Employee not found",HttpStatus.BAD_REQUEST);
			}
			} catch (Exception e) {
				return new ResponseEntity<>("Internal Server error",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
			
		}
	}

