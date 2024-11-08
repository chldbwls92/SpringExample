package com.chldbwls92.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chldbwls92.spring.ex.mybatis.domain.Review;
import com.chldbwls92.spring.ex.mybatis.repository.ReviewRepositoy;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepositoy reviewRepository;
	
	// 전달받은 id와 대응되는 리뷰정보 얻어오기
	public Review getReview(int id) {
		// new_reivew 테이블의 id가 전달받은 값과 일치하는 행 조회
		Review review = reviewRepository.selecetReview(id);
		return review;
	}
	
	// 전달받은 리뷰 정보를 기반으로 리뷰 저장
	public int addReview(
				int storeId
				, String menu
				, String userName
				, double point
				, String review) {
			
			// 전달받은 리뷰내용으로 new_review 테이블에 insert
			int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
			
			return count;
	}
	
	// 정달 받은 review 객체를 통해 저장
	public int addReviewByObject(Review review) {
		
		// 전달받은 Review 객체로 new_review insert
		// return해주는 것은 실행된 행의 갯수 => int
		int count = reviewRepository.insertReviewByObject(review);
		return count;
		// return한 걸 그대로 return 해야된다는 게 아니라 실행된 행의 갯수 return하고싶을 때 쓰는 것
	}

}
