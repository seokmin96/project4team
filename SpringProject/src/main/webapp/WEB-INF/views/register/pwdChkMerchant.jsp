<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
	<h1>회원정보 수정</h1>
	<form action="/home/register/editMerchant" method="post">
		<ul>
			<li>
				상인회원 로그인 비밀번호 : <input type="password" name="m_userpwd" id="m_userpwd" />
				<input type="submit" value="확인" />
			</li>
		</ul>
	</form>
</main>