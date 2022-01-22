
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 입력값 DB저장하기</title>
</head>
<body>
	<%@ include file="dbconn.jsp" %> <!-- 접속할 DB코드를 페이지 지시자 태그로 가져옴 -->
	<%-- <jsp:include page="dbconn.jsp"></jsp:include> ->결과가 반환 코드자체x --%>
	<%
		request.setCharacterEncoding("utf-8");
	
		//사용자가 입력한 내용을 가져와서 변수에 저장.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String username = request.getParameter("username");
		//쿼리문을 실행할 Statement객체 선언
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try{
			//쿼리문을 작성
			String sql = "insert into members values (?, ?, ?)";
			//connection객체로 부터 PrepareStatement객체를 얻어내는 코드
			//매개벼누값으로 sql문을 주어야 한다.
			pstmt = connection.prepareStatement(sql);
			//PrepareStatement객체를 이용하여 각각 ?에 해당하는 값들을 지정을 해주면 된다.
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, username);
			
			//쿼리문을 DB에 날리는 코드, 단 쿼리문을 매개변수로 넣지 않도록 한다. 미리 위에서 쿼리문으로
			//prepareStatement객체가 생성되었다.
			pstmt.executeUpdate();
			out.println("members테이블에 정삭적으로 삽입 성공되었습니다.");
		}
		catch(SQLException e) {
			out.println("members테이블에 삽입 실패되었습니다.");
			out.println("SQLException" + e.getMessage());
			e.printStackTrace();
		}
		finally {
			if(pstmt != null)
				pstmt.close();
			if(connection != null)
				connection.close();
		}
	%>
	<a href="select_preparestatement.jsp">회원 조회하기</a>
</body>
</html>