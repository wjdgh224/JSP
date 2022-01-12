<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String strScore = request.getParameter("score");
	String name = request.getParameter("name");
	
	//post방식으로 보낼 때 값을 session저장하여 다른 페이지로 이동할 때 파라메터값을 넘겨야 한다.
	pageContext.getSession().setAttribute("name", name);
	pageContext.getSession().setAttribute("score", strScore);
	
	//get방식으로 보낼 때
	//현재 페이제이서 다른 페이지로 넘기고 싶을때는 한글일 경우를 대비해서 아래와 같이 인코딩을 재차 한다.
	//String encodeName = URLEncoder.encode(name, "utf-8");
	int score = Integer.parseInt(request.getParameter("score"));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		if(score <0 || score > 100) {
			out.print("<h1>점수를 잘못 입력하셨습니다.</h1>");
			out.print("<a href='score.html'>점수 입력창으로 이동</a>");
			return;
		}
	%>

	<%
		//score점수에 따라 페이지 이동이 달라지는 코드.
		if(score >= 60) {
			System.out.println("scoreResult.jsp페이지를 지나갔습니다.");
			//response.sendRedirect("pass.jsp?name=" + encodeName + "&score=" + strScore);
			
			//post방식
			response.sendRedirect("pass.jsp");
		}
		else {
			System.out.println("scoreResult.jsp페이지를 지나갔습니다.");
			//response.sendRedirect("notPass.jsp?name=" + encodeName + "&score=" + strScore);
		
			//post방식
			response.sendRedirect("notPass.jsp");
		}
	%>
</body>
</html>