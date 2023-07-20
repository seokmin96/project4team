package com.buttybutty.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buttybutty.home.dao.SubscribeDAO;
import com.buttybutty.home.dto.SubscribeDTO;

@Service
public class SubscribeServiceImpl implements SubscribeService {
	// DI를 해준다. DAO에 있는 메소드를 호출하게 되고, 
		// 호출하면 매퍼.XML로 가게 된다. 거기서 쿼리문 실행하게 됨.
	@Autowired
	SubscribeDAO dao;
	
	@Override
	public int SubscribeOk(SubscribeDTO dto) {
		return dao.SubscribeOk(dto);
	}

}
