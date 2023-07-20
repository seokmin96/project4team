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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buttybutty.home.dto.BoardDTO;
import com.buttybutty.home.dto.PagingDTO;
import com.buttybutty.home.service.MarketService;

@Controller
@RequestMapping("/market")
public class MarketController {
	@Autowired
	MarketService service;
	//������� ����Ʈ
	@GetMapping("/marketList")
	public String marketList(Model model, PagingDTO pDTO) {
		pDTO.setTotalRecord(service.totalRecord(pDTO));
		model.addAttribute("list",service.marketAllSelect(pDTO));
		model.addAttribute("pDTO", pDTO);
		return "market/marketList";
	}
	
	//���� ���� �Խ���
	@GetMapping("/marketBoard")
	public ModelAndView boardlist(PagingDTO pDTO) {
		pDTO.setTotalRecord(service.boardtotalRecord(pDTO));
		List<BoardDTO> list = service.boardAllSelect(pDTO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("pDTO", pDTO);
		mav.setViewName("market/marketBoard");
		return mav;
	}
	//�Խ��� �۾��� ��
	@GetMapping("/marketWrite")
	public ModelAndView boardwrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("market/marketWrite");
		return mav;
	}
	//�۾��⸦ DB�� ���
	@PostMapping("/marketWriteOk")
	public ResponseEntity<String> boardwriteOk(BoardDTO dto, HttpServletRequest request) {
		dto.setM_userid( (String)request.getSession().getAttribute("logId") );
		int result = 0;
		try {
			result = service.boardInsert(dto);
		} catch (Exception e) {
			System.out.println("�Խ��� �� ��� ���ܹ߻�..."+e.getMessage());
		}
		String tag = "<script>";
		if(result>0) { //���� -> �Խ��� ���
			tag += "location.href='/home/market/marketBoard';";
		}else { //���� -> �� ��� ������ �̵�
			tag += "alert('�� ����� �����Ͽ����ϴ�.');";
			tag += "history.back();";
		}
		tag += "</script>";
		
		//ResponseEntity ��ü�� ����Ʈ�������� �ۼ��� �� �ִ�.
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", Charset.forName("UTF-8")));
		return new ResponseEntity<String>(tag, headers, HttpStatus.OK);
	}
	
	//�۳��뺸��
	@GetMapping("/marketView")
	public ModelAndView boardView(int no, PagingDTO pDTO) {
		service.hitCount(no); //��ȸ�� ����
		BoardDTO dto = service.boardOneSelect(no); //���ڵ弱��
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.addObject("pDTO", pDTO);
		mav.setViewName("market/marketView");
		
		return mav;
	}
	//�� ���� ��
	@GetMapping("/marketEdit")
	public ModelAndView marketEdit(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", service.boardOneSelect(no)); //dto ���� ���� ��� �����Է�
		mav.setViewName("market/marketEdit");
		
		return mav;
	}
	@PostMapping("/marketEditOk")
	public ModelAndView boardEditOk(BoardDTO dto, HttpSession session) {
		dto.setM_userid((String)session.getAttribute("logId"));
		
		int result = service.boardEdit(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", dto.getMab_no());
		if(result>0) { //�ۼ������� -> �� ���� ����
			mav.setViewName("redirect:marketView");
		}else { //�ۼ������� -> ����������
			mav.setViewName("redirect:marketEdit");
		}
		return mav;
	}
	//�ۻ���
	@GetMapping("/marketDel")
	public ModelAndView boardDel(int no, HttpSession session) {
		int result = service.boardDel(no, (String)session.getAttribute("logId"));
	
		ModelAndView mav = new ModelAndView();
		if(result>0) {//�������� -> ���
			mav.setViewName("redirect:marketBoard");
		}else {//�������� -> �۳���
			mav.addObject("no", no);
			mav.setViewName("redirect:marketView");
		}
		return mav;
	}
}
