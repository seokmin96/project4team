package com.buttybutty.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buttybutty.home.dao.ProductDAO;
import com.buttybutty.home.dto.BoardDTO;
import com.buttybutty.home.dto.PagingDTO;
import com.buttybutty.home.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO dao;
	
	@Override
	public int productInsert(ProductDTO dto) {
		return dao.productInsert(dto);
	}

	@Override
	public int productTotalRecord(PagingDTO pDTO) {
		return dao.productTotalRecord(pDTO);
	}


	@Override
	public int productEdit(ProductDTO dto) {
		return dao.productEdit(dto);
	}

	@Override
	public int productDel(int no, String m_userid) {
		return dao.productDel(no, m_userid);
	}

	@Override
	public List<ProductDTO> shopList(PagingDTO pDTO) {
		return dao.productList(pDTO);
	}

	@Override
	public ProductDTO getProduct(int p_no) {
		return dao.getProduct(p_no);
	}

}
