<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="include/include.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${path}/">돌아가기</a>
	<h1>오류</h1>
	${exception.getMessage()}<br>
	<c:forEach var="stack" items="${exception.getStackTrace()}" >
		${stack.toString()}<br>
	</c:forEach>
</body>
</html>