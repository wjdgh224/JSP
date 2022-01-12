<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 만들기</title>
</head>
<body>
	<h1>서버에서 쿠키를 생성하는 cookieSet.jsp페이지 입니다.</h1>
	<%
		System.out.println("서버에서 쿠키를 생성하였으며, 응답하기 위해서 response객체에 추가 하였습니다.");
		
		request.setCharacterEncoding("utf-8");
		
		//쿠키는 통상 클라이언트가 접속을 하면 서버쪽에서 생성하여 해당 클라이언트에게 보내어 로컬PC에 저정하는 방식
		//쿠키속성(이름, 값)을 설정할 때는 반드시 한글로 만들어지지 않기 때문에 영문이나 숫자로 설정.
		Cookie cookie = new Cookie("abcde", "12345");
		cookie.setMaxAge(60*60);//쿠키의 유효시간
		//쿠키속성을 지정했다면, 반드시 response객체에 추가.
		response.addCookie(cookie);
	%>
	<br><br>
	<a href="cookieGet.jsp">쿠키값 확인하는 창으로 이동</a>
</body>
</html>