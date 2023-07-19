package com.buttybutty.home.dto;

import lombok.Data;

@Data
public class MarketDTO {
	private int ma_num; //시장 일련번호
	private String ma_name; //시장이름
	private String ma_addr1; //시_도
	private String ma_addr2; //군_구
	private String ma_time; //개설주기
	private int ma_count; //점포수
	private String ma_item; //취급품목
	private int ma_toilet; //공중화장실 보유여부 (1:보유, 0:미보유)
	private int ma_parking; //주차장 보유여부 (동일)
}
