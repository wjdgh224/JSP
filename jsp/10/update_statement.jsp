<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB데이터 수정</title>
</head>
<body>
	<%@ include file="dbconn.jsp" %> <!-- 접속할 DB코드를 페이지 지시자 태그로 가져옴 -->
	
	<%
		request.setCharacterEncoding("utf-8");
	
		//사용자가 입력한 내용을 가져와서 변수에 저장.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String username = request.getParameter("username");
		//쿼리문을 실행할 Statement객체 선언
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select id, pw from members where id = '" + id + "'";	
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			//ResultSet객체가 닫히는 경우 : ResultSet의 결과물을 가지고온 Statement객체가 닫힐 경우 ResultSet객체도 함께 닫힘.
			//if(stmt != null)
				//stmt.close();
			
			if(rs.next()) {
				String rId = rs.getString("id");
				String rPw = rs.getString("pw");
				if(id.equals(rId) && pw.equals(rPw)) {
					sql = "update members set username = '" + username + "' where id = '" + id + "'";
					
					if(stmt!=null)
						stmt.close();
					//Statement객체는 쿼리를 단 한번 실행. 재사용을 하기 위해서는 반드시 또 Connection객체로 부터
					//Statement객체를 얻어야 한다. 그래서 상당히 쿼리문이나 사용법에서 불편하다.
					stmt = connection.createStatement();
					stmt.executeUpdate(sql);
					out.println(rId + "님의 정보가 수정되었습니다.");
				}
				else {
					out.println("아이디 그리고 비밀번호를 확인해주세요.");
				}
			}
			else {
				out.println("members테이블에 일치하는 아이디가 없습니다.");
			}
		}
		catch(SQLException e) {
			out.println("SQLException : " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(connection != null) connection.close();
		}
	%>
	<br>
	<a href="select_statement.jsp">회원리스트 보기</a> &nbsp;&nbsp;&nbsp;
	<a href="insert_form_statement.jsp">회원 가입창으로 가기</a>
</body>
</html>