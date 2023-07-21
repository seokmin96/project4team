<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
	<h1>상인회원수정 폼</h1>
	<form action="/home/register/editOkMerchant" method="post">
		<ul>
			<li>아이디 : <input type="text" name="m_userid" id="m_userid" value="${dto.m_userid}" readonly /></li> 
			<li>비밀번호 : <input type="password" name="m_userpwd" id="m_userpwd" value="${dto.m_userpwd}" /></li>
			<li>비밀번호 확인 : <input type="password" name="userpwd2" id="userpwd2" value="${dto.m_userpwd}" /></li>
			<li>이름 : <input type="text" name="m_username" id="m_username" value="${dto.m_username}" /></li>
			<li>연락처 : <input type="text" name="tel1" id="tel1" size="4" value="${dto.tel1}" />
					- <input type="text" name="tel2" id="tel2" size="4" value="${dto.tel2}" />
					- <input type="text" name="tel3" id="tel3" size="4" value="${dto.tel3}" /></li>
			<li>이메일 : <input type="email" name="m_email" id="m_email" value="${dto.m_email}" /></li>
			<li>시장 이름 : <input type="text" name="ma_name" id="ma_name" value="${dto.ma_name}" /></li>
			<li>가게 연락처 : <input type="text" name="m_tel" id="m_tel" value="${dto.m_tel}" /></li>
			<li>가게 주소 : <input type="text" name="m_addr" id="m_addr" value="${dto.m_addr}" /></li>
			<li>사업자등록번호 : <input type="text" name="m_rnum" id="m_rnum" value="${dto.m_rnum}" /></li>
			<li><button>회원정보 수정하기</button></li>
		</ul>
	</form>
</main>