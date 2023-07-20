<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://cdn.ckeditor.com/ckeditor5/38.0.1/super-build/ckeditor.js"></script>
<script src="/home/inc/ckeditor.js"></script>

<style>
	.ck-editor__editable[role="textbox"] {
	    /* editing area */
	    min-height: 200px;
	}
	.ck-content .image {
	    /* block images */
	    max-width: 80%;
	    margin: 20px auto;
	}
	#subject{width:100%;}
</style>
        
<main>
	<h1>게시판 글수정</h1>
	<form action="/home/marketk/marketEditOk" method="post">
	<input type="hidden" name="mab_no" value="${dto.mab_no}" />
		<ul>
			<li>제목</li>
			<li><input type="text" name="mb_title" id="mb_title" value="${dto.mb_title}" /></li>
			<li>글내용</li>
			<li><textarea name="mb_content" id="mb_content">${dto.mb_content}</textarea></li>
			<li><input type="submit" value="글수정" /></li>
		</ul>
	</form>
</main>
<script>
	CKEDITOR.ClassicEditor.create(document.getElementById("content"),option);
</script>