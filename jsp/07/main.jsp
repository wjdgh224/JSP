<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<!-- 아래 h1태그 부분은 잠깐 출력은 된다. 물론 육안으로 확인이 안된다. why? 아래코드에서
	forward액션태그를 이용하여 sub.jsp페이지로 이동하라고 코딩했기에. -->
	<h1>main.jsp페이지 입니다.</h1>
	<%
		System.out.println("sub.jsp페이지 이동하기 전 main.jsp페이지 입니다.");
		//sendRedirect()는 URL주소가 바뀐다.
		//response.sendRedirect("sub.jsp");
	%>
	<!-- forward액션태그는 URL주소는 main.jsp로 변하지 않고 페이지 이동만 일어나서 보여주는 페이지가 sub.jsp
	forward액션태그의 특징. -->
	<jsp:forward page="sub.jsp"></jsp:forward>
</body>
</html>