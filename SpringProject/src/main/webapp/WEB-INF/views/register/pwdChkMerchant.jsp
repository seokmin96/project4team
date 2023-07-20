<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main class="container mt-5">
	<h1>회원정보 수정</h1>
	<form action="/home/register/editMerchant" method="post" class="needs-validation">
		<ul class="list-unstyled">
			<li class="form-group">
				</br>
				<div class="alert alert-warning alert-dismissible fade show" role="alert">
					<strong>상인회원 </strong>비밀번호를 입력해주세요.
				</div>
				<input type="password" name="m_userpwd" id="m_userpwd" class="form-control" required/>
				</br>
				<input type="submit" value="확인" class="btn btn-warning"/>
			</li>
		</ul>
	</form>
</main>