<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include지시자</title>
</head>
<body>
	<h1>includeOrder.jsp페이지입니다.</h1>
	<!-- include페이지 지시자를 이용해서 include.jsp를 부르고 있다.(포함시킨다.) -->
	<%@include file = "include.jsp" %>
	<%@include file = "scriptlet_06.jsp" %>
	<h1>다시 includeOrder.jsp페이지입니다.</h1>
</body>
</html>