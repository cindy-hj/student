package com.sim.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sim.student.model.Student;
import com.sim.student.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService studentService;

	// create
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student createStudent = studentService.createStudent(student);
		return new ResponseEntity<Student>(createStudent, HttpStatus.CREATED);
	}
	
	// read
	@GetMapping("/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> list = studentService.getAllStudent();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}

	// update
	@PutMapping("/editStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
		Student editedStudent = studentService.updateStudent(id, student);
		return new ResponseEntity<Student>(editedStudent, HttpStatus.OK);
	}
	
	// delete
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}
