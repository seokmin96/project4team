package com.buttybutty.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/market")
public class MarketController {
	@GetMapping("marketList")
	public String marketList() {
		return "market/marketList";
	}
}
