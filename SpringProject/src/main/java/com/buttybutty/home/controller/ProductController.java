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

// �庸��
@RestController
@RequestMapping("/shop")
public class ProductController {
	@Autowired
	ProductService service;
	
	// ��ǰ���
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
	
	// ��ǰ��� ��
	@GetMapping("/productWrite")
	public ModelAndView productWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/productWrite");
		return mav;
	}
	
	// ��ǰ��� DB�� ���
	@PostMapping("/productWriteOk")
	public ResponseEntity<String> productWriteOk(ProductDTO dto, HttpServletRequest request) {
		//no(������), hit(0), writedate(���ó�¥) -> ����Ŭ���� ó��
		//userid -> session�� ����
		//ip -> request��ü�� ����
		//	HttpServletRequest �� request, HttpSession ��ü �� �� ����
		dto.setM_userid((String)request.getSession().getAttribute("logId"));		
		int result = 0;
		try {
			result = service.productInsert(dto);
		} catch (Exception e) {
			System.out.println("��ǰ ��� ���� �߻�..." + e.getMessage());
		}
		
		//��� ����� ���� ��ũ��Ʈ �����ϱ� (@RestController �� �ڹٽ�ũ��Ʈ�� ��밡��?)
		String tag = "<script>";
		if(result>0) {
			tag += "location.href='/home/shop/shopList';";
		}//���� -> �Խ��Ǹ������ �̵�
		else {
			tag += "alert('��ǰ����� �����Ͽ����ϴ�.');";
			tag += "history.back();";	
		} //���� -> ��ǰ��� ������ �̵�
		tag += "</script>";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html",Charset.forName("UTF-8")));
		
		//ResponseEntity ��ü�� ����Ʈ�������� �ۼ��� �� �ִ�.
		return new ResponseEntity<String>(tag, headers, HttpStatus.OK);
	}
		//��ǰ �� ���� ����
		@GetMapping("/productView")
		public ModelAndView productView(int no, PagingDTO pDTO) {
			ProductDTO dto = service.getProduct(no); //���ڵ� ����
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("dto", dto);
			mav.addObject("pDTO", pDTO);
			mav.setViewName("shop/productView");
			return mav;
		}
		// ��ǰ ���� ��
		@GetMapping("/productEdit")
		public ModelAndView productEdit(int no) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("dto", service.getProduct(no));
			mav.setViewName("shop/productEdit");
			return mav;
		}
		// ��ǰ ���� DB�� ���
		@PostMapping("/productEditOk")
		public ModelAndView productEditOk(ProductDTO dto, HttpSession session) {
			dto.setM_userid((String)session.getAttribute("logId"));
			
			int result = service.productEdit(dto);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("no", dto.getP_no());
			if(result>0){//���� -> ��ǰ �� ����� �̵�
				mav.setViewName("redirect:productView");
			} else{//���� -> ���������� �ٽ� �̵�
				mav.setViewName("redirect:productEdit");
			}
			return mav;
		}
		// ��ǰ ����
		@GetMapping("/productDel")
		public ModelAndView productDel(int no, HttpSession session) {
			int result = service.productDel(no, (String)session.getAttribute("logId"));
			
			ModelAndView mav = new ModelAndView();
			if(result>0) { //���� -> ��ǰ ������� �̵�
				mav.setViewName("redirect:shoptList");
			}else { //���� -> ��ǰ ���뺸��� �̵�
				mav.addObject("no", no);
				mav.setViewName("redirect:productView");
			}
			return mav;
		}
}
