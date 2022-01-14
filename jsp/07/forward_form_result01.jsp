<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼태그와 포워드 결과1</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		System.out.println("forward_form_result01.jsp지나감");
	%>
	
	<!-- forward액션태그를 이용해서 forward_form에서 form태그로 요청한 hidden속성을 지정한 값으로
	페이지 이동을 시키고 있다. param액션태그를 이용해서 tel값을 넘기고 있다.
	여기서 넘어온 값을 가져가기 위한 것은 스크립트릿 양옆에 ''으로 감싸야 한다. -->
	<jsp:forward page='<%=request.getParameter("forwardPage") %>'>
		<jsp:param value="053-666-7777" name="tel"/>
	</jsp:forward>
</body>
</html>