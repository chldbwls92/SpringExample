package com.chldbwls92.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 해당 클래스의 모든 메소드에 @ResponseBody가 적용된다
@RestController   // @Controller + @ResponseBody
@RequestMapping("/lifecycle/ex01") // 공통적인 요소로 시작하기 때문에 뒤에만 적어주면 됨
public class Ex02RestController {
	
	// 직접 만든 클래스 객체 리턴
	@RequestMapping("/3")
	// 타입은 클래스 이름
	public Person objectResponse() {
		Person me = new Person("김인규", 31);
		
		return me;
	}
	
	// status code 적용
	// 2xx = 성공, 4xx = client 오류, 5xx = 서버 에러
	// 임의로 변경 가능!!
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse() {
		
		Person me = new Person("김인규", 31);
		// 리스펀스 바디 뿐 아니라 헤더까지 내가 지정할 거야!!
												//리스펀스 바디에 들어갈 정보, 스테이터스코드
		ResponseEntity<Person> entity = new ResponseEntity(me,HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
	}
	

}
