package com.buttybutty.home.dao;

import java.util.List;

import com.buttybutty.home.dto.BoardDTO;
import com.buttybutty.home.dto.PagingDTO;
import com.buttybutty.home.dto.ProductDTO;

public interface ProductDAO {
	// 상품 등록
	public int productInsert(ProductDTO dto);

	// 전체 상품보기
	public List<ProductDTO> productList(PagingDTO dto);

	// 상품 하나 보기
	public ProductDTO getProduct(int p_no);

	// 총 레코드 수
	public int productTotalRecord(PagingDTO pDTO);

	// 1개 레코드 선택(글내용보기)
	public ProductDTO getBoard(int no);

	// 상품 수정(update)
	public int productEdit(ProductDTO dto);

	// 상품 삭제(delete)
	public int productDel(int no, String userid);

}