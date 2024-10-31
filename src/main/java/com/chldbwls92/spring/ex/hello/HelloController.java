package com.chldbwls92.spring.ex.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 어노테이션
@Controller
public class HelloController {

	// 순서 상관 x 그저 어떤 클래스, 메소드 위에 있는지가 중요해
	@ResponseBody
	@RequestMapping("/hello")
	public String helloWorld() {
		return "Hello World!!";
	}
	
}
