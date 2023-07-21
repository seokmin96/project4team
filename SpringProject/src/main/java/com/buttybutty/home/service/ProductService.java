package com.buttybutty.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.buttybutty.home.dto.BoardDTO;
import com.buttybutty.home.dto.PagingDTO;
import com.buttybutty.home.dto.ProductDTO;

public interface ProductService {
	// ��ǰ ���
	public int productInsert(ProductDTO dto);

	// ��ü ��ǰ����
	public List<ProductDTO> shopList(PagingDTO pDTO);

	// ��ǰ �ϳ� ����
	public ProductDTO getProduct(int p_no);

	// �� ���ڵ� ��
	public int productTotalRecord(PagingDTO pDTO);

	// ��ǰ ����(update)
	public int productEdit(ProductDTO dto);

	// ��ǰ ����(delete)
	public int productDel(int no, String userid);

}
