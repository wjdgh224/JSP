<%@page import="membership.MemberDTO"%>
<%@page import="membership.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String userId = request.getParameter("user_id");
String userPwd = request.getParameter("user_pw");

String sqlDriver = application.getInitParameter("Driver");
String sqlURL = application.getInitParameter("URL");
String sqlId = application.getInitParameter("Id");
String sqlPwd = application.getInitParameter("Pwd");

MemberDAO dao = new MemberDAO(sqlDriver, sqlURL, sqlId, sqlPwd);
MemberDTO memberDTO = dao.getMemberDTO(userId, userPwd);
dao.close();

if(memberDTO.getId()!=null) {
	session.setAttribute("UserId", memberDTO.getId());
	session.setAttribute("UserName", memberDTO.getName());
	response.sendRedirect("LoginForm.jsp");
}
else {
	request.setAttribute("LoginErrMsg", "로그인 오류입니다.");
	request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
}
%>
