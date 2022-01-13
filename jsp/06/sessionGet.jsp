<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 값 확인</title>
</head>
<body>
	<%
		//지금은 하나하나의 Name을 주고 Value를 얻어서 출력.
		//session의 getAttribute()의 반환타입은 Object타입이여서 다운캐스팅.
		Object obj1 = session.getAttribute("abcde");
		Integer intValue = (Integer)obj1;
		out.println("abcde : " + intValue);
		
		Object obj2 = session.getAttribute("feed");
		String str2 = (String)obj2;
		out.println("feed : " + str2);
	%>
	<br>
	<%
		out.print("==============================<br>");
	
		String sName;
		String sValue;
		
		//getAttributeNames()의 반환값은 Enumeration<String> 열거형 제네릭 타입이다.
		//여기서는 String만 받도록 제네릭 타입을 설정.
		//getAttributeNames()은 세션에 설정되어있는 모든 Name값을 다 얻어오는 것이다.
		Enumeration<String> en = session.getAttributeNames();
		
		//가져올 데이터가 존재.
		while(en.hasMoreElements()) {
			sName = en.nextElement();
			sValue = session.getAttribute(sName).toString();
			out.println("sName : " + sName + "<br>");
			out.println("sValue : " + sValue + "<br>");
		}
		
		out.print("==============================<br>");
		//sessionID는 웹브라우저 하나당 생기는 유니크한 값이다. 서버에서 생성.
		String sessionID = session.getId();
		out.println("sessionID : " + sessionID + "<br>");
		
		//session의 유효시간은 기본적으로 30분이다.
		//설정을 바꾸고 싶다면 tomcat.8.5\conf폴더에 web.xml
		int sessionInterval = session.getMaxInactiveInterval();
		out.println("세션 유효시간(초) : " + sessionInterval);
		
		
		out.print("<br>==============================<br>");
		//abcde세션의 특정한 값을 삭제.
		//session.removeAttribute("abcde");
		
		
		
		Enumeration<String> en1 = session.getAttributeNames();
		
		//가져올 데이터가 존재.
		while(en1.hasMoreElements()) {
			sName = en1.nextElement();
			sValue = session.getAttribute(sName).toString();
			out.println("sName : " + sName + "<br>");
			out.println("sValue : " + sValue + "<br>");
		}
		out.print("<br>==============================<br>");
		
		//세션의 모든 값을 지운다.
		session.invalidate();
		
		if(request.isRequestedSessionIdValid()) {
			out.print("session valid");
		}
		else {
			out.print("session invalid");
		}
	%>
	
</body>
</html>