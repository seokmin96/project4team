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
    <div class="alert alert-warning alert-dismissible fade show" role="alert">
		<strong>Check </strong> 해당하는 곳을 선택해주세요
	</div>
    <div class="btn-group btn-group-toggle mb-4" data-toggle="buttons">
        <label class="btn btn-outline-warning active">
            <input type="radio" name="userType" id="users" checked> 개인회원
        </label>
        <label class="btn btn-outline-warning">
            <input type="radio" name="userType" id="merchant"> 상인
        </label>
    </div>

    <div class="usersLoginFrm">
        <h1>개인 회원 로그인</h1>
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
                <script>
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
                <li>
                    <div><a href="/home/register/idSearch">아이디 찾기 > </a></div>
                    <div><a href="/home/register/pwdSearch">비밀번호 찾기 > </a></div>
                    <div><a href="/home/register/reg">회원가입 > </a></div>
                </li>
            </ul>
        </form>
    </div>

    <div class="merchantLoginFrm" style="display:none;">
        <h1>상인 회원 로그인</h1>
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
