<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>유저 리스트</h1>
	<table border="1">
		<c:forEach items="${result}" var="user">
			<tr>
				<td>${user.user_id}</td>
				<td>${user.user_pw}</td>
				<td>${user.user_nickname}</td>
				<td>${user.user_authority}</td>
				<td>${user.user_created}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h1>유저 찾기</h1>
	<form action="/test/user.do">
		<input type="text" name="id"/><br>
		<button type="submit">전송</button>
	</form>
	
	<h1>가입</h1>
	<form action="/test/user" method="POST">
		이메일 : <input type="text" name="USER_EMAIL"/><br>
		비번 : <input type="text" name="USER_PW"/><br>
		닉네임 :<input type="text" name="USER_NICKNAME"/><br>
		<button type="submit">전송</button>
	</form>
</body>
</html>