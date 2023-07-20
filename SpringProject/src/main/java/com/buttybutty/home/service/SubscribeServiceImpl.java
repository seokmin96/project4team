package com.buttybutty.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buttybutty.home.dao.SubscribeDAO;
import com.buttybutty.home.dto.SubscribeDTO;

@Service
public class SubscribeServiceImpl implements SubscribeService {
	// DI�� ���ش�. DAO�� �ִ� �޼ҵ带 ȣ���ϰ� �ǰ�, 
		// ȣ���ϸ� ����.XML�� ���� �ȴ�. �ű⼭ ������ �����ϰ� ��.
	@Autowired
	SubscribeDAO dao;
	
	@Override
	public int SubscribeOk(SubscribeDTO dto) {
		return dao.SubscribeOk(dto);
	}

}
