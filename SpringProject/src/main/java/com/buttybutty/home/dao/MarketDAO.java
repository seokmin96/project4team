package com.buttybutty.home.dao;

import java.util.List;

import com.buttybutty.home.dto.BoardDTO;
import com.buttybutty.home.dto.MarketDTO;
import com.buttybutty.home.dto.PagingDTO;

public interface MarketDAO {
	public int totalRecord(PagingDTO pDTO); //총 레코드 수
	public List<MarketDTO> marketAllSelect(PagingDTO pDTO); //시장 정보의 모든 리스트
	
	//글등록
		public int boardwriteOk(BoardDTO dto);
		//글목록 선택 (paging, search)
		public List<BoardDTO> boardlist(PagingDTO pDTO);
		//총 레코드 수
		public int boardtotalRecord(PagingDTO pDTO);
		//1개 레코드 선택(글내용보기)
		public BoardDTO getBoard(int no);
		//조회수증가
		public void hitCount(int no);
		//글 수정(update)
		public int boardEdit(BoardDTO dto);
		//글 삭제(delete)
		public int boardDel(int no, String userid);
}
