package com.buttybutty.home.dto;

import lombok.Data;

@Data
public class ProductDTO {
	private int p_no;			// 상품번호
	private String m_userid;	// 상인아이디
	private String p_name;		// 상품명
	private String p_img;		// 상품이미지
	private String p_price;		// 상품가격
	private String p_dis;		// 상품할인률
	private String p_date;		// 상품등록날짜
	private String ma_name;		// 시장명
	private String m_name;		// 가게명
	private String p_content;	// 상품내용
	private String p_pub;		// 공개여부
	private String p_ddu;		// 떨이여부
	
}
