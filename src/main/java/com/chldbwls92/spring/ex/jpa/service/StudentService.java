package com.chldbwls92.spring.ex.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chldbwls92.spring.ex.jpa.domain.Student;
import com.chldbwls92.spring.ex.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	public Student addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		//ntt class 객체를 통해서 전달
		Student student = Student.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.build();
		
		// 그대로 테이블에 저장하는 과정(reposetory 통해서)
		// student 객체 return
		Student result = studentRepository.save(student);
		
		return result;
	}
	
	public Student updateStudent(int id, String dreamJob) {
		// repository 바로 쓸 수 있음
		// updated 대상을 조회한다.
		// 조회된 결과 객체를 얻어온다.
		// 조회된 객체에서 수정사항을 적용한다.
		// 수정된 객체를 저장한다.
		
		// Optional 객체
		// jpa가 java에 있는 optional 사용한 것
		// null일 수도 있는 객체를 null을 처리하는 기능으로 감싸놓은 객체
		// null을 다룰 때 발생될 수 있는 NullPointException 위험없이 처리하도록 도와준다.
		// null일 수도 있는 객체를 리턴하는 메소드에서 리턴타입으로 주로 사용
		Optional<Student> optionalStudent = studentRepository.findById(id);
		// null일수도 있으니 조심해서 써라~라는 의미
		
		Student student = optionalStudent.orElse(null);
									// 만약 null 이면 이거 전달 = null은 그냥 null로 return해!
		
		student = student.toBuilder().dreamJob(dreamJob).build();
		
		Student result = studentRepository.save(student);
		
		return result;
	}
	
	
	public void deletestudent(int id) {
		// 삭제 대상을 조회한다.
		// 조회된 객체를 통해 삭제한다.
		// 조회된 객체가 null일 수도 있기 때문에 optional
		Optional<Student> optionalStudent = studentRepository.findById(id);
		
		Student student = optionalStudent.orElse(null);
		
		studentRepository.delete(student);
		
	}
	
	
	
}
