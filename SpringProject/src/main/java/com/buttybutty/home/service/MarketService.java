package com.buttybutty.home.service;

import java.util.List;

import com.buttybutty.home.dto.BoardDTO;
import com.buttybutty.home.dto.MarketDTO;
import com.buttybutty.home.dto.PagingDTO;

public interface MarketService {
	public int totalRecord(PagingDTO pDTO); //�� ���ڵ� ��
	public List<MarketDTO> marketAllSelect(PagingDTO pDTO); //���� ������ ��� ����Ʈ
	
	public int boardwriteOk(BoardDTO dto);
	public List<BoardDTO> boardlist(PagingDTO pDTO);
	public int boardtotalRecord(PagingDTO pDTO);
	public BoardDTO getBoard(int no);
	public void hitCount(int no);
	public int boardEdit(BoardDTO dto);
	public int boardDel(int no, String userid);
}
