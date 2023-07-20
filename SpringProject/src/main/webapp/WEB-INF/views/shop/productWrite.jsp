<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main>

		<h1>상품등록하기</h1>
		<form method="post" action="/home/productWrite">
		<ul>
			<li>상품이름</li>
			<li><input type="text" name="p_no" id="p_no" value="${dto.p_no}" /></li>
			<li>상인아이디</li>
			<li><input type="text" name="m_userid" id="m_userid" value="${m_userid}" /></li>
			<li>상품명</li>
			<li><input type="text" name="p_name" id="p_name" value="${p_name}" /></li>
			<li>상품이미지</li>
			<li><input type="text" name="p_img" id="p_img" value="${p_img}" /></li>
			<li>상품가격</li>
			<li><input type="text" name="p_price" id="p_price" value="${p_price}" /></li>
			<li>상품할인율</li>
			<li><input type="text" name="p_dis" id="p_dis" value="${p_dis}" /></li>
			<li>상품등록날짜</li>
			<li><input type="text" name="p_date" id="p_date" value="${p_date}" /></li>
			<li>시장명</li>
			<li><input type="text" name="ma_name" id="ma_name" value="${ma_name}" /></li>
			<li>가게명</li>
			<li><input type="text" name="m_name" id="m_name" value="${m_name}" /></li>
			<li>상품내용</li>
			<li><input type="text" name="p_content" id="p_content" value="${p_content}" /></li>
			<li>공개여부</li>
			<li><input type="text" name="p_pub" id="p_pub" value="${p_pub}" /></li>
			<li>상품이름</li>
			<li><input type="text" name="p_ddu" id="p_ddu" value="${p_ddu}" /></li>
			<li>떨이여부</li>
			<li><textarea name="content" id="content"></textarea></li>
			<li><input type="submit" value="글등록"/></li>
		</ul>
		</form>	
</main>