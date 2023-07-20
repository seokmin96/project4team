<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
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
  
	<!-- 부트스트랩 및 jQuery 스크립트 링크 추가 -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
</main>
