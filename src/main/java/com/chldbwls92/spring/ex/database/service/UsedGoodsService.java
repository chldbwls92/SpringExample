package com.chldbwls92.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chldbwls92.spring.ex.database.domain.UsedGoods;
import com.chldbwls92.spring.ex.database.repository.UsedGoodsRepository;

// 로직(business) 담당
// 데이터 수정 가공
// 그 외에 복잡한 기능 수행
@Service
public class UsedGoodsService {
	
	@Autowired // 스프링이 알아서 만들어서 해줌
	private UsedGoodsRepository usedGoodsRepository; // 사용할 객체 멤버변수로
	
	// 중고물품 게시글 모두 얻어 오기
	public List<UsedGoods> getUsedGoodsList() {
		
		// usedgoods 테이블 조회 결과 얻어오기
		// 테이블 조회 하는 것은 service 역할 x => UsedGoodsRepository
		// spring 내부에서 객체 직접 생성하여 최소한으로 사용
		List<UsedGoods> usedGoodsList =  usedGoodsRepository.selectUsedGoodsList();
		// 우리가 만든 ntt...
		
		return usedGoodsList;
		// repository를 통해 가져와서 return
	}
}
