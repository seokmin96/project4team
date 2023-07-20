package com.buttybutty.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buttybutty.home.dao.ProductDAO;
import com.buttybutty.home.dto.BoardDTO;
import com.buttybutty.home.dto.PagingDTO;
import com.buttybutty.home.dto.ProductDTO;

public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO dao;
	
	@Override
	public int productInsert(ProductDTO dto) {
		return dao.productInsert(dto);
	}

	@Override
	public List<ProductDTO> productList(PagingDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int producttotalRecord(PagingDTO pDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductDTO getBoard(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int productEdit(BoardDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int productDel(int no, String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
