package com.buttybutty.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubscribeController {
	@RequestMapping("/subscribe")
	public String shopList() {
		return "subscribe/sub";
	}
}
