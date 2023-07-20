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
	//전통시장 리스트
	@GetMapping("/marketList")
	public String marketList(Model model, PagingDTO pDTO) {
		pDTO.setTotalRecord(service.totalRecord(pDTO));
		model.addAttribute("list",service.marketAllSelect(pDTO));
		model.addAttribute("pDTO", pDTO);
		return "market/marketList";
	}
	
	//시장 정보 게시판
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
	//게시판 글쓰기 폼
	@GetMapping("/marketWrite")
	public ModelAndView boardwrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("market/marketWrite");
		return mav;
	}
	//글쓰기를 DB에 기록
	@PostMapping("/marketWriteOk")
	public ResponseEntity<String> boardwriteOk(BoardDTO dto, HttpServletRequest request) {
		dto.setM_userid( (String)request.getSession().getAttribute("logId") );
		int result = 0;
		try {
			result = service.boardInsert(dto);
		} catch (Exception e) {
			System.out.println("게시판 글 등록 예외발생..."+e.getMessage());
		}
		String tag = "<script>";
		if(result>0) { //성공 -> 게시판 목록
			tag += "location.href='/home/market/marketBoard';";
		}else { //실패 -> 글 등록 폼으로 이동
			tag += "alert('글 등록이 실패하였습니다.');";
			tag += "history.back();";
		}
		tag += "</script>";
		
		//ResponseEntity 객체는 프론트페이지를 작성할 수 있다.
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text","html", Charset.forName("UTF-8")));
		return new ResponseEntity<String>(tag, headers, HttpStatus.OK);
	}
	
	//글내용보기
	@GetMapping("/marketView")
	public ModelAndView boardView(int no, PagingDTO pDTO) {
		service.hitCount(no); //조회수 증가
		BoardDTO dto = service.boardOneSelect(no); //레코드선택
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.addObject("pDTO", pDTO);
		mav.setViewName("market/marketView");
		
		return mav;
	}
	//글 수정 폼
	@GetMapping("/marketEdit")
	public ModelAndView marketEdit(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", service.boardOneSelect(no)); //dto 변수 생성 대신 직접입력
		mav.setViewName("market/marketEdit");
		
		return mav;
	}
	@PostMapping("/marketEditOk")
	public ModelAndView boardEditOk(BoardDTO dto, HttpSession session) {
		dto.setM_userid((String)session.getAttribute("logId"));
		
		int result = service.boardEdit(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", dto.getMab_no());
		if(result>0) { //글수정성공 -> 글 내용 보기
			mav.setViewName("redirect:marketView");
		}else { //글수정실패 -> 수정폼으로
			mav.setViewName("redirect:marketEdit");
		}
		return mav;
	}
	//글삭제
	@GetMapping("/marketDel")
	public ModelAndView boardDel(int no, HttpSession session) {
		int result = service.boardDel(no, (String)session.getAttribute("logId"));
	
		ModelAndView mav = new ModelAndView();
		if(result>0) {//삭제성공 -> 목록
			mav.setViewName("redirect:marketBoard");
		}else {//삭제실패 -> 글내용
			mav.addObject("no", no);
			mav.setViewName("redirect:marketView");
		}
		return mav;
	}
}
