package com.gsitm.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class NaverItemVO {
	
	@Getter
	@Setter
	private String title;//": "<b>쟈뎅 아메리카노블랙30T 콜롬비아수프리모</b>",
	
	@Getter
	@Setter
	private String link;//": "http://shopping.naver.com/gate.nhn?id=14413949164",
	
	@Getter
	@Setter
	private String image;//": "https://shopping-phinf.pstatic.net/main_1441394/14413949164.jpg",
	
	@Getter
	@Setter
	private int lprice;//": "4890",
	
	@Getter
	@Setter
	private int hprice;//": "0",
	
	@Getter
	@Setter
	private String mallName;//": "KoreanMall",
	
	@Getter
	@Setter
	private String productId;//": "14413949164",
	
	@Getter
	@Setter
	private String productType;
}
