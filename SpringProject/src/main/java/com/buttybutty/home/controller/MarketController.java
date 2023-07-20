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
	
	@GetMapping("marketList")
	public String marketList(Model model, PagingDTO pDTO) {
		pDTO.setTotalRecord(service.totalRecord(pDTO));
		model.addAttribute("list",service.marketAllSelect(pDTO));
		model.addAttribute("pDTO", pDTO);
		return "market/marketList";
	}
	@GetMapping("/marketBoard")
	public ModelAndView boardlist(PagingDTO pDTO) {
		//총레코드수
		pDTO.setTotalRecord(service.totalRecord(pDTO));
		
		//해당페이지의 레코드 선택
		List<BoardDTO> list = service.boardlist(pDTO);
		
		//ModelAndView
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("pDTO", pDTO);
		mav.setViewName("market/marketBoard");
		return mav;
	}
	//글쓰기 폼으로 이동
	@GetMapping("/marketwrite")
	public ModelAndView boardwrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("market/marketwrite");
		return mav;
	}
	//글쓰기 DB 기록
	@PostMapping("/marketwriteOk")
	public ResponseEntity<String> boardwriteOk(BoardDTO dto, HttpServletRequest request) {
		//HttpServletRequest -> request, HttpSession
		//HttpSession -> session
		
		//no, hit, writedate -> 오라클
		//userid -> 세션
		
		//HttpSession session = request.getSession();
		//String userid = (String)session.getAttribute("logId");
		//dto.setUserid(userid);
		//세개 합치면 아래 코드랑 동일
		dto.setM_userid( (String)request.getSession().getAttribute("logId") );
		
		int result = 0;
		try {
			result = service.boardwriteOk(dto);
		} catch (Exception e) {
			System.out.println("게시판 글 등록 예외발생..."+e.getMessage());
		}
		//등록결과에 따른 스크립트 생성하기
		String tag = "<script>";
		if(result>0) { //성공 -> 게시판 목록
			tag += "location.href='/home/board/boardlist';";
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
		//조회수 증가
		service.hitCount(no);
		//레코드선택
		BoardDTO dto = service.getBoard(no);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", dto);
		mav.addObject("pDTO", pDTO);
		mav.setViewName("board/boardView");
		
		return mav;
	}
	//글 수정 폼
	@GetMapping("/boardEdit")
	public ModelAndView boardEdit(int no) {
//		BoardDTO dto = service.getBoard(no);
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto", service.getBoard(no)); //dto 변수 생성 대신 직접입력
		mav.setViewName("board/boardEdit");
		
		return mav;
	}
	@PostMapping("/boardEditOk") //no, subject, content
	public ModelAndView boardEditOk(BoardDTO dto, HttpSession session) {
		dto.setM_userid((String)session.getAttribute("logId"));
		
		int result = service.boardEdit(dto);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", dto.getMab_no());
		if(result>0) { //글수정성공 -> 글 내용 보기
			mav.setViewName("redirect:boardView");
		}else { //글수정실패 -> 수정폼으로
			mav.setViewName("redirect:boardEdit");
		}
		return mav;
	}
	//글삭제
	@GetMapping("/boardDel")
	public ModelAndView boardDel(int no, HttpSession session) {
		int result = service.boardDel(no, (String)session.getAttribute("logId"));
	
		ModelAndView mav = new ModelAndView();
		if(result>0) {//삭제성공 -> 목록
			mav.setViewName("redirect:boardlist");
		}else {//삭제실패 -> 글내용
			mav.addObject("no", no);
			mav.setViewName("redirect:boardView");
		}
		return mav;
	}
}
