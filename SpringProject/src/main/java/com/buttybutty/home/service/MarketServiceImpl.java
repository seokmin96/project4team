package com.buttybutty.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buttybutty.home.dao.MarketDAO;
import com.buttybutty.home.dto.BoardDTO;
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

	@Override
	public int boardInsert(BoardDTO dto) {
		return dao.boardInsert(dto);
	}

	@Override
	public List<BoardDTO> boardAllSelect(PagingDTO pDTO) {
		return dao.boardAllSelect(pDTO);
	}

	@Override
	public int boardtotalRecord(PagingDTO pDTO) {
		return dao.boardtotalRecord(pDTO);
	}

	@Override
	public BoardDTO boardOneSelect(int no) {
		return dao.boardOneSelect(no);
	}

	@Override
	public void hitCount(int no) {
		dao.hitCount(no);
	}

	@Override
	public int boardEdit(BoardDTO dto) {
		return dao.boardEdit(dto);
	}

	@Override
	public int boardDel(int no, String userid) {
		return dao.boardDel(no, userid);
	}
	
}
