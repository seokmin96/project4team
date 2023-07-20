package com.buttybutty.home.controller;

import java.net.http.HttpHeaders;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buttybutty.home.dto.SubscribeDTO;
import com.buttybutty.home.service.SubscribeService;

@Controller
public class SubscribeController {
	
	@Autowired
	SubscribeService service;
	
	@RequestMapping("/subscribe")
	public String sub(){
		return "subscribe/sub";
	}
	
	@RequestMapping("/subscribe/detail2307")
	public String SubDetail7() {
		return "subscribe/SubDetail7";
	}
	
	// 구독 신청 완료된 페이지 매핑
	@PostMapping("/subscribe/detail2307/subOk")
	public ResponseEntity<String> SubscribeOk(SubscribeDTO dto, HttpServletRequest request) { 
		
		dto.setUserid((String)request.getSession().getAttribute("logId")); 
		// getAttribute로 인해 오브젝으로 나오는 것을 스트링으로 바꾸고 dto에 userid 변수가 있으니까 셋팅
		
		// insert한 갯수를 반환해서 int형이다. 성공하면 1
		int result = 0; // 초기값 설정 (인서트 했을 때 에러나면 0을 유지한다.)
		// 예외처리를 위한 try catch 문
		try {
			result = service.SubscribeOk(dto);  // 게시글 등록 성공하면 값이 1로 변경됨
		} catch (Exception e) { //에러가 발생하면 0을 유지
			System.out.println("구독 신청에 실패했습니다. 오류 발생 : " + e.getMessage());
		}
		
		// ResponseEntity<String>의 첫번째 객체 tag 형성! 
		// 등록 결과에 따라서 스크립트를 생성하기 
		String tag = "<script>";
		if(result>0) {//성공, 게시판 목록으로 이동
			tag += "location.href='/home/subscribe';";
		}else {//실패 -> 구독 신청 페이지으로 다시 이동
			tag += "alert('구독 신청에 실패하였습니다.');";
			tag += "history.back();";  // 전에 회원가입 실패의 경우 jsp 따로 만들었었다! registerResult.jsp에다!
		}
		tag += "</script>";
		
		
		// ResponseEntity<String>의 두번째 객체 headers 형성! 
			
		return new ResponseEntity<String>(tag,HttpStatus.OK);
	}
}

