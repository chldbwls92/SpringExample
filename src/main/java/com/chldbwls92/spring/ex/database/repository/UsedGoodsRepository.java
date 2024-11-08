package com.chldbwls92.spring.ex.database.repository;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chldbwls92.spring.ex.database.domain.UsedGoods;
// 데이터베이스 관련 처리
// Mybatis Framework	데이터베이스만을 다루는 것
@Mapper // mark up language
public interface UsedGoodsRepository {
	// 인터페이스 = 나열만 하는 것 but 클래스가 아닌 다른 방식(xml)으로 하면 돼 => mapper

	// used_goods 테이블 모든 행 조회
	// 메소드 형태로 구성
	public List<UsedGoods> selectUsedGoodsList();
}
