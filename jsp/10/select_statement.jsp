<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB SELECT결과</title>
</head>
<body>
	<%@include file="dbconn.jsp" %><!-- 디비접속 -->
	
	<table border="1">
		<tr>
			<th width="300" align="center">아이디</th>
			<th width="300" align="center">비밀번호</th>
			<th width="300" align="center">이름</th>
		</tr>
		<%
			ResultSet rs = null; //select한 결과를 받아오는 객체
			Statement stmt = null;
			
			try {
				String sql = "select * from members";
				stmt = connection.createStatement();
				rs = stmt.executeQuery(sql);
				
				//가져올 행이 있느냐?
				while(rs.next()) {
					//해당하는 행의 컬럼값들을 각각 저장하고 있다.
					String id = rs.getNString("id");
					String pw = rs.getNString("pw");
					String username = rs.getNString("username");
					
			%>
			<tr>
				<td width="300" align="center"><%=id %></td>
				<td width="300" align="center"><%=pw %></td>
				<td width="300" align="center"><%=username %></td>
			</tr>
			<% 	
					}
				}
				catch(SQLException e) {
					out.println("members테이블 select오류가 발생했습니다.");
					out.println("SQLException : " + e.getMessage());
					e.printStackTrace();
				}
				finally {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(connection != null) connection.close();
				}
			%>
	</table>
	<a href="insert_form_statement.jsp">회원 가입창으로</a>
</body>
</html>