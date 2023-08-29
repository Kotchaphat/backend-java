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
import com.example.demo.model.Role;
import com.example.demo.model.Skill;
import com.example.demo.model.Student;

import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository studentRepository;
	
	
	
	
	private List<Student> data = new ArrayList<Student>();
	
	@GetMapping("/student")
	public ResponseEntity<Object> getAllStudent() {
		try {
			List<Student> students = studentRepository.findAll();
			return new ResponseEntity<>(students, HttpStatus.OK);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@GetMapping("/students/{StudentId}")
	public ResponseEntity<Object> getStusentId(@PathVariable("StudentId")String StudentId) {
		try {
			Optional<Student>foundStudent =studentRepository.findById(StudentId);
			if (foundStudent.isPresent()) {
				
				Student student = foundStudent.get();
				return new ResponseEntity<>(student, HttpStatus.OK);
			
			
			}else {
				return new ResponseEntity<>("Student not found",HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	

	@PostMapping("/student")
	public ResponseEntity<Object> addStudent(@RequestBody Student body) {
		try {
			Student newsStudent = studentRepository.save(body);

			return new ResponseEntity<>(newsStudent, HttpStatus.CREATED);

		} catch (Exception e) {
			System.out.print(e.getMessage());
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	

	
	
	
	

	
	
	
	
	

	
	@PutMapping("/students/{StudentId}")
	public ResponseEntity<Object> updateStudent(@PathVariable("StudentId") String StudentId, @RequestBody Student body) {
	    try {
	        Optional<Student> foundStudent = studentRepository.findById(StudentId);
	        
	        if (foundStudent.isPresent()) {
	            Student studentedit = foundStudent.get();
	            studentedit.setStudentId(body.getStudentId());
	            studentedit.setName(body.getName());
	            studentedit.setEmail(body.getEmail());
	     
	           studentRepository.save(studentedit);
	            
	            return ResponseEntity.ok("Update Student Success");
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student not found");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
	    }
	}

	

	
	@DeleteMapping("/students/{StudentId}")
	public ResponseEntity<Object> deleteStudent(@PathVariable String StudentId) {
		
		try {
			Optional<Student> student = studentRepository.findById(StudentId);
			
			if(student.isPresent()) {
				
				studentRepository.delete(student.get());
				
				return new ResponseEntity<Object>("Delete Sucsess",HttpStatus.OK);
		
			}else {
				return new ResponseEntity<>("Student not found",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	

}
