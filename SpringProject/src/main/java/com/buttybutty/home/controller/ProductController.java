package com.buttybutty.home.controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.buttybutty.home.dto.PagingDTO;
import com.buttybutty.home.dto.ProductDTO;
import com.buttybutty.home.service.ProductService;

// 장보기
@RestController
@RequestMapping("/shop")
public class ProductController {
	@Autowired
	ProductService service;
	
	// 상품목록
	@GetMapping("/shopList")
	public ModelAndView shopList(PagingDTO pDTO) {
		
		pDTO.setTotalRecord(service.productTotalRecord(pDTO));
		List<ProductDTO> list = service.shopList(pDTO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list",list);
		mav.addObject("pDTO", pDTO);
		mav.setViewName("shop/shopList");
		return mav;
	}
	
	// 상품등록 폼
	@GetMapping("/productWrite")
	public ModelAndView productWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/productWrite");
		return mav;
	}
	
	// 상품등록 DB에 기록
	@PostMapping("/productWriteOk")
	public ResponseEntity<String> productWriteOk(ProductDTO dto, HttpServletRequest request) {
		//no(시퀀스), hit(0), writedate(오늘날짜) -> 오라클에서 처리
		//userid -> session에 있음
		//ip -> request객체에 있음
		//	HttpServletRequest 는 request, HttpSession 객체 둘 다 가짐
		dto.setM_userid((String)request.getSession().getAttribute("logId"));		
		int result = 0;
		try {
			result = service.productInsert(dto);
		} catch (Exception e) {
			System.out.println("상품 등록 예외 발생..." + e.getMessage());
		}
		
		//등록 결과에 따라 스크립트 생성하기 (@RestController 는 자바스크립트를 사용가능?)
		String tag = "<script>";
		if(result>0) {
			tag += "location.href='/home/shop/shopList';";
		}//성공 -> 게시판목록으로 이동
		else {
			tag += "alert('상품등록이 실패하였습니다.');";
			tag += "history.back();";	
		} //실패 -> 상품등록 폼으로 이동
		tag += "</script>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html",Charset.forName("UTF-8")));
		
		//ResponseEntity 객체는 프론트페이지를 작성할 수 있다.
		return new ResponseEntity<String>(tag, headers, HttpStatus.OK);
	}
		//상품 상세 내용 보기
		@GetMapping("/productView")
		public ModelAndView productView(int no, PagingDTO pDTO) {
			ProductDTO dto = service.getProduct(no); //레코드 선택
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("dto", dto);
			mav.addObject("pDTO", pDTO);
			mav.setViewName("shop/productView");
			return mav;
		}
		// 상품 수정 폼
		@GetMapping("/productEdit")
		public ModelAndView productEdit(int no) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("dto", service.getProduct(no));
			mav.setViewName("shop/productEdit");
			return mav;
		}
		// 상품 수정 DB에 기록
		@PostMapping("/productEditOk")
		public ModelAndView productEditOk(ProductDTO dto, HttpSession session) {
			dto.setM_userid((String)session.getAttribute("logId"));
			
			int result = service.productEdit(dto);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("no", dto.getP_no());
			if(result>0){//성공 -> 상품 상세 보기로 이동
				mav.setViewName("redirect:productView");
			} else{//실패 -> 수정폼으로 다시 이동
				mav.setViewName("redirect:productEdit");
			}
			return mav;
		}
		// 상품 삭제
		@GetMapping("/productDel")
		public ModelAndView productDel(int no, HttpSession session) {
			int result = service.productDel(no, (String)session.getAttribute("logId"));
			
			ModelAndView mav = new ModelAndView();
			if(result>0) { //성공 -> 상품 목록으로 이동
				mav.setViewName("redirect:shoptList");
			}else { //실패 -> 상품 내용보기로 이동
				mav.addObject("no", no);
				mav.setViewName("redirect:productView");
			}
			return mav;
		}
}
