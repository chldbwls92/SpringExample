package com.chldbwls92.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chldbwls92.spring.ex.mvc.domain.User;
import com.chldbwls92.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/mvc/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	// 사용자 정보를 request 파라미터로 전달받고, 저장하는 기능
	// POST method 방식으로
//	@RequestMapping(path="/create", method=RequestMethod.POST)
	@ResponseBody
	@PostMapping("/create")
	public String createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce) {
		
		int count = userService.addUser(name, birthday, email, introduce);
		return "삽입 성공 : " + count;
	}
	
	//경로니까 String
	// 요청하면 html 화면 보여주는 메소드
	@GetMapping("/input")
	public String userInput() {
		return "mvc/userInput";
	}
	
	@GetMapping("/info")	// 스프링이 호출해주는 것
	public String userInfo(Model model) {
		
		// 가장 최근에 등록한 한명 정보 얻어오기
		User user = userService.getLastUser();
		
		// 매개체 필요(모델)
		// 리턴한 경로의 html에서 사용할 데이터를 model에 추가한다
		// key value 형태
		model.addAttribute("title", "마지막 사용자 정보");
		model.addAttribute("result", user);
		
		return "mvc/userInfo";
	}
	
	
	
}
