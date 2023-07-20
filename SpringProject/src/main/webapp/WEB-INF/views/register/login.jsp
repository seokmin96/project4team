<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<style>
	a:link, a:visited, a:hover{
		text-decoration:none;
	}
	a, a:active {
	    text-decoration: none;
	}
</style>

<script>

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
<main class="container mt-5">
    <h1>로그인 폼</h1>
    <div class="btn-group btn-group-toggle mb-4" data-toggle="buttons">
        <label class="btn btn-outline-warning active">
            <input type="radio" name="userType" id="users" checked> 개인회원
        </label>
        <label class="btn btn-outline-warning">
            <input type="radio" name="userType" id="merchant"> 상인
        </label>
    </div>

    <div class="usersLoginFrm">
        <h3>개인 회원</h3>
        <form action="/home/register/loginOkUsers" method="post" class="needs-validation">
            <ul class="list-unstyled">
                <li class="form-group">
                    <input type="text" name="userid" id="userid" placeholder="아이디 입력" class="form-control" required />
                </li>
                <li class="form-group">
                    <input type="password" name="userpwd" id="userpwd" placeholder="비밀번호 입력" class="form-control" required />
                </li>
                <li>
                    <input type="submit" value="로그인" class="btn btn-warning"/>
                </li>
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
        <form action="/home/register/loginOkMerchant" method="post" class="needs-validation">
            <ul class="list-unstyled">
                <li class="form-group">
                    <input type="text" name="m_userid" id="m_userid" placeholder="아이디 입력" class="form-control" required />
                </li>
                <li class="form-group">
                    <input type="password" name="m_userpwd" id="m_userpwd" placeholder="비밀번호 입력" class="form-control" required />
                </li>
                <li>
                    <input type="submit" value="로그인" class="btn btn-warning" />
                </li>
                <li>
                    <div><a href="/home/register/idSearch">아이디 찾기 > </a></div>
                    <div><a href="/home/register/pwdSearch">비밀번호 찾기 > </a></div>
                    <div><a href="/home/register/reg">회원가입 > </a></div>
                </li>
            </ul>
        </form>
    </div>
</main>

