<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
	<h1>마이페이지</h1>
	<ul>
		<li>
			<c:if test="${logType=='U'}"><a href="/home/register/pwdChkUsers">회원정보수정</a></c:if>
			<c:if test="${logType=='M'}"><a href="/home/register/pwdChkMerchant">회원정보수정</a></c:if>
		</li>
		<li><a href="">주문내역</a></li>
		<li><a href="">배송조회</a></li>
		<li>구독 상태</li>
		<li></li>
	</ul>
</main>