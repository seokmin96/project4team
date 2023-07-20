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
	
	// ���� ��û �Ϸ�� ������ ����
	@PostMapping("/subscribe/detail2307/subOk")
	public ResponseEntity<String> SubscribeOk(SubscribeDTO dto, HttpServletRequest request) { 
		
		dto.setUserid((String)request.getSession().getAttribute("logId")); 
		// getAttribute�� ���� ���������� ������ ���� ��Ʈ������ �ٲٰ� dto�� userid ������ �����ϱ� ����
		
		// insert�� ������ ��ȯ�ؼ� int���̴�. �����ϸ� 1
		int result = 0; // �ʱⰪ ���� (�μ�Ʈ ���� �� �������� 0�� �����Ѵ�.)
		// ����ó���� ���� try catch ��
		try {
			result = service.SubscribeOk(dto);  // �Խñ� ��� �����ϸ� ���� 1�� �����
		} catch (Exception e) { //������ �߻��ϸ� 0�� ����
			System.out.println("���� ��û�� �����߽��ϴ�. ���� �߻� : " + e.getMessage());
		}
		
		// ResponseEntity<String>�� ù��° ��ü tag ����! 
		// ��� ����� ���� ��ũ��Ʈ�� �����ϱ� 
		String tag = "<script>";
		if(result>0) {//����, �Խ��� ������� �̵�
			tag += "location.href='/home/subscribe';";
		}else {//���� -> ���� ��û ���������� �ٽ� �̵�
			tag += "alert('���� ��û�� �����Ͽ����ϴ�.');";
			tag += "history.back();";  // ���� ȸ������ ������ ��� jsp ���� ���������! registerResult.jsp����!
		}
		tag += "</script>";
		
		
		// ResponseEntity<String>�� �ι�° ��ü headers ����! 
			
		return new ResponseEntity<String>(tag,HttpStatus.OK);
	}
}

