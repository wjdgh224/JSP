<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 확인</title>
</head>
<body>
	<h1>쿠키의 속성이 삭제된 것을 확인하는 cookieTest.jsp페이지 입니다.</h1>
	
	<%
		System.out.println("삭제된 쿠키의 값을 출력해봅니다.");
		//쿠키의 유효시간이 0으로 설정한 쿠키가 리턴될 것이다.
		Cookie[] cookies = request.getCookies();
		
		//확인해보니 현재 남아있는 쿠키 이름 : JSESSIONID ->서버 생성
		//현재 남아있는 쿠키 값 : 333DB0B4E7B3D30A0264DA6E8F8809E9 ->서버 생성
		//위의 이름과 같은 무시.(항상 출력)
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				out.println("현재 남아있는 쿠키 이름 : " + cookies[i].getName());
				out.println("현재 남아있는 쿠키 값 : " + cookies[i].getValue());
			}
		}
		
		//쿠키를 생성하고 response객체에 탑재.
		//변경이 일어난다면 반드시  response객체에 재탑재.
		//쿠키값이 일관성 있게 유지.
	%>
</body>
</html>