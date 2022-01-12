<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	//String score = request.getParameter("score");
	//String name = request.getParameter("name");
	
	//post방식
	String score = (String)pageContext.getSession().getAttribute("score");
	String name = (String)pageContext.getSession().getAttribute("name");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>불합격창</title>
</head>
<body>
	<h1><%= name %>님은 <%= score %>점으로 불합격하셨습니다.</h1>
	<a href="score.html">점수 입력창으로 이동</a>
</body>
</html>