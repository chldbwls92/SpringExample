package com.chldbwls92.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chldbwls92.spring.ex.mybatis.domain.Review;
import com.chldbwls92.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// id가 5인 리뷰 정보를 json으로 response에 담는다.
	@RequestMapping("/mybatis/review")
	@ResponseBody				//id가 전달 되어야되는데 전달 안 되면 bad request로 status 400이 발생
	public Review review(@RequestParam("id") int id) {
					// 이게 request parameter임
		//요청될 때 id라는 파라미터 이름으로 전달된 값이 뒤에(int) 저장되어서 메소드 안에서 활용됨
		// 지정한 id와 일치하는 행 가져오기
		Review review = reviewService.getReview(id);
		
		return review;
	}

}
