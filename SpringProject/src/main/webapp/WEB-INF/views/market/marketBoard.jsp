<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	.marketBoard_list, .page>ul{ overflow:auto; }

	.marketBoard_list>li{
		float:left;
		height:40px;
		line-height:40px;
		border-bottom:1px solid #ddd;
		width:10%;
		
	}
	.marketBoard_list>li:nth-child(7n+2){ /* 6개씩 3번째(제목)부분을 전체 너비(1000px)의 50% */
		width:40%;
		/*말줄임표시*/
		white-space:nowrap; /*줄바꾸지마*/
		overflow:hidden; /*넘친 값 숨기기*/
		text-overflow:ellipsis; /*...으로 표시하기*/
	}
	.page {
		width:480px;
		padding-left:250px;
	}
	.page li{
		float:left;
		width:40px;
		height:40px;
		text-align:center;
	}
	.search, .listSelect{
		text-align:center;
	}
	
	
</style>

<main>
	<h1>전통시장 둘러보기</h1>
	<iframe src = "<%= request.getContextPath() %>/resources/main.html" width = "1000" height = "500" ></iframe>
	
	<!-- 선택 버튼 -->
	<div class="listSelect">
		<a href="/home/market/marketList"><button>전통시장 목록</button></a>
		<a href="/home/market/marketBoard"><button>정보 게시판</button></a>
	</div>
	
	<!-- 검색창 -->
	<div class="search">
		<form action="/home/market/marketBoard">
			<select name="searchKey" id="">
				<option value="ma_name">시장명</option>
				<option value="ma_addr1">시/도</option>
			</select>
			<input type="text" name="searchWord" id="searchWord" />
			<input type="submit" value="Search"  />
		</form>
	</div>
	
	<!-- 시장 정보 게시판 -->
	<h2>시장 정보 게시판</h2>
	<c:if test="${logType=='M'}">
		<div><a href="/home/market/marketWirte">정보 등록하기</a></div>
	</c:if>
	<div>총 레코드 수 : ${pDTO.totalRecord}개</div>
	<ul class="marketBoard_list">
		<li>번호</li>
		<li>제목</li>
		<li>시장명</li>
		<li>아이디</li>
		<li>등록일</li>
		<li>조회수</li>
		
		
		<c:forEach var="dto" items="${list}"> <!-- var:변수명, items:리스트 -->
			<li>${dto.mab_no}</li>
			<li><a href='/home/market/marketView?no=${dto.mab_no}&nowPage=${pDTO.nowPage}<c:if test="${pDTO.searchWord!=null}">&searchKey=${pDTO.searchKey}&searchWord=${pDTO.searchWord}</c:if>'>${dto.mb_title}</a></li>
			<li>${dto.ma_name}</li>
			<li>${dto.m_userid}</li>
			<li>${dto.mb_date}</li>
			<li>${dto.mb_hit}</li>
		</c:forEach>
	</ul>
	
	<!-- 페이징 -->
	<div class="page">
		<ul>
			<!-- 이전 페이지 -->
			<!-- 현재페이지가 1이면 prev를 눌러도 페이지이동이 없도록, 2이상이면 prev를 누르면 이전페이지로 이동-->
			<c:if test="${pDTO.nowPage == 1}">
				<li class='myButton'>prev</li>
			</c:if>
			<c:if test="${pDTO.nowPage > 1}">
				<li class='myButton'><a href='/home/market/marketBoard?nowPage=${pDTO.nowPage-1}<c:if test="${pDTO.searchWord!=null}">&searchKey=${pDTO.searchKey}&searchWord=${pDTO.searchWord}</c:if>'>prev</a></li>
			</c:if>
			
			<!-- 페이지 번호 -->
			<!-- var:변수, begin:시작값, end:끝값, step:증감값 -->
			<c:forEach var="p" begin="${pDTO.startPageNum}" end="${pDTO.startPageNum+pDTO.onePageNumCount-1}" step="1">
				<c:if test="${p <= pDTO.totalPage}">
					<c:if test="${p == pDTO.nowPage}">
						<li class='myButton' style="background:#ffd700"><a href='/home/market/marketBoard?nowPage=${p}<c:if test="${pDTO.searchWord!=null}">&searchKey=${pDTO.searchKey}&searchWord=${pDTO.searchWord}</c:if>'>${p}</a></li>
					</c:if>
					<c:if test="${p != pDTO.nowPage}">
						<li class='myButton'><a href='/home/market/marketBoard?nowPage=${p}<c:if test="${pDTO.searchWord!=null}">&searchKey=${pDTO.searchKey}&searchWord=${pDTO.searchWord}</c:if>'>${p}</a></li>
					</c:if>
				</c:if>
			</c:forEach>

			<!-- 다음 페이지 -->
			<c:if test="${pDTO.nowPage >= pDTO.totalPage}">
				<li class='myButton'>next</li>
			</c:if>
			<c:if test="${pDTO.nowPage < pDTO.totalPage}">
				<li class='myButton'><a href='/home/market/marketBoard?nowPage=${pDTO.nowPage+1}<c:if test="${pDTO.searchWord!=null}">&searchKey=${pDTO.searchKey}&searchWord=${pDTO.searchWord}</c:if>'>next</a></li>
			</c:if>
		</ul>
	</div>
	
	
</main>