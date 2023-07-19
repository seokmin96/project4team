package com.buttybutty.home.dto;

import lombok.Data;

@Data
public class RegisterMerchantDTO {
	private String m_userid;
	private String m_username;
	private String m_userpwd;
	private String tel;
	private String email;
	private String ma_name;
	private String m_name;
	private String m_tel;
	private String m_addr;
	private String m_rnum;
	
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
