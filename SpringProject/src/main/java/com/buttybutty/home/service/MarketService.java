package com.buttybutty.home.service;

import java.util.List;

import com.buttybutty.home.dto.MarketDTO;
import com.buttybutty.home.dto.PagingDTO;

public interface MarketService {
	public int totalRecord(PagingDTO pDTO); //�� ���ڵ� ��
	public List<MarketDTO> marketAllSelect(PagingDTO pDTO); //���� ������ ��� ����Ʈ

}
