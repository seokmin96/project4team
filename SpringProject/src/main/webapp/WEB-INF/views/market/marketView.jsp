<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
	<h1>글내용 보기</h1>
	<div><a href='/home/market/marketBoard?nowPage=${pDTO.nowPage}<c:if test="${pDTO.searchWord!=null}">&searchKey=${pDTO.searchKey}&searchWord=${pDTO.searchWord}</c:if>'>목록</a><hr /></div>
	<ul>
		<li>글번호 : ${dto.mab_no}</li>
		<li>글쓴이 : ${dto.m_userid}</li>
		<li>조회수 : ${dto.mb_hit}</li>
		<li>등록일 : ${dto.mb_date}</li>
		<li>제목 : ${dto.mb_title}</li>
		<li>내용<br/> ${dto.mb_content}</li>
	</ul>
	<div>
		<!-- session의 로그인아이디(logId)와 현재글의 글쓴이(useid)가 같으면 수정,삭제 표시 -->
		<c:if test="${logId == dto.userid}">
			<a href="/home/market/marketEdit?no=${dto.mab_no}">수정</a>
			<a href="javascript:delChk()">삭제</a>
		</c:if>
	</div>
	
	<!-- 댓글 달기 -->
	<style>
		#coment{width:500px; height:80px;}
		#replyList>li{border-bottom:1px solid #ddd; padding: 5px 0px;}
	</style>
	<div id="reply">
		<!-- 로그인 시 댓글 폼 보이게 하기 -->
		<c:if test="${logStatus == 'Y'}">
			<form action="" method="post" id="replyFrm">
				<input type="hidden" name="no" value="${dto.no}" /> <!-- 원글번호 -->
				<textarea name="coment" id="coment" cols="30" rows="10"></textarea>
				<input type="submit" value="댓글등록하기" />
			</form>
		</c:if>
		<hr />
		<ul id="replyList">
			
		</ul>
	</div>
</main>