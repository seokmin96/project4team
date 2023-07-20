package com.buttybutty.home.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private int mab_no; //자료실 일련번호
	private int ma_num; //시장 일련번호
	private String m_userid; //상인 아이디
	private String ma_name; //시장 이름
	private String mb_title; //자료실 글제목
	private String mb_content; //자료실 글내용
	private String mb_date; //자료실 글등록일
	private int mb_hit; //자료실 글조회수
}
