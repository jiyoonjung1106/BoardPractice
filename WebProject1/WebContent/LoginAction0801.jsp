<%@page import="dao.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	Member login = new Member();
	boolean loginSuccess = login.loginSuccess(username, password);
	
    if (loginSuccess) {
        session.setAttribute("username", username);
        if ("admin".equals(username)) {
            response.sendRedirect("AdminPage0801.jsp"); // 관리자 페이지로 이동
        } else {
            response.sendRedirect("Main0801.jsp"); // 일반 사용자의 경우 메인 페이지로 이동
        }
    } else {
%>
        <script>alert('아이디/비밀번호를 다시 확인하세요.'); location.href='Login0801.jsp';</script>
<%
    }
%>