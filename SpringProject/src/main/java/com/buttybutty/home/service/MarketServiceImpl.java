package com.buttybutty.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buttybutty.home.dao.MarketDAO;
import com.buttybutty.home.dto.MarketDTO;
import com.buttybutty.home.dto.PagingDTO;

@Service
public class MarketServiceImpl implements MarketService {
	@Autowired
	MarketDAO dao;
	
	@Override
	public List<MarketDTO> marketAllSelect(PagingDTO pDTO) {
		return dao.marketAllSelect(pDTO);
	}

	@Override
	public int totalRecord(PagingDTO pDTO) {
		return dao.totalRecord(pDTO);
	}
	
}
