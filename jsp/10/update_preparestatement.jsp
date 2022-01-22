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
			
			
			if(rs.next()) {
				String rId = rs.getString("id");
				String rPw = rs.getString("pw");
				if(id.equals(rId) && pw.equals(rPw)) {
					sql = "update members set username = ? where id = ?";
					if(pstmt != null)
						pstmt.close();
					pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, username);
					pstmt.setString(2, id);
					pstmt.executeUpdate();
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
			if(pstmt != null) pstmt.close();
			if(connection != null) connection.close();
		}
	%>
	<br>
	<a href="select_preparestatement.jsp">회원리스트 보기</a> &nbsp;&nbsp;&nbsp;
	<a href="insert_form_preparestatement.jsp">회원 가입창으로 가기</a>
</body>
</html>