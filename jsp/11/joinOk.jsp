<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String username = request.getParameter("username");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String gender = request.getParameter("gender");
	
	//out.println(username); out.println(id); out.println(pw); out.println(phone1);
	//out.println(phone2); out.println(phone3); out.println(gender);
	
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = new MemberDTO();
	
	//클라이언트가 입력한 회원가입정보를 DTO객체에 저장하는 코드
	dto.setUsername(username);
	dto.setId(id);
	dto.setPw(pw);
	dto.setPhone1(phone1);
	dto.setPhone2(phone2);
	dto.setPhone3(phone3);
	dto.setGender(gender);
	//ArrayList에 새로운 맴버를 추가하고 있다.
	dao.addMember(dto);
	response.sendRedirect("memberList.jsp");
%>