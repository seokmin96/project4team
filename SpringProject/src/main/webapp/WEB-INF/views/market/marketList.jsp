<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main>
	<h1>전통시장 둘러보기</h1>
	<iframe src = "<%= request.getContextPath() %>/resources/main.html" width = "1000" height = "500" ></iframe>
</main>