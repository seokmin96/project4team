package com.buttybutty.home.dto;

import lombok.Data;

@Data
public class RegisterMerchantDTO {
	private String m_userid; //아이디
	private String m_username; //이름
	private String m_userpwd; //비밀번호
	private String tel; //연락처
	private String m_email; //이메일
	private String ma_name; //시장이름
	private String m_tel; //가게 전화번호
	private String m_addr; //가게 주소
	private String m_rnum; //사업자 등록번호
	
	private String tel1;
	private String tel2;
	private String tel3;
	
	public String getTel() {
		return tel1 + "-" + tel2 + "-" + tel3;
	}
	public void setTel(String tel) {
			this.tel = tel;
			// -를 기준으로 연락처를 자른다
			String t[] = tel.split("-");
			tel1 = t[0];
			tel2 = t[1];
			tel3 = t[2];
	}
}
