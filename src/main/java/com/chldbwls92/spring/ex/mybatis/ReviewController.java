package com.chldbwls92.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chldbwls92.spring.ex.mybatis.domain.Review;
import com.chldbwls92.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// id가 5인 리뷰 정보를 json으로 response에 담는다.
	@RequestMapping("")
	@ResponseBody				//id가 전달 되어야되는데 전달 안 되면 bad request로 status 400이 발생
	public Review review(@RequestParam("id") int id) {
					// 이게 request parameter임
		//요청될 때 id라는 파라미터 이름으로 전달된 값이 뒤에(int) 저장되어서 메소드 안에서 활용됨
		// 지정한 id와 일치하는 행 가져오기
		Review review = reviewService.getReview(id);
		
		return review;
	}
	
	// 리뷰내용을 저장하는 기능
	@RequestMapping("/create")
	@ResponseBody
	public String createReview() {
		
		// 4, 치즈피자, 김인규, 4,5 , 어쩌구저쩌구
//		int count = reviewService.addReview(4, "치즈피자", "김인규", 4.5, "어쩌구");
		
		// 2, 뿌링클, 김인규, 4.0, 역시 뿌링클은 진리입니다!
		// 하나로 묶어서(ntt class 객체 활용) 써보자~
		// 기본 생성자로 가져와서 setta로 값 채워보자~
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다");
		
		// 저장할 내용을 하나의 객체로 구성해서 하나의 덩어리로 만든다~
		// Review 객체로 구성된 리뷰 내용을 저장한다.
		int count = reviewService.addReviewByObject(review);
		
		
		
		return "삽입 결과 : " + count;
	}
	
	
	

}
