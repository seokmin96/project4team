package com.buttybutty.home.service;

import java.util.List;

import com.buttybutty.home.dto.BoardDTO;
import com.buttybutty.home.dto.MarketDTO;
import com.buttybutty.home.dto.PagingDTO;

public interface MarketService {
	public int totalRecord(PagingDTO pDTO); //총 레코드 수
	public List<MarketDTO> marketAllSelect(PagingDTO pDTO); //시장 정보의 모든 리스트
	
	public int boardtotalRecord(PagingDTO pDTO); //총 레코드 수(시장게시판)
	public List<BoardDTO> boardAllSelect(PagingDTO pDTO); //게시판의 모든 리스트
	public int boardInsert(BoardDTO dto); //글등록
	public void hitCount(int no); //조회수증가
	public BoardDTO boardOneSelect(int no); //1개 레코드 선택(글내용보기)
	public int boardEdit(BoardDTO dto); //글 수정(update)
	public int boardDel(int no, String userid); //글 삭제(delete)
}
