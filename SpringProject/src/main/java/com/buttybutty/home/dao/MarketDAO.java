package com.buttybutty.home.dao;

import java.util.List;

import com.buttybutty.home.dto.BoardDTO;
import com.buttybutty.home.dto.MarketDTO;
import com.buttybutty.home.dto.PagingDTO;

public interface MarketDAO {
	public int totalRecord(PagingDTO pDTO); //�� ���ڵ� ��
	public List<MarketDTO> marketAllSelect(PagingDTO pDTO); //���� ������ ��� ����Ʈ
	
	//�۵��
		public int boardwriteOk(BoardDTO dto);
		//�۸�� ���� (paging, search)
		public List<BoardDTO> boardlist(PagingDTO pDTO);
		//�� ���ڵ� ��
		public int boardtotalRecord(PagingDTO pDTO);
		//1�� ���ڵ� ����(�۳��뺸��)
		public BoardDTO getBoard(int no);
		//��ȸ������
		public void hitCount(int no);
		//�� ����(update)
		public int boardEdit(BoardDTO dto);
		//�� ����(delete)
		public int boardDel(int no, String userid);
}
