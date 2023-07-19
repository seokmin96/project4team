<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	a:link, a:visited, a:hover{
		text-decoration:none;
	}
</style>

<script>
	function logChk(){ //아이디,비밀번호 작성 여부 확인
		if($("#users").is(":checked")){
			if(document.getElementById("userid").value == ""){
				alert("아이디를 입력하세요");
				return false;
			}
			if(document.getElementById("userpwd").value == ""){
				alert("비밀번호를 입력하세요.");
				return false;
			}
		}
		if($("#merchant").is(":checked")){
			if(document.getElementById("m_userid").value == ""){
				alert("아이디를 입력하세요");
				return false;
			}
			if(document.getElementById("m_userpwd").value == ""){
				alert("비밀번호를 입력하세요.");
				return false;
			}
		}
		return true;
	}

	$(function(){
		$("#users").click(function(){
			$(".usersLoginFrm").css("display","block");
			$(".merchantLoginFrm").css("display","none");
		});
		$("#merchant").click(function(){
			$(".usersLoginFrm").css("display","none");
			$(".merchantLoginFrm").css("display","block");
		});
	});
</script>

<main>
	<h1>로그인 폼</h1>
	<input type="radio" name="userType" id="users" checked>개인회원
	<input type="radio" name="userType" id="merchant">상인
	
	<div class="usersLoginFrm">
		<h3>개인 회원</h3>
		<form action="/home/register/loginOkUsers" method="post" onsubmit="return logChk()">
			<ul>
				<li><input type="text" name="userid" id="userid" placeholder="아이디 입력" /></li>
				<li><input type="password" name="userpwd" id="userpwd" placeholder="비밀번호 입력" /></li>
				<li><input type="submit" value="로그인" /></li>
				<li>
					<div><a href="/home/register/idSearch">아이디 찾기</a></div>
					<div><a href="/home/register/pwdSearch">비밀번호 찾기</a></div>
					<div><a href="/home/register/reg">회원가입</a></div>
				</li>
			</ul>
		</form>
	</div>
	
	<div class="merchantLoginFrm" style="display:none;">
		<h3>상인</h3>
		<form action="/home/register/loginOkMerchant" method="post" onsubmit="return logChk()">
			<ul>
				<li><input type="text" name="m_userid" id="m_userid" placeholder="아이디 입력" /></li>
				<li><input type="password" name="m_userpwd" id="m_userpwd" placeholder="비밀번호 입력" /></li>
				<li><input type="submit" value="로그인" /></li>
				<li>
					<div><a href="/home/register/idSearch">아이디 찾기</a></div>
					<div><a href="/home/register/pwdSearch">비밀번호 찾기</a></div>
					<div><a href="/home/register/reg">회원가입</a></div>
				</li>
			</ul>
		</form>
	</div>
</main>