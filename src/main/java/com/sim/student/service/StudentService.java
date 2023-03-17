package com.sim.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sim.student.model.Student;
import com.sim.student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}
	
	public Student updateStudent(Long id, Student student) {
		student.setId(id);
		return studentRepository.save(student);
	}
	
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
