package com.buttybutty.home.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buttybutty.home.dto.RegisterMerchantDTO;
import com.buttybutty.home.dto.RegisterUsersDTO;
import com.buttybutty.home.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	RegisterService service;
	
	@Autowired
	JavaMailSenderImpl mailSender;
	
	
	//회원가입 폼
	@GetMapping("/reg")
	public String reg() {
		return "register/regForm";
	}
	//개인회원 회원가입 확인
	@PostMapping("/registerOkUsers")
	public ModelAndView registerOkUsers(RegisterUsersDTO dto) {
		int result = 0;
		try {
				result = service.usersInsert(dto);
		} catch (Exception e) {
				System.out.println("회원가입 실패....." + e.getMessage());
		}
		ModelAndView mav = new ModelAndView();
		if(result>0){ //성공 - 홈으로 이동
				mav.setViewName("redirect:/");
		}
		else{ //실패 - 회원가입으로 이동
				mav.setViewName("register/registerResult");
		}
		return mav;
	}
	//상인 회원가입 확인
	@PostMapping("/registerOkMerchant")
	public ModelAndView registerOkMerchant(RegisterMerchantDTO dto) {
		int result = 0;
		try {
			result = service.merchantInsert(dto);
		} catch (Exception e) {
			System.out.println("회원가입 실패....." + e.getMessage());
		}
		ModelAndView mav = new ModelAndView();
		if(result>0){ //성공 - 홈으로 이동
			mav.setViewName("redirect:/");
		}
		else{ //실패 - 회원가입으로 이동
			mav.setViewName("register/registerResult");
		}
		return mav;
	}
	
	
	//로그인 폼
	@GetMapping("/login")
	public String login() {
		return "register/login";
	}
	//개인회원 로그인 확인
	@PostMapping("/loginOkUsers")
	public ModelAndView loginOkUsers(String userid, String userpwd, HttpSession session) {
			RegisterUsersDTO dto = service.usersSelect(userid, userpwd);
			ModelAndView mav = new ModelAndView();
			if(dto!= null) {//성공 -> 홈으로 이동
					//세션에 아이디,이름,로그인상태 기록
					session.setAttribute("logId", dto.getUserid());
					session.setAttribute("logName", dto.getUsername());
					session.setAttribute("logStatus", "Y");
					session.setAttribute("logType", "U");
					mav.setViewName("redirect:/");
			}else {//실패 -> 로그인 폼으로 다시 이동
					mav.setViewName("redirect:login");
			}
			return mav;
	}
	//상인 로그인 확인
	@PostMapping("/loginOkMerchant")
	public ModelAndView loginOkMerchant(String userid, String userpwd, HttpSession session) {
			RegisterMerchantDTO dto = service.merchantSelect(userid, userpwd);
			ModelAndView mav = new ModelAndView();
			if(dto!= null) {//성공 -> 홈으로 이동
					//세션에 아이디,이름,로그인상태 기록
					session.setAttribute("logId", dto.getM_userid());
					session.setAttribute("logName", dto.getM_username());
					session.setAttribute("logStatus", "Y");
					session.setAttribute("logType", "M");
					mav.setViewName("redirect:/");
			}else {//실패 -> 로그인 폼으로 다시 이동
					mav.setViewName("redirect:login");
			}
			return mav;
	}
	//로그아웃
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate(); //session 객체 지움 -> 새로운 session객체 할당됨
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	//마이페이지
	@GetMapping("/mypage")
	public String mypage() {
		return "register/mypage";
	}
	//개인회원 회원정보수정을 위한 비밀번호 확인
	@GetMapping("/pwdChkUsers")
	public String pwdChkUsers() {
		return "register/pwdChkUsers";
	}
	//개인회원 회원정보수정 폼
	@PostMapping("/editUsers")
	public ModelAndView editUsers(String userpwd, HttpSession session) {
		String userid = (String)session.getAttribute("logId");
		ModelAndView mav = new ModelAndView();
		RegisterUsersDTO dto = service.usersSelect(userid, userpwd);
		mav.addObject("dto", dto);
		if(dto != null && dto.getUserpwd().equals(userpwd)) {
			mav.setViewName("/register/editUsers");
		}else {
			mav.setViewName("/register/editResult");
		}
		return mav;
	}
	//개인 회원정보수정 확인
	@PostMapping("/editOkUsers")
	public String editOkUsers(RegisterUsersDTO dto) {
		int result = service.usersUpdate(dto);
		if(result>0) {
			return "/register/mypage";
		}else {
			return "/register/editUsers";
		}
	}
	//상인 회원정보수정을 위한 비밀번호 확인
	@GetMapping("/pwdChkMerchant")
	public String pwdChkMerchant() {
		return "register/pwdChkMerchant";
	}
	//상인 회원정보수정 폼
	@PostMapping("/editMerchant")
	public ModelAndView editMerchant(String m_userpwd, HttpSession session) {
		String m_userid = (String)session.getAttribute("logId");
		ModelAndView mav = new ModelAndView();
		RegisterMerchantDTO dto = service.merchantSelect(m_userid, m_userpwd);
		mav.addObject("dto", dto);
		if(dto != null && dto.getM_userpwd().equals(m_userpwd)) {
			mav.setViewName("/register/editMerchant");
		}else {
			mav.setViewName("/register/editResult");
		}
		return mav;
	}
	//상인 회원정보수정 확인
	@PostMapping("/editOkMerchant")
	public String editOkMerchant(RegisterMerchantDTO dto) {
		int result = service.merchantUpdate(dto);
		if(result>0) {
			return "/register/mypage";
		}else {
			return "/register/editMerchant";
		}
	}
	

	//아이디 찾기 폼
	@GetMapping("/idSearch")
	public String idSearchForm() {
		return "register/idSearch";
	}
	//개인회원 아이디 찾기
	@PostMapping("/idSearchOkUsers")
	@ResponseBody //ajax에게 뷰가 아닌 것을 반환
	public String idSearchOkUsers(RegisterUsersDTO dto) {
		//이름, 연락처가 일치하는 아이디와 이메일을 구한다.
		RegisterUsersDTO resultDTO = service.usersIdSearch(dto);
		String resultTxt = "N";
		
		if(resultDTO!=null) { //일치하는 정보가 있을 때
			//이메일 보내기
			String subject = "아이디 찾기 결과";
			String content = "<div style='background:pink; border:1px solid #ddd; padding:50px; text-align:center;'>";
			content += "검색한 아이디는 : " + resultDTO.getUserid();
			content += "</div>";
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("minjee3333@naver.com"); //보내는 메일 주소
				messageHelper.setTo(resultDTO.getEmail()); //받는 메일 주소
				messageHelper.setSubject(subject); //메일 제목
				messageHelper.setText("text/html; charset=UTF-8",content); //헤더와 메일 내용
				mailSender.send(message);
				resultTxt = "Y";
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else { //일치하는 정보가 없을 때
			resultTxt = "N";
		}
		
		return resultTxt;
	}
	//시장상인 아이디 찾기
	@PostMapping("/idSearchOkMerchant")
	@ResponseBody //ajax에게 뷰가 아닌 것을 반환
	public String idSearchOkMerchant(RegisterMerchantDTO dto) {
		//이름, 연락처가 일치하는 아이디와 이메일을 구한다.
		RegisterMerchantDTO resultDTO = service.merchantIdSearch(dto);
		String resultTxt = "N";
		
		if(resultDTO!=null) { //일치하는 정보가 있을 때
			//이메일 보내기
			String subject = "아이디 찾기 결과";
			String content = "<div style='background:pink; border:1px solid #ddd; padding:50px; text-align:center;'>";
			content += "검색한 아이디는 : " + resultDTO.getM_userid();
			content += "</div>";
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("minjee3333@naver.com"); //보내는 메일 주소
				messageHelper.setTo(resultDTO.getEmail()); //받는 메일 주소
				messageHelper.setSubject(subject); //메일 제목
				messageHelper.setText("text/html; charset=UTF-8",content); //헤더와 메일 내용
				mailSender.send(message);
				resultTxt = "Y";
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else { //일치하는 정보가 없을 때
			resultTxt = "N";
		}
		
		return resultTxt;
	}

	//비밀번호 찾기 폼
	@GetMapping("/pwdSearch")
	public String pwSearchForm() {
		return "register/pwdSearch";
	}
	// 개인회원 비밀번호 찾기
	@PostMapping("/pwdSearchOkUsers")
	@ResponseBody //ajax에게 뷰가 아닌 것을 반환
	public String pwSearchOk(RegisterUsersDTO dto) {
		//이름, 연락처가 일치하는 아이디와 이메일을 구한다.
		RegisterUsersDTO resultDTO = service.usersPwdSearch(dto);
		String resultTxt = "N";
		
		if(resultDTO!=null) { //일치하는 정보가 있을 때
			//이메일 보내기
			String subject = "비밀번호 찾기 결과";
			String content = "<div style='background:yellow; border:1px solid #ddd; padding:50px; text-align:center;'>";
			content += "검색한 비밀번호는 : " + resultDTO.getUserpwd();
			content += "</div>";
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("minjee3333@naver.com"); //보내는 메일 주소
				messageHelper.setTo(resultDTO.getEmail()); //받는 메일 주소
				messageHelper.setSubject(subject); //메일 제목
				messageHelper.setText("text/html; charset=UTF-8",content); //헤더와 메일 내용
				mailSender.send(message);
				resultTxt = "Y";
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else { //일치하는 정보가 없을 때
			resultTxt = "N";
		}
		
		return resultTxt;
	}
	// 시장상인 비밀번호 찾기
	@PostMapping("/pwdSearchOkMerchant")
	@ResponseBody //ajax에게 뷰가 아닌 것을 반환
	public String pwSearchOk(RegisterMerchantDTO dto) {
		//이름, 연락처가 일치하는 아이디와 이메일을 구한다.
		RegisterMerchantDTO resultDTO = service.merchantPwdSearch(dto);
		String resultTxt = "N";
		
		if(resultDTO!=null) { //일치하는 정보가 있을 때
			//이메일 보내기
			String subject = "비밀번호 찾기 결과";
			String content = "<div style='background:yellow; border:1px solid #ddd; padding:50px; text-align:center;'>";
			content += "검색한 비밀번호는 : " + resultDTO.getM_userpwd();
			content += "</div>";
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("minjee3333@naver.com"); //보내는 메일 주소
				messageHelper.setTo(resultDTO.getEmail()); //받는 메일 주소
				messageHelper.setSubject(subject); //메일 제목
				messageHelper.setText("text/html; charset=UTF-8",content); //헤더와 메일 내용
				mailSender.send(message);
				resultTxt = "Y";
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else { //일치하는 정보가 없을 때
			resultTxt = "N";
		}
		
		return resultTxt;
	}
}
