<!-- 현재 이 페이지에서 예외가 발생을 하면 페이지 지시자에 있는 속성 중 errorPage로 설정한 페이지로
이동하라는 지시자의 내용 -->
<%@ page errorPage="exceptionPage.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//int i = 100/0;
	
		int value = Integer.parseInt("100aaaa");
	%>
</body>
</html>