package com.buttybutty.home.dao;

import java.util.List;

import com.buttybutty.home.dto.BoardDTO;
import com.buttybutty.home.dto.MarketDTO;
import com.buttybutty.home.dto.PagingDTO;

public interface MarketDAO {
	//������� ����Ʈ
	public int totalRecord(PagingDTO pDTO); //�� ���ڵ� ��(��������)
	public List<MarketDTO> marketAllSelect(PagingDTO pDTO); //���� ������ ��� ����Ʈ
	
	//���� ���� �Խ���
	public int boardtotalRecord(PagingDTO pDTO); //�� ���ڵ� ��(����Խ���)
	public List<BoardDTO> boardAllSelect(PagingDTO pDTO); //�Խ����� ��� ����Ʈ
	public int boardInsert(BoardDTO dto); //�۵��
	public void hitCount(int no); //��ȸ������
	public BoardDTO boardOneSelect(int no); //1�� ���ڵ� ����(�۳��뺸��)
	public int boardEdit(BoardDTO dto); //�� ����(update)
	public int boardDel(int no, String userid); //�� ����(delete)
}
