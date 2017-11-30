<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>글 리스트</h1>
	<table border="1">
		<c:forEach items="${result}" var="post">
			<tr>
				<td>${post.post_id}</td>
				<td>${post.post_title}</td>
				<td>${post.post_content}</td>
				<td>${post.post_created}</td>
				<td>${post.post_view}</td>
				<td>${post.user_nickname}</td>
				<td>${post.group_id}</td>
				<td>${post.level}</td>
				<td>${post.post_seq}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h1>글 찾기</h1>
	<form action="/test/post.do" method="GET">
		<input type="text" name="id"/>
		<button type="submit">전송</button>
	</form>
	
	<h1>글 작성</h1>
	<form action="/test/writePost.do" method="POST">
		제목 : <input type="text" name="POST_TITLE"/><br>
		내용 : <input type="text" name="POST_CONTENT"/><br>
		아이디 : <input type="text" name="USER_ID"/><br>
		그룹 아이디 : <input type="text" name="GROUP_ID"/><br>
		레벨 : <input type="text" name="LEVEL"/><br>
		시퀀스 : <input type="text" name="POST_SEQ"/><br>
		<button type="submit">전송</button>
	</form>
	
	<h1>파일 업로드</h1>
	<form action="/test/fileupload.do" method="POST" enctype="multipart/form-data">
		아이디 : <input type="text" name="user_id"/>
		글아이디 : <input type="text" name="post_id"/>
		파일 : <input type="file" name="file"/>
		<button type="submit">전송</button>
	</form>
	
	<h1>파일보기</h1>
	<form action="/test/fileList.do">
		글 아이디 : <input type="text" name="post_id"/>
		<button type="submit">전송</button>
	</form>
</body>
</html>
