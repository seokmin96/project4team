<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script>
	$(function(){
		$("#users").click(function(){
			$(".usersIdFrm").css("display","block");
			$(".merchantIdFrm").css("display","none");
		});
		$("#merchant").click(function(){
			$(".usersIdFrm").css("display","none");
			$(".merchantIdFrm").css("display","block");
		});
	});

	
	$(function(){
		$("input[value=아이디찾기]").click(function(){
			var url = null;
			var username = null;
			if($("#users").is(":checked")){
				url = '/home/register/idSearchOkUsers';
				username =  $("#username").val();
			}
			if($("#merchant").is(":checked")){
				url = '/home/register/idSearchOkMerchant';
				username =  $("#m_username").val();
			}
			
			$.ajax({
				url : url,
				data : {
					username : username,
					email : $("#email").val()
				},
				type : "post",
				success : function(result){
					console.log(result);
					if(result=='Y'){
						alert("아이디를 이메일로 전송하였습니다.");
						location.href = "/home/register/login";
					}else{
						alert("일치하는 정보가 존재하지 않습니다.");
					}
				},
				error : function(){
					console.log("아이디 찾기 에러 발생...")
				}
			});	
		});	
	});
	
	
	
	
	

</script>

<main>
	<h1>아이디 찾기</h1>
	<input type="radio" name="userType" id="users" checked>개인회원
	<input type="radio" name="userType" id="merchant">상인
	
	<div class="usersIdFrm">
		<form id="idSearchFrm">
			<ul>
				<li>이름 : <input type="text" name="username" id="username" /></li>
				<li>이메일 : <input type="text" name="email" id="email" placeholder="예)abc@naver.com" /></li>
				<li><input type="button" value="아이디찾기" /></li>
			</ul>
		</form>
	</div>
	
	<div class="merchantIdFrm" style="display:none;">
		<form id="idSearchFrm">
			<ul>
				<li>이름 : <input type="text" name="m_username" id="m_username" /></li>
				<li>이메일 : <input type="text" name="email" id="email" placeholder="예)abc@naver.com" /></li>
				<li><input type="button" value="아이디찾기" /></li>
			</ul>
		</form>
	</div>

</main>