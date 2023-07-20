package com.buttybutty.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// ¿Â∫∏±‚
@Controller
@RequestMapping("/shop")
public class ProductController {

	@GetMapping("/shopList")
	public String shopList() {
		return "shop/shopList";
	}

	@GetMapping("/productWrite")
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/productWrite");
		return mav;
	}
}
