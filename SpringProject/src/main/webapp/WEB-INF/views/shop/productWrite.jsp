<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
h1{
	text-align:center;
}
.form-container {
	background:#FFFFD7;
 	width: 50%;
	max-width: 800px;
	margin-left: 23%;
	margin-bottom: 50px;
	padding-left:30px;
	padding-bottom:20px;
	display:flex;
	flex-direction: column;
}
.pdw li:first-child {
	padding-top:40px;
}
.pdw li {
 	display: flex;
	align-items: center;
	margin-left: 40px;
	margin-bottom: 20px;

}
/* 레이블과 입력 요소 사이 간격 조정 */
.pdw li label {
	margin-right: 10px;
	margin-top: 10px;
  
}
.pdw li input[type="text"] {
	width: 50%;
	margin-left: 10px;
	margin-top: 10px;
	height: 30px;
}

.pdw li input[type="file"] {
	margin-top: 10px;
	height: 30px;
}

.pdw li input[type="button"] {
	margin-left: 10px;
	margin-top: 10px;
		
}
.pdw li input[type="submit"] {
	margin-left: 300px;
		
}
.pdw li textarea {
  flex: 1; 
  margin-left: 10px;
  margin-right: 50px;
/*   height: 30px;  */
}
</style>
<script>
	$(function(){
		$(document).on('click','.form-container input[value=" + "]',function(){
			var tag = "<div>";
			tag += "<input type='file' name='p_img' />";
			tag += "<input type='button' value= ' + '/>";
			tag += "</div>";
			$("#imglist").append(tag);
			$(this).val(' - ');
			$(this).parent().css("background","#FFFF99");
		});
		$(document).on('click','.form-container input[value=" - "]',function(){
			$(this).parent().remove();
		});
	});
</script>
<main>
<<<<<<< HEAD
<<<<<<< HEAD

<h1>상품등록하기</h1>
<form class="form-container" method="post" action="/home/productWrite">
    <div class="pdw">
      <ul>
        <li>
          <label for="p_no">상품이름</label>
          <input type="text" name="p_no" id="p_no" value="${dto.p_no}" />
        </li>

        <li>
          <label for="m_userid">상인아이디</label>
          <input type="text" name="m_userid" id="m_userid" value="${m_userid}" />
        </li>

        <li>
          <label for="p_name">상품명</label>
          <input type="text" name="p_name" id="p_name" value="${p_name}" />
        </li>
		<li>
          <label>상품이미지</label>
        </li>
        <li>
          <!-- <li id='imglist'> -->
          	<div id='imglist'>
            	<input type="file" name="p_img" id="p_img" />
            	<input type="button" value=" + " />
          	</div>
          <!-- </li> -->
        </li>
        
        <li>
          <label for="p_price">상품가격</label>
          <input type="text" name="p_price" id="p_price" value="${p_price}" />
        </li>
        
        <li>
          <label for="p_dis">상품할인율</label>
          <select name="p_dis" id="p_dis">
            <option value="0">할인 없음</option>
            <option value="10">10% 할인</option>
            <option value="20">20% 할인</option>
            <option value="30">30% 할인</option>
          </select>
        </li>

        <li>
          <label for="p_date">상품등록날짜</label>
          <input type="date" name="p_date" id="p_date" value="${p_date}" />
        </li>

        <li>
          <label for="ma_name">시장명</label>
          <input type="text" name="ma_name" id="ma_name" value="${ma_name}" />
        </li>

        <li>
          <label for="m_name">가게명</label>
          <input type="text" name="m_name" id="m_name" value="${m_name}" />
        </li>

        <li>
          <label for="p_content">상품내용</label>
          <input type="text" name="p_content" id="p_content" value="${p_content}" />
          <li><textarea name="content" id="content"></textarea></li>
        </li>

        <li>
          <label>공개여부</label>
          <input type="radio" name="p_pub" id="public" value="공개" />
          <label for="public">공개</label>
          <input type="radio" name="p_pub" id="private" value="비공개" />
          <label for="private">비공개</label>
        </li>

<%--         <li>
          <label for="p_ddu">떨이여부</label>
          <input type="text" name="p_ddu" id="p_ddu" value="${p_ddu}" />
        </li> --%>

        <li>
          <label>떨이여부</label>
          <input type="radio" name="content" id="yes" value="떨어짐" />
          <label for="yes">O</label>
          <input type="radio" name="content" id="no" value="떨어지지않음" />
          <label for="no">X</label>
        </li>

        <li>
          <input type="submit" value="글등록" />
        </li>
      </ul>
    </div>
  </form>

</main>
<script>
/* CKEDITOR.ClassicEditor.create(document.getElementById("content"), option); */
</script>
=======
	
</main>
>>>>>>> branch 'master' of https://github.com/seokmin96/project4team.git
=======
	<h1>상인회원수정 폼</h1>
	<form action="/home/register/editOkMerchant" method="post">
		<ul>
			<li>아이디 : <input type="text" name="m_userid" id="m_userid" value="${dto.m_userid}" readonly /></li> 
			<li>비밀번호 : <input type="password" name="m_userpwd" id="m_userpwd" value="${dto.m_userpwd}" /></li>
			<li>비밀번호 확인 : <input type="password" name="userpwd2" id="userpwd2" value="${dto.m_userpwd}" /></li>
			<li>이름 : <input type="text" name="m_username" id="m_username" value="${dto.m_username}" /></li>
			<li>연락처 : <input type="text" name="tel1" id="tel1" size="4" value="${dto.tel1}" />
					- <input type="text" name="tel2" id="tel2" size="4" value="${dto.tel2}" />
					- <input type="text" name="tel3" id="tel3" size="4" value="${dto.tel3}" /></li>
			<li>이메일 : <input type="email" name="m_email" id="m_email" value="${dto.m_email}" /></li>
			<li>시장 이름 : <input type="text" name="ma_name" id="ma_name" value="${dto.ma_name}" /></li>
			<li>가게 연락처 : <input type="text" name="m_tel" id="m_tel" value="${dto.m_tel}" /></li>
			<li>가게 주소 : <input type="text" name="m_addr" id="m_addr" value="${dto.m_addr}" /></li>
			<li>사업자등록번호 : <input type="text" name="m_rnum" id="m_rnum" value="${dto.m_rnum}" /></li>
			<li><button>회원정보 수정하기</button></li>
		</ul>
	</form>
</main>
>>>>>>> parent of 91ea4f2 (# WARNING: head commit changed in the meantime)
