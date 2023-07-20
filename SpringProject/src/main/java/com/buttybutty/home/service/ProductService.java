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
	public List<ProductDTO> productList(PagingDTO dto);

	// �� ���ڵ� ��
	public int producttotalRecord(PagingDTO pDTO);

	// 1�� ���ڵ� ����(�۳��뺸��)
	public ProductDTO getBoard(int no);

	// ��ǰ ����(update)
	public int productEdit(BoardDTO dto);

	// ��ǰ ����(delete)
	public int productDel(int no, String userid);

}
