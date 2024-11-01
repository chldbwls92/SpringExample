package com.chldbwls92.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chldbwls92.spring.ex.database.domain.UsedGoods;
import com.chldbwls92.spring.ex.database.service.UsedGoodsService;

// request, response 처리
@Controller 
public class UsedGoodsController {
	
	@Autowired   // 스프링 내부에서 서비스에서 객체를 가져와서 쓸 때 알아서 자동으로 관리해줘
	private UsedGoodsService usedGoodsService;
	
	
	// used_goods 테이블의 모든 정보를 json으로 response에 담는다.
	@RequestMapping("/db/usedgoods/list")
	@ResponseBody
	public List<UsedGoods> usedGoodsList() {
		
		// 중고 물품 게시글 정보 얻어오기 => controller 담당 x => usedGoodsService
		// controller -> service -> repository
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		// 서비스에서 정보 다 가져와서 리스트에 담은 후
		//알아서 json으로 변경 후에 responsebody에 담아서 return
		return usedGoodsList;
	}

}
