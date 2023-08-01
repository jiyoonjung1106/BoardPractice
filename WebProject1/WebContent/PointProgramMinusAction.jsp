<%@page import="dao.PointDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String username = (String) session.getAttribute("username");
	int point = Integer.parseInt(request.getParameter("point"));
	int userpoint = Integer.parseInt(request.getParameter("userpoint"));
	PointDao dao = new PointDao();
	
	if (userpoint >= point) {
		dao.subjectProgramMinus(username);
%>
	<script>alert("컨텐츠(intro)를 구입하였습니다."); location.href="Main0801.jsp";</script>
<%
	} else {
		%>
		<script>alert("포인트가 부족합니다. 광고를 클릭하세요."); location.href="Main0801.jsp";</script>
<%
	}
%>