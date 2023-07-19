<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
	<h1>개인회원수정 폼</h1>
	<form action="/home/register/editOkUsers" method="post">
		<ul>
			<li>아이디 : <input type="text" name="userid" id="userid" value="${dto.userid}" readonly /></li> 
			<li>비밀번호 : <input type="password" name="userpwd" id="userpwd" value="${dto.userpwd}" /></li>
			<li>비밀번호 확인 : <input type="password" name="userpw2" id="userpw2" value="${dto.userpwd}" /></li>
			<li>이름 : <input type="text" name="username" id="username" value="${dto.username}" /></li>
			<li>연락처 : <input type="text" name="tel1" id="tel1" size="4" value="${dto.tel1}" />
					- <input type="text" name="tel2" id="tel2" size="4" value="${dto.tel2}" />
					- <input type="text" name="tel3" id="tel3" size="4" value="${dto.tel3}" /></li>
			<li>이메일 : <input type="email" name="email" id="email" value="${dto.email}" /></li>
			<li>주소 : <input type="text" name="addr" id="addr" value="${dto.addr}" /></li>
			<li><button>회원정보 수정하기</button></li>
		</ul>
	</form>
</main>