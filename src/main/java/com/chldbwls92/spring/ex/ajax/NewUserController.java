package com.chldbwls92.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chldbwls92.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/ajax/user")
public class NewUserController {
	
	@Autowired
	private UserService userService;
	
	// 사용자 추가 API 
	// 기능 부여까지는 같음 response에서 다른 거
	@ResponseBody
	@PostMapping("/create")
	public Map<String, String> createUser(
			@RequestParam("name")String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce) {
		
		// userService 이미 만들어놓은 기능이 있으니 사용하자
		int count = userService.addUser(name, birthday, email, introduce);
		
		//json 규격으로 만들면 data로 완성
		Map<String, String> resultMap = new HashMap<>();
		// 성공 {"result" : "success"}
		// 실패 {"result" : "fail"}
		
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	// View
	// (api)와 다른 보여지는 페이지
	// data(api)페이지 와 view페이진
	@GetMapping("/input")
	public String userInput() {
		return "ajax/userInput";
	}
	
	
	
	
}
