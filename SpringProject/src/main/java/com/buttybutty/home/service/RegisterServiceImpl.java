package com.buttybutty.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buttybutty.home.dao.RegisterDAO;
import com.buttybutty.home.dto.RegisterMerchantDTO;
import com.buttybutty.home.dto.RegisterUsersDTO;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	RegisterDAO dao;
	
	@Override
	public int usersInsert(RegisterUsersDTO dto) {
		return dao.usersInsert(dto);
	}
	@Override
	public int merchantInsert(RegisterMerchantDTO dto) {
		return dao.merchantInsert(dto);
	}
	
	@Override
	public RegisterUsersDTO usersSelect(String userid, String userpwd) {
		return dao.usersSelect(userid, userpwd);
	}
	@Override
	public RegisterMerchantDTO merchantSelect(String m_userid, String m_userpwd) {
		return dao.merchantSelect(m_userid, m_userpwd);
	}
	
	@Override
	public int usersUpdate(RegisterUsersDTO dto) {
		return dao.usersUpdate(dto);
	}
	@Override
	public int merchantUpdate(RegisterMerchantDTO dto) {
		return dao.merchantUpdate(dto);
	}
	@Override
	public RegisterUsersDTO usersIdSearch(RegisterUsersDTO dto) {
		return dao.usersIdSearch(dto);
	}
	@Override
	public RegisterMerchantDTO merchantIdSearch(RegisterMerchantDTO dto) {
		return dao.merchantIdSearch(dto);
	}
	@Override
	public RegisterUsersDTO usersPwdSearch(RegisterUsersDTO dto) {
		return dao.usersPwdSearch(dto);
	}
	@Override
	public RegisterMerchantDTO merchantPwdSearch(RegisterMerchantDTO dto) {
		return dao.merchantPwdSearch(dto);
	}

	
}
