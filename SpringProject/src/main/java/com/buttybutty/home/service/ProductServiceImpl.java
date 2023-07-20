package com.buttybutty.home.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.buttybutty.home.dao.ProductDAO;
import com.buttybutty.home.dto.ProductDTO;

public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO dao;
	
	@Override
	public int productInsert(ProductDTO dto) {
		return dao.productInsert(dto);
	}

}
