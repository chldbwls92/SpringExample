package com.chldbwls92.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {
	
	@RequestMapping("/lifecycle/ex02")
	public String thymleafEx() {
		return "lifecycle/ex02";  //url이면 앞에 슬래쉬 붙이고, 경로면 붙이지 말자
		// responseBody를 붙이면 return이 body가 되기 때문에 responseBody annotation 붙이면 안 됨
	}
	
	
	
}
