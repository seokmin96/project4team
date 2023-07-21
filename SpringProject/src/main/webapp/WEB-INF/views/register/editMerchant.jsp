<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main class="container mt-5">
	<h1>상인회원수정 폼</h1>
	</br>
	<form action="/home/register/editOkMerchant" method="post" class="needs-validation">
		</br>
		<ul class="list-unstyled">
			<li class="form-group">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Id </strong>
			</div> 
			<input type="text" name="m_userid" id="m_userid" value="${dto.m_userid}" readonly class="form-control" required /></li> 
			
			<li class="form-group">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Password </strong>비밀번호 수정
			</div> 
			<input type="password" name="m_userpwd" id="m_userpwd" value="${dto.m_userpwd}" class="form-control" required /></li>
			
			<li class="form-group">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Password check </strong>비밀번호 확인
			</div> 
			<input type="password" name="userpwd2" id="userpwd2" value="${dto.m_userpwd}" class="form-control" required /></li>
			
			<li class="form-group">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Name </strong>이름 수정
			</div> 
			<input type="text" name="m_username" id="m_username" value="${dto.m_username}" class="form-control" required /></li>
			
			<li class="form-group">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Tel </strong>개인 연락처 수정
			</div> 
			<input type="text" name="tel1" id="tel1" size="4" value="${dto.tel1}" class="form-control" required />
					- <input type="text" name="tel2" id="tel2" size="4" value="${dto.tel2}" class="form-control" required />
					- <input type="text" name="tel3" id="tel3" size="4" value="${dto.tel3}" class="form-control" required/></li>
			
			<li class="form-group"> 
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Name </strong>업체 연락처 수정
			</div> 
			<input type="text" name="m_tel" id="m_tel" value="${dto.m_tel}" class="form-control" required /></li>
			
			<li class="form-group">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Email </strong>이메일 수정
			</div>  
			<input type="email" name="m_email" id="m_email" value="${dto.m_email}" class="form-control" required/></li>
			
			<li class="form-group">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Market Name </strong>시장명 수정
			</div>  
			<input type="text" name="ma_name" id="ma_name" value="${dto.ma_name}" class="form-control" required/></li>
			
			<li class="form-group"> 
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Market Address </strong>가게 주소 수정
			</div>  
			<input type="text" name="m_addr" id="m_addr" value="${dto.m_addr}" class="form-control" required/></li>
			
			<li class="form-group">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
				<strong>Business Number </strong>사업자번호 수정
			</div>  
			<input type="text" name="m_rnum" id="m_rnum" value="${dto.m_rnum}" class="form-control" required /></li>
			
			<li class="form-group"><button class="btn btn-warning">회원정보 수정하기</button></li>
		</ul>
	</form>
</main>