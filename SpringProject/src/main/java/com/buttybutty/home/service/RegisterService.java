package com.buttybutty.home.service;

import com.buttybutty.home.dto.RegisterMerchantDTO;
import com.buttybutty.home.dto.RegisterUsersDTO;

public interface RegisterService {
	
	public int usersInsert(RegisterUsersDTO dto); //개인회원 회원가입
	public int merchantInsert(RegisterMerchantDTO dto); //시장상인 회원가입
	
	public RegisterUsersDTO usersSelect(String userid, String userpwd); //개인회원 로그인
	public RegisterMerchantDTO merchantSelect(String m_userid, String m_userpwd); //시장상인 로그인
	
	public int usersUpdate(RegisterUsersDTO dto); //개인회원 회원수정
	public int merchantUpdate(RegisterMerchantDTO dto); //시장상인 회원수정
	
	public RegisterUsersDTO usersIdSearch(RegisterUsersDTO dto); //개인회원 아이디찾기
	public RegisterMerchantDTO merchantIdSearch(RegisterMerchantDTO dto); //시장상인 아이디찾기
	
	public RegisterUsersDTO usersPwdSearch(RegisterUsersDTO dto); //개인회원 아이디찾기
	public RegisterMerchantDTO merchantPwdSearch(RegisterMerchantDTO dto); //시장상인 아이디찾기
}
