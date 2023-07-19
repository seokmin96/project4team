<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	$(function(){
		$("#users").click(function(){
			$(".usersPwdFrm").css("display","block");
			$(".merchantPwdFrm").css("display","none");
		});
		$("#merchant").click(function(){
			$(".usersPwdFrm").css("display","none");
			$(".merchantPwdFrm").css("display","block");
		});
	});

	
	$(function(){
		$("input[value=비밀번호찾기]").click(function(){
			var url = null;
			var username = null;
			var email = null;
			if($("#users").is(":checked")){
				url = '/home/register/pwdSearchOkUsers';
				userid =  $("#userid").val();
				email = $("#email").val();
			}
			if($("#merchant").is(":checked")){
				url = '/home/register/pwdSearchOkMerchant';
				userid =  $("#m_userid").val();
				email = $("#m_email").val();
			}
			
			$.ajax({
				url : url,
				data : {
					userid : userid,
					email : email
				},
				type : "post",
				success : function(result){
					console.log(result);
					if(result=='Y'){
						alert("비밀번호를 이메일로 전송하였습니다.");
						location.href = "/home/register/login";
					}else{
						alert("일치하는 정보가 존재하지 않습니다.");
					}
				},
				error : function(){
					console.log("비밀번호 찾기 에러 발생...")
				}
			});	
		});	
	});
	
	
	
	
	

</script>

<main>
	<h1>비밀번호 찾기</h1>
	<input type="radio" name="userType" id="users" checked>개인회원
	<input type="radio" name="userType" id="merchant">상인
	
	<div class="usersPwdFrm">
		<form id="PwdSearchFrm">
			<ul>
				<li>아이디 : <input type="text" name="userid" id="userid" /></li>
				<li>이메일 : <input type="text" name="email" id="email" placeholder="예)abc@naver.com" /></li>
				<li><input type="button" value="비밀번호찾기" /></li>
			</ul>
		</form>
	</div>
	
	<div class="merchantPwdFrm" style="display:none;">
		<form id="PwdSearchFrm">
			<ul>
				<li>아이디 : <input type="text" name="m_userid" id="m_userid" /></li>
				<li>이메일 : <input type="text" name="m_email" id="m_email" placeholder="예)abc@naver.com" /></li>
				<li><input type="button" value="비밀번호찾기" /></li>
			</ul>
		</form>
	</div>

</main>