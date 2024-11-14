package com.chldbwls92.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	
//	AJAX(에이젝스)
//
//	- XML같은 거 ..
//	-  일부만 바꾸고 싶을 때? 사용하는 것 ..
//	- 순수한 데이터만을 받아서 사용하는 게? json??
//	- json 형태로 받은 걸 js에서 받아서 수정
//
//	- 페이지 이동을 새로고침 없이 서버와 통신하는 것
//	- request, response를 js 객체 형태로 주고받음
//	- 주로 view 화면이 아닌 데이터(json) 형태로 주고받음
	
	
	// response가 "data"로 구성되어있어야 됨
	// 데이터를 담은 response 구성하는 페이지(json)
	// API == 요청과 응답을 나타내는 페이지인데 데이터로 표현하는 페이지
	// 이름과 생년월일을 전달 받고, 이름과 나이를 json으로 구성한 response
	@ResponseBody
	@GetMapping("/ajax/person")
	public Map<String, Object> personInfo(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday) {
		
		int year = Integer.parseInt(birthday.substring(0, 4));
		int age = 2024 - year;
		
		// {"name":"김인규", "age":29}
		Map<String, Object> personMap = new HashMap<>();
		personMap.put("name", name);
		personMap.put("age", age);
		
		return personMap;
		
	}
	

	//js한테 직접 요청해서 직접 받기
	// (원래는 서버에서 동작하기 위해서 만든 거였음)
	// 이거는 "클라이언트에서" 동작하기 위해서 만드는 거임
	// 서버에는 영향 x
	// View
	@GetMapping("/ajax/ex01")
	public String ajaxEx() {
		return "ajax/ex01";
	}
	
	
	
	
	
	
}
