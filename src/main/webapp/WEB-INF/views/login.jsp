<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${error == 'true'}">
		<script type="text/javascript">
			alert("로그인 실패");
		</script>
	</c:if>

	<h1>로그인</h1>
	
	<form action="j_spring_security_check" method="POST">
		아이디 : <input type="text" name="id"/>
		비번 : <input type="password" name="pw"/>
		<button type="submit">전송</button>
	</form>
	
	
	
</body>
</html>