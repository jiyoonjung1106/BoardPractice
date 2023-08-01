<%@page import="dao.QuartzTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	QuartzTest start = new QuartzTest();
	if (request.getParameter("start") != null && request.getParameter("start").equals("true")) {
	    start.startScheduler();
	} else if (request.getParameter("stop") != null && request.getParameter("stop").equals("true")) {
	    start.stopScheduler();
	}
	
	
%>