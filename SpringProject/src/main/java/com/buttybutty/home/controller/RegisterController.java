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
	
	
	//ȸ������ ��
	@GetMapping("/reg")
	public String reg() {
		return "register/regForm";
	}
	//����ȸ�� ȸ������ Ȯ��
	@PostMapping("/registerOkUsers")
	public ModelAndView registerOkUsers(RegisterUsersDTO dto) {
		int result = 0;
		try {
				result = service.usersInsert(dto);
		} catch (Exception e) {
				System.out.println("ȸ������ ����....." + e.getMessage());
		}
		ModelAndView mav = new ModelAndView();
		if(result>0){ //���� - Ȩ���� �̵�
				mav.setViewName("redirect:/");
		}
		else{ //���� - ȸ���������� �̵�
				mav.setViewName("register/registerResult");
		}
		return mav;
	}
	//���� ȸ������ Ȯ��
	@PostMapping("/registerOkMerchant")
	public ModelAndView registerOkMerchant(RegisterMerchantDTO dto) {
		int result = 0;
		try {
			result = service.merchantInsert(dto);
		} catch (Exception e) {
			System.out.println("ȸ������ ����....." + e.getMessage());
		}
		ModelAndView mav = new ModelAndView();
		if(result>0){ //���� - Ȩ���� �̵�
			mav.setViewName("redirect:/");
		}
		else{ //���� - ȸ���������� �̵�
			mav.setViewName("register/registerResult");
		}
		return mav;
	}
	
	
	//�α��� ��
	@GetMapping("/login")
	public String login() {
		return "register/login";
	}
	//����ȸ�� �α��� Ȯ��
	@PostMapping("/loginOkUsers")
	public ModelAndView loginOkUsers(String userid, String userpwd, HttpSession session) {
			RegisterUsersDTO dto = service.usersSelect(userid, userpwd);
			ModelAndView mav = new ModelAndView();
			if(dto!= null) {//���� -> Ȩ���� �̵�
					//���ǿ� ���̵�,�̸�,�α��λ��� ���
					session.setAttribute("logId", dto.getUserid());
					session.setAttribute("logName", dto.getUsername());
					session.setAttribute("logStatus", "Y");
					session.setAttribute("logType", "U");
					mav.setViewName("redirect:/");
			}else {//���� -> �α��� ������ �ٽ� �̵�
					mav.setViewName("redirect:login");
			}
			return mav;
	}
	//���� �α��� Ȯ��
	@PostMapping("/loginOkMerchant")
	public ModelAndView loginOkMerchant(String userid, String userpwd, HttpSession session) {
			RegisterMerchantDTO dto = service.merchantSelect(userid, userpwd);
			ModelAndView mav = new ModelAndView();
			if(dto!= null) {//���� -> Ȩ���� �̵�
					//���ǿ� ���̵�,�̸�,�α��λ��� ���
					session.setAttribute("logId", dto.getM_userid());
					session.setAttribute("logName", dto.getM_username());
					session.setAttribute("logStatus", "Y");
					session.setAttribute("logType", "M");
					mav.setViewName("redirect:/");
			}else {//���� -> �α��� ������ �ٽ� �̵�
					mav.setViewName("redirect:login");
			}
			return mav;
	}
	//�α׾ƿ�
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate(); //session ��ü ���� -> ���ο� session��ü �Ҵ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	//����������
	@GetMapping("/mypage")
	public String mypage() {
		return "register/mypage";
	}
	//����ȸ�� ȸ������������ ���� ��й�ȣ Ȯ��
	@GetMapping("/pwdChkUsers")
	public String pwdChkUsers() {
		return "register/pwdChkUsers";
	}
	//����ȸ�� ȸ���������� ��
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
	//���� ȸ���������� Ȯ��
	@PostMapping("/editOkUsers")
	public String editOkUsers(RegisterUsersDTO dto) {
		int result = service.usersUpdate(dto);
		if(result>0) {
			return "/register/mypage";
		}else {
			return "/register/editUsers";
		}
	}
	//���� ȸ������������ ���� ��й�ȣ Ȯ��
	@GetMapping("/pwdChkMerchant")
	public String pwdChkMerchant() {
		return "register/pwdChkMerchant";
	}
	//���� ȸ���������� ��
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
	//���� ȸ���������� Ȯ��
	@PostMapping("/editOkMerchant")
	public String editOkMerchant(RegisterMerchantDTO dto) {
		int result = service.merchantUpdate(dto);
		if(result>0) {
			return "/register/mypage";
		}else {
			return "/register/editMerchant";
		}
	}
	

	//���̵� ã�� ��
	@GetMapping("/idSearch")
	public String idSearchForm() {
		return "register/idSearch";
	}
	//����ȸ�� ���̵� ã��
	@PostMapping("/idSearchOkUsers")
	@ResponseBody //ajax���� �䰡 �ƴ� ���� ��ȯ
	public String idSearchOkUsers(RegisterUsersDTO dto) {
		//�̸�, ����ó�� ��ġ�ϴ� ���̵�� �̸����� ���Ѵ�.
		RegisterUsersDTO resultDTO = service.usersIdSearch(dto);
		String resultTxt = "N";
		
		if(resultDTO!=null) { //��ġ�ϴ� ������ ���� ��
			//�̸��� ������
			String subject = "���̵� ã�� ���";
			String content = "<div style='background:pink; border:1px solid #ddd; padding:50px; text-align:center;'>";
			content += "�˻��� ���̵�� : " + resultDTO.getUserid();
			content += "</div>";
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("minjee3333@naver.com"); //������ ���� �ּ�
				messageHelper.setTo(resultDTO.getEmail()); //�޴� ���� �ּ�
				messageHelper.setSubject(subject); //���� ����
				messageHelper.setText("text/html; charset=UTF-8",content); //����� ���� ����
				mailSender.send(message);
				resultTxt = "Y";
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else { //��ġ�ϴ� ������ ���� ��
			resultTxt = "N";
		}
		
		return resultTxt;
	}
	//������� ���̵� ã��
	@PostMapping("/idSearchOkMerchant")
	@ResponseBody //ajax���� �䰡 �ƴ� ���� ��ȯ
	public String idSearchOkMerchant(RegisterMerchantDTO dto) {
		//�̸�, ����ó�� ��ġ�ϴ� ���̵�� �̸����� ���Ѵ�.
		RegisterMerchantDTO resultDTO = service.merchantIdSearch(dto);
		String resultTxt = "N";
		
		if(resultDTO!=null) { //��ġ�ϴ� ������ ���� ��
			//�̸��� ������
			String subject = "���̵� ã�� ���";
			String content = "<div style='background:pink; border:1px solid #ddd; padding:50px; text-align:center;'>";
			content += "�˻��� ���̵�� : " + resultDTO.getM_userid();
			content += "</div>";
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("minjee3333@naver.com"); //������ ���� �ּ�
				messageHelper.setTo(resultDTO.getEmail()); //�޴� ���� �ּ�
				messageHelper.setSubject(subject); //���� ����
				messageHelper.setText("text/html; charset=UTF-8",content); //����� ���� ����
				mailSender.send(message);
				resultTxt = "Y";
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else { //��ġ�ϴ� ������ ���� ��
			resultTxt = "N";
		}
		
		return resultTxt;
	}

	//��й�ȣ ã�� ��
	@GetMapping("/pwdSearch")
	public String pwSearchForm() {
		return "register/pwdSearch";
	}
	// ����ȸ�� ��й�ȣ ã��
	@PostMapping("/pwdSearchOkUsers")
	@ResponseBody //ajax���� �䰡 �ƴ� ���� ��ȯ
	public String pwSearchOk(RegisterUsersDTO dto) {
		//�̸�, ����ó�� ��ġ�ϴ� ���̵�� �̸����� ���Ѵ�.
		RegisterUsersDTO resultDTO = service.usersPwdSearch(dto);
		String resultTxt = "N";
		
		if(resultDTO!=null) { //��ġ�ϴ� ������ ���� ��
			//�̸��� ������
			String subject = "��й�ȣ ã�� ���";
			String content = "<div style='background:yellow; border:1px solid #ddd; padding:50px; text-align:center;'>";
			content += "�˻��� ��й�ȣ�� : " + resultDTO.getUserpwd();
			content += "</div>";
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("minjee3333@naver.com"); //������ ���� �ּ�
				messageHelper.setTo(resultDTO.getEmail()); //�޴� ���� �ּ�
				messageHelper.setSubject(subject); //���� ����
				messageHelper.setText("text/html; charset=UTF-8",content); //����� ���� ����
				mailSender.send(message);
				resultTxt = "Y";
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else { //��ġ�ϴ� ������ ���� ��
			resultTxt = "N";
		}
		
		return resultTxt;
	}
	// ������� ��й�ȣ ã��
	@PostMapping("/pwdSearchOkMerchant")
	@ResponseBody //ajax���� �䰡 �ƴ� ���� ��ȯ
	public String pwSearchOk(RegisterMerchantDTO dto) {
		//�̸�, ����ó�� ��ġ�ϴ� ���̵�� �̸����� ���Ѵ�.
		RegisterMerchantDTO resultDTO = service.merchantPwdSearch(dto);
		String resultTxt = "N";
		
		if(resultDTO!=null) { //��ġ�ϴ� ������ ���� ��
			//�̸��� ������
			String subject = "��й�ȣ ã�� ���";
			String content = "<div style='background:yellow; border:1px solid #ddd; padding:50px; text-align:center;'>";
			content += "�˻��� ��й�ȣ�� : " + resultDTO.getM_userpwd();
			content += "</div>";
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("minjee3333@naver.com"); //������ ���� �ּ�
				messageHelper.setTo(resultDTO.getEmail()); //�޴� ���� �ּ�
				messageHelper.setSubject(subject); //���� ����
				messageHelper.setText("text/html; charset=UTF-8",content); //����� ���� ����
				mailSender.send(message);
				resultTxt = "Y";
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else { //��ġ�ϴ� ������ ���� ��
			resultTxt = "N";
		}
		
		return resultTxt;
	}
}
