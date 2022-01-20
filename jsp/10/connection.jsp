<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB연결테스트</title>
</head>
<body>
	<%
		Connection connection = null;
		//mysql서버에 접속하기 위한 경로를 설정함(jdbc:mysql ->프로토콜, //localhost -> 도메인
		//3306 : 포트번호, testdb -> 접속하 db명)
		String url = "jdbc:mysql://localhost:3306/testdb";
		String id = "root"; //접속 아이디
		String pw = "1234"; //접속 비밀번호
		String driver = "com.mysql.jdbc.Driver";
		
		try{
			//드라이버 명을 주고 동적객체를 생성. 이 과정을 지나면 driver가 DriverManager에 등록되어
			//연결 객체를 얻을 수 있다.
			Class.forName(driver);
			connection = DriverManager.getConnection(url, id, pw);
			out.println("데이터베이스 연결성공");
		}
		catch(Exception e) {
			out.println("데이터베이스 연결실패.<br>");
			out.println(e.getMessage()); //웹페이지 출력
			e.printStackTrace(); //콘솔 출력
		}
		finally {
			if(connection != null)
				connection.close();
		}
	
	%>
</body>
</html>