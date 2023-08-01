<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("username");
%>
<script>alert("로그아웃 되었습니다."); location.href="Login0801.jsp";</script>