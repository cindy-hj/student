package com.sim.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sim.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
