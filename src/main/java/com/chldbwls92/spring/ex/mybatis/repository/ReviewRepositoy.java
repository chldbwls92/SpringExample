package com.chldbwls92.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.chldbwls92.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepositoy {
	
	// 전달된 id와 일치하는 리뷰 행 조회
	
	// 정확하게 하나면 그냥 list 말고 이렇게 적으면 됨
	public Review selecetReview(@Param("id") int id);
	// 보통 임플리먼츠 해서 오버라이드 해주는데,
	// 마이마티스 통해서 xml으로 구현함
	// 마이마티스와 연결되게 해야돼서 param 어노테이션 통해서 파라미터 값 지정

}
