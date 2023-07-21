<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main class="container mt-5">
	<h1>개인회원수정 폼</h1>
	</br>
	<form action="/home/register/editOkUsers" method="post" class="needs-validation">
		</br>
		<ul class="list-unstyled">
			<li class="form-group">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Id </strong>
			</div> 
			<input type="text" name="userid" id="userid" value="${dto.userid}" readonly class="form-control" required/></li> 
			
			<li class="form-group"> 
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Password </strong>비밀번호 수정
			</div> 
			<input type="password" name="userpwd" id="userpwd" value="${dto.userpwd}" class="form-control" required/></li>
			
			<li class="form-group"> 
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Password check </strong>비밀번호 확인
			</div> 
			<input type="password" name="userpw2" id="userpw2" value="${dto.userpwd}" class="form-control" required/></li>
			
			<li class="form-group">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Name </strong>이름 수정
			</div> 
			<input type="text" name="username" id="username" value="${dto.username}" class="form-control" required/></li>
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Tel </strong> 연락처 수정
			</div> 
			<li class="form-group">
			
			<input type="text" name="tel1" id="tel1" size="4" value="${dto.tel1}" class="form-control" required/>
					- <input type="text" name="tel2" id="tel2" size="4" value="${dto.tel2}" class="form-control" required/>
					- <input type="text" name="tel3" id="tel3" size="4" value="${dto.tel3}" class="form-control" required/></li>
			
			<li class="form-group">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Email </strong>이메일 수정
			</div>
			<input type="email" name="email" id="email" value="${dto.email}" class="form-control" required/></li>
			
			<li class="form-group"> 
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Address </strong>주소 수정
			</div> 
			<input type="text" name="addr" id="addr" value="${dto.addr}" class="form-control" required/></li>
			
			<li class="form-group"><button class="btn btn-warning">회원정보 수정하기</button></li>
		</ul>
	</form>
</main>