<%@page import="dao.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int point = Integer.parseInt(request.getParameter("point"));
	
	Member member = new Member();
	member.MemberUpdate(pw, name,point, id);
%>
<script>alert("수정되었습니다."); location.href="AdminPage0801.jsp";</script>