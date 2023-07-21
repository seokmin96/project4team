<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<main class="container mt-5">
    <h1>제철 먹거리 꾸러미 구독</h1>
    </br>
    <h2>송정매일시장 상인회 X 가치가장</h2>
 
	<!-- 배너 스타일 -->
	  <style>	
		.carousel-item img {
		  object-fit: cover;
		  width: 800px;
		  height: 500px;
		}
	  </style>	
	<!-- 배너 -->
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	   	<ol class="carousel-indicators">
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img class="d-block w-100" src="/home/img/cat1.jpg" alt="배너 1">
      </div>
      <div class="carousel-item">
        <img class="d-block w-100" src="/home/img/cat2.jpg" alt="배너 2">
      </div>
      <div class="carousel-item">
        <img class="d-block w-100" src="/home/img/cat3.jpg" alt="배너 3">
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  </br> 
  
   
  
	<!-- 부트스트랩 및 jQuery 스크립트 링크 추가 -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <div class="usersLoginFrm">
        <!-- 개인 회원 -->
        <li>
			<c:if test="${logType=='U'}">
		 		<form action="/home/subscribe/detail2307/subOk" method="post" onsubmit="return subChk()" class="needs-validation">
		            <ul class="list-unstyled">
		                </br>
		                
		                <h3>7월 제철 먹거리 꾸러미 신청 폼</h3>
		                </br> 
		                <!-- 확인창  -->
						<div class="alert alert-warning alert-dismissible fade show" role="alert">
						  <strong>배송 안내   </strong>입금이 확인되면 매월 25일 일괄 발송 됩니다. 
						</div>
						</br>
						
		                <li class="form-group">
		                    <input type="text" name="sub_name" id="sub_name" placeholder="수령인" class="form-control" required />
		                </li>
		                <li class="form-group">
		                    <input type="text" name="sub_tel" id="sub_tel" placeholder="연락처" class="form-control" required />
		                </li>
		                <li class="form-group">
		                    <input type="text" name="sub_addr" id="sub_addr" placeholder="배송지 주소" class="form-control" required />
		                </li>
		                <li class="form-group">
		                    <input type="text" name="sub_cash_name" id="sub_cash_name" placeholder="입금자명 뒤에 연락처 뒷 4자리를 함께 적어주세요. (홍길동1234)" class="form-control" required />
		                </li>
		             
		                <!-- 구독버튼 -->
		                </br>
		                <li class="form-group">
                    		<input type="submit" value="구독 신청" class="btn btn-warning" />
               			</li>
		                    
		            </ul>
		        </form>
			</c:if>
		</li>
    </div>
</main>
