package com.chldbwls92.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chldbwls92.spring.ex.mvc.domain.User;
import com.chldbwls92.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired // 스프링이 알아서 객체 주입
	private UserRepository userRepository;
	
	public int addUser(
			String name
			, String birthday
			, String email
			, String introdeuce) {
		
		int count = userRepository.insertUser(name, birthday, email, introdeuce);
		return count;
	}
	
	public User getLastUser() {
		User user = userRepository.selectLastUser();
		
		return user;
	}
	
	public boolean isDuplicateEmail(String email) {
		// count 함수를 이용해서 조회되면 1 아니면 0이니까 count쿼리 수행
		
	}

}
