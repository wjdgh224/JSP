<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문, 표현식</title>
</head>
<body>
	<%!
		int i = 10;
		String str = "신은혁";
		
		public int add(int x, int y) {
			return x*y;
		}
	%>
	<!-- 표현식에서는 ;을 붙이지 않는다. -->
	<%=i %><br>
	<%=str %><br>
	<%=add(100, 2) %>
</body>
</html>