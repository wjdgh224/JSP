<%-- <%@page부분은 페이지 지시자이다. 페이지의 속성이나 import할 때 자주 사용.%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫번째 JSP파일입니다.</title>
</head>
<body>
	<%	int i = 10;
		out.print("i의 값 : " + i);
	%>
	<h1>안녕하세요.JSP파일입니다.</h1>
	<h1>응답은 HTML코드로 합니다.</h1>
</body>
</html>
<!-- 실제 Hello_jsp.java, Hello_jsp.class파일을 확인하는 경로
C:\Users\황정호\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\Practice_Chap05_JSP-1\org\apache\jsp -->