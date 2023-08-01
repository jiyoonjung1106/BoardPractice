<%@page import="dao.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member member = new Member();
	String memberId = request.getParameter("memberId");
	member.MemberDelete(memberId);
%>
 <script>alert('삭제되었습니다.'); </script>