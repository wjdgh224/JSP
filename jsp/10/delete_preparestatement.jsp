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
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select id, pw from members where id = ?";	
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			//ResultSet객체가 닫히는 경우 : ResultSet의 결과물을 가지고온 Statement객체가 닫힐 경우 ResultSet객체도 함께 닫힘.
			//if(stmt != null)
				//stmt.close();
			
			if(rs.next()) {
				String rId = rs.getString("id");
				String rPw = rs.getString("pw");
				
				//id와 pw가 일치하는지 확인한 후에 삭제를 진행한다.
				if(id.equals(rId) && pw.equals(rPw)) {
					sql = "delete from members where id = ? and pw = ?";
					
					if(pstmt!=null)
						pstmt.close();
					//Statement객체는 쿼리를 단 한번 실행. 재사용을 하기 위해서는 반드시 또 Connection객체로 부터
					//Statement객체를 얻어야 한다. 그래서 상당히 쿼리문이나 사용법에서 불편하다.
					pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, pw);
					pstmt.executeUpdate();
					out.println(rId + "님의 정보를 삭제했습니다.");
				}
				else {
					out.println("일치하는 비밀번호가 아닙니다.");
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
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		}
	%>
	<br>
	<a href="select_preparestatement.jsp">회원리스트 보기</a> &nbsp;&nbsp;&nbsp;
	<a href="update_form_preparestatement.jsp">회원 정보수정으로 가기</a> &nbsp;&nbsp;&nbsp;
	<a href="insert_form_preparestatement.jsp">회원 가입창으로 가기</a>
</body>
</html>