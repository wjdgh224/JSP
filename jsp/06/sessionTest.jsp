<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 확인</title>
</head>
<body>
	<h1>세션의 속성이 삭제된 것을 확인하는 페이지 입니다.</h1>
	
	<%
		Enumeration<String> en = session.getAttributeNames();
		int i=0;
		
		while(en.hasMoreElements()) {
			i++;
			String sName = en.nextElement();
			String sValue = (String)session.getAttribute(sName);
			
			out.println("sName : " + sName + "<br>");
			out.println("sValue : " + sValue + "<br>");
		}
		if(i==0) {
			out.println("해당 세션이 삭제되었습니다." + "<br>");
		}
		session.invalidate();//세션의 값이 많을때 사용.
		out.println("해당 세션 id(유니크 값)" + session.getId() + "<br>");
	%>
	
	<!-- 차이점
	쿠키는 로컬PC에 저장되기 때문에 보안에 취약
	세션은 서버에 객체로 존재한다. 보안에 강함. JSP를 통해서만 접근 가능.
	여러 클라이언트가 접속하므로 한 클라이언트에 하나의 세션을 생성하고
	세션아이디 부여한다.
	세션아이디를 가지고 어느 클라이언트에서 요청이 들어오는지 서버는 구분할 수 있다.
	현업에서는 세션을 많이 사용. -->
</body>
</html>