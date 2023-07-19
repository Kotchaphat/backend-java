package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController

public class Employeecontroller {

	private List<Employee> data = new ArrayList<Employee>();
	@GetMapping("employee")
	public List<Employee> getEmployee(){
		return data;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee body) {
		for (int i =0; i <data.size();i++) {
			if(data.get(i).getEmployeeID()==body.getEmployeeID()) {
				return null;
			}
		}
		data.add(body);
		return body;
		
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
		for (int i =0; i <data.size();i++) {
			if(employeeID == data.get(i).getEmployeeID()){
				data.get(i).setEmployeeID(body.getEmployeeID());
				data.get(i).setFirstName(body.getFirstName());
				data.get(i).setLastName(body.getLastName());
				data.get(i).setSalary(body.getSalary());
				
				
				return data.get(i);
			}
		
		
	}
		return null;
	}
		@DeleteMapping("/employee/{employeeID}")
		public String deleteEmployee(@PathVariable Integer employeeID) {
			for (int i = 0; i < data.size(); i++) {
				if(data.get(i).getEmployeeID().equals(employeeID)) {
					data.remove(i);
					return null;
				}
			}
			return "delete unsuccessfully";
		
	
}
	
}
