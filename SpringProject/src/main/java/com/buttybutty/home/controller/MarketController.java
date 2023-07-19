package com.buttybutty.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buttybutty.home.dto.PagingDTO;
import com.buttybutty.home.service.MarketService;

@Controller
@RequestMapping("/market")
public class MarketController {
	@Autowired
	MarketService service;
	
	@GetMapping("marketList")
	public String marketList(Model model, PagingDTO pDTO) {
		pDTO.setTotalRecord(service.totalRecord(pDTO));
		model.addAttribute("list",service.marketAllSelect(pDTO));
		model.addAttribute("pDTO", pDTO);
		return "market/marketList";
	}
}
