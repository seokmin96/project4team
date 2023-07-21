package com.buttybutty.home.dao;

import java.util.List;

import com.buttybutty.home.dto.BoardDTO;
import com.buttybutty.home.dto.PagingDTO;
import com.buttybutty.home.dto.ProductDTO;

public interface ProductDAO {
	// ��ǰ ���
	public int productInsert(ProductDTO dto);

	// ��ü ��ǰ����
	public List<ProductDTO> productList(PagingDTO dto);

	// ��ǰ �ϳ� ����
	public ProductDTO getProduct(int p_no);

	// �� ���ڵ� ��
	public int productTotalRecord(PagingDTO pDTO);

	// 1�� ���ڵ� ����(�۳��뺸��)
	public ProductDTO getBoard(int no);

	// ��ǰ ����(update)
	public int productEdit(ProductDTO dto);

	// ��ǰ ����(delete)
	public int productDel(int no, String userid);

}