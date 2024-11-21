package com.chldbwls92.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls92.spring.ex.jpa.domain.Student;

// extends 할 수 있는 건 interface뿐
														// jpa ntt class, type
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	

}
