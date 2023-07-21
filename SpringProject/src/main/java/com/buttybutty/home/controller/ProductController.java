package com.buttybutty.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buttybutty.home.dto.PagingDTO;
import com.buttybutty.home.service.ProductService;

// 장보기
@Controller
@RequestMapping("/shop")
public class ProductController {
	@Autowired
	ProductService service;
	
	// 상품목록
	@GetMapping("/shopList")
	public String shopList(PagingDTO pDTO) {
		return "shop/shopList";
	}

	@GetMapping("/productWrite")
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/productWrite");
		return mav;
	}
	
}
