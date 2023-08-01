<%@page import="dao.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	
	Member member = new Member();
	member.joinMember(username, password, name);
%>
<script>alert("가입되었습니다. 로그인 해주세요."); location.href="Login0801.jsp";</script>