<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과창</title>
</head>
<body>
	<!-- <h1>결과 출력</h1> -->
	
	<%
		//id, pw 유효성 검사를 하고 있다.
		if(user_id == null || user_id.length() == 0 
		|| user_pw == null || user_pw.length() == 0) { 
	%>
		아이디, 비밀번호를 입력하세요!!<br>
	<a href="main.html">로그인 페이지 이동</a>
	<%
		}
		else {
			if(user_id.equals("admin")) {
	%>
	<h1>관리자로 로그인 했습니다.</h1>
	<form>
		<input type="button" value="회원정보 리스트 보기"><br>
		<input type="button" value="회원정보 수정하기"><br>
		<input type="button" value="회원정보 삭제하기"><br>
	</form>
	<%
			}
		}
	%>
	<%-- <h1>비밀번호 : <%=user_pw %></h1> --%>
</body>
</html>