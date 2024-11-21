package com.chldbwls92.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chldbwls92.spring.ex.jpa.domain.Student;
import com.chldbwls92.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	// create, update, delete
	
	
	// create
	// 한 학생의 정보 저장 기능
	@ResponseBody
	@GetMapping("/create")
	public Student createStudent() {
		// 최유진, 010-1234-5678, chldbwls@naver.com, 개발자
		Student student = studentService.addStudent("최유진", "010-1234-5678", "ch@naver.com", "개발자");
		
		return student;
	}
	
	// update
	@ResponseBody
	@GetMapping("/update")
	public Student updateStudent() {
		// id가 3인 장래희망을 강사로 변경
		Student student = studentService.updateStudent(3, "강사");
		
		return student;
	}
	
	
	// delete
	@ResponseBody
	@GetMapping("/delete")
	public String deleteStudent() {
		
		//id가 3인 학생정보 삭제
		studentService.deletestudent(3);
		
		return "삭제 성공!!";
	}
	
	
	
	@ResponseBody
	@GetMapping("/lombok")
	public Student lombokTest() {
		
		// 기본 생성자 생성
//		Student student =  new Student(1, "김인규", "010-1234-5678", "lecture@hagulu.com", "개발자" , null, null);
		// annotation만 넣었는데 잘 쓸 수 있는 모습!
//		student.setName("김인규");
//		student.setEmail("lecture@hagulu.com");
//		student.setPhoneNumber("010-1234-5678");
		
		// 특정 멤버변수만 채우고 싶다면
		// builder 패턴
		Student student = Student.builder()
				.name("김인규")
				.email("lecture@hagulu.com")
				.phoneNumber("010-1234-5678")
				.build();
		
		
		
		
		return student;
		
	}

}
