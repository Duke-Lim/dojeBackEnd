<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<c:forEach items="${result}" var="comment">
		 <tr>
		 	<td>${comment.com_id}</td>
		 	<td>${comment.user_nickname}</td>
		 	<td>${comment.post_id}</td>
		 	<td>${comment.com_content}</td>
		 	<td>${comment.com_created}</td>
		 	<td>${comment.group_id}</td>
		 	<td>${comment.level}</td>
		 	<td>${comment.com_seq}</td>
		 </tr>
	</c:forEach>
	</table>
</body>
</html>