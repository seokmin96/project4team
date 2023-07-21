<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	function pwChk(){ //비밀번호 일치 여부
		if($("#users").is(":checked")){
			if(document.getElementById("userpwd").value != document.getElementById("userpwd2").value){
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
		}
		if($("#merchant").is(":checked")){
			if(document.getElementById("m_userpwd").value != document.getElementById("m_userpwd2").value){
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
		}
		return true;
	}

	$(function(){
		$("#users").click(function(){
			$(".usersRegFrm").css("display","block");
			$(".merchantRegFrm").css("display","none");
		});
		$("#merchant").click(function(){
			$(".usersRegFrm").css("display","none");
			$(".merchantRegFrm").css("display","block");
		});
	});
	
	$(document).ready(function() {
        // 개인회원 라디오 버튼 클릭 시
        $('#users').click(function() {
            $('.btn-group .btn').removeClass('active'); // 다른 버튼들의 active 클래스 제거
            $(this).parent().addClass('active'); // 클릭한 버튼에 active 클래스 추가
        });

        // 상인 라디오 버튼 클릭 시
        $('#merchant').click(function() {
            $('.btn-group .btn').removeClass('active'); // 다른 버튼들의 active 클래스 제거
            $(this).parent().addClass('active'); // 클릭한 버튼에 active 클래스 추가
        });
    });
</script>


<main class="container mt-5">
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
		<strong>Check </strong> 해당하는 곳을 선택해주세요
	</div>
	 
	<div class="btn-group btn-group-toggle mb-4" data-toggle="buttons">
		<label class="btn btn-outline-warning active">
			<input type="radio" name="userType" id="users" checked>개인회원
		</label>
		<label class="btn btn-outline-warning">
			<input type="radio" name="userType" id="merchant">상인
		</label>
	</div>
	
	<div class="usersRegFrm">
		<h1>개인회원 회원가입</h1>
		<form action="/home/register/registerOkUsers" method="post" onsubmit="return pwChk()" class="needs-validation">
			<ul class="list-unstyled">
				<li class="form-group">아이디  <input type="text" name="userid" id="userid" class="form-control" required/></li> 
				<li class="form-group">비밀번호  <input type="password" name="userpwd" id="userpwd" class="form-control" required/></li>
				<li class="form-group">비밀번호 확인  <input type="password" name="userpwd2" id="userpwd2" class="form-control" required/></li>
				<li class="form-group">이름  <input type="text" name="username" id="username" class="form-control" required/></li>
				<li class="form-group">연락처  <input type="text" name="tel1" placeholder="3자리 입력" id="tel1" size="4" class="form-control" required/>
						- <input type="text" name="tel2" placeholder="4자리 입력" id="tel2" size="4" class="form-control" required/>
						- <input type="text" name="tel3" placeholder="4자리 입력" id="tel3" size="4" class="form-control" required/></li>
				<li class="form-group">이메일  <input type="email" name="email" id="email" class="form-control" required/></li>
				<li class="form-group">주소  <input type="text" name="addr" id="addr" class="form-control" required/></li>
				<li class="form-group"><button class="btn btn-warning">회원가입하기</button></li>
			</ul>
		</form>
	</div>
	
	<div class="merchantRegFrm" style="display:none;">
		<h1>시장상인 회원가입</h1>
		<form action="/home/register/registerOkMerchant" method="post" onsubmit="return pwChk()">
			<ul class="list-unstyled">
				<li class="form-group">아이디 <input type="text" name="m_userid" id="m_userid" class="form-control" required/></li> 
				<li class="form-group">비밀번호 <input type="password" name="m_userpwd" id="m_userpwd" class="form-control" required/></li>
				<li class="form-group">비밀번호 확인 <input type="password" name="m_userpwd2" id="m_userpwd2" class="form-control" required/></li>
				<li class="form-group">이름 <input type="text" name="m_username" id="m_username" class="form-control" required/></li>
				<li class="form-group">연락처 <input type="text" name="tel1" placeholder="3자리 입력" id="tel1" size="4" class="form-control" required/>
						- <input type="text" name="tel2" placeholder="4자리 입력" id="tel2" size="4" class="form-control" required/>
						- <input type="text" name="tel3" placeholder="4자리 입력" id="tel3" size="4" class="form-control" required/></li>
				<li class="form-group">이메일 <input type="email" name="m_email" id="m_email" class="form-control" required/></li>
				<li class="form-group">시장 이름 <input type="text" name="ma_name" id="ma_name" class="form-control" required/></li>
				<li class="form-group">가게 연락처 <input type="text" name="m_tel" id="m_tel" class="form-control" required/></li>
				<li class="form-group">가게 주소 <input type="text" name="m_addr" id="m_addr" class="form-control" required/></li>
				<li class="form-group">사업자등록번호 <input type="text" name="m_rnum" id="m_rnum" class="form-control" required/></li>
				<li class="form-group"><button class="btn btn-warning">회원가입하기</button></li>
			</ul>
		</form>
	</div>

</main>