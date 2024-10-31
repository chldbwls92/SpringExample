package com.chldbwls92.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 어노테이션
@Controller
public class HelloController {

	// 순서 상관 x 그저 어떤 클래스, 메소드 위에 있는지가 중요해
	@ResponseBody //리턴타입 지정해서 그 타입으로 return해주면 그대로 담기게 해주는 annotation
	@RequestMapping("/hello")  // 하나의 클래스에서 여러 url mapping통해서 여러 페이지 생성 가능
	public String helloWorld() {
		return "Hello World!!";
	}
	
	//jackson library
	// 객체 json으로 만들어주는 것
	// responsebody 가 객체ㅡ 자료구조 자동으로 json으로 바꿔주는 거 ...
	// => 이래서 자동으로 json으로 바뀌는구나~
	
	
	
}
