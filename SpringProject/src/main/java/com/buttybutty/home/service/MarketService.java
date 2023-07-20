package com.buttybutty.home.service;

import java.util.List;

import com.buttybutty.home.dto.MarketDTO;
import com.buttybutty.home.dto.PagingDTO;

public interface MarketService {
	public int totalRecord(PagingDTO pDTO); //총 레코드 수
	public List<MarketDTO> marketAllSelect(PagingDTO pDTO); //시장 정보의 모든 리스트

}
