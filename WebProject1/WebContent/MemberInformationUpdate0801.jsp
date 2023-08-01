<%@page import="dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memberId = request.getParameter("memberId");
	Member member = new Member();
	ArrayList<MemberDto> memberlist = member.getOneMember(memberId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원관리-수정관리자</h1>
	<form action="MemberInformationUpdateAction0801.jsp" method="post">
		<%for(MemberDto dto : memberlist) {%>
		  <label for="id">ID:</label>
		  <input type="text" id="id" name="id" value="<%=memberId%>" readonly>
		</br>
		  <label for="pw">PW:</label>
		  <input type="password" id="pw" name="pw" value="<%=dto.getPw() %>" required>
		</br>
		  <label for="name">Name:</label>
		  <input type="text" id="name" name="name" value="<%=dto.getName() %>" required>
		</br>
		  <label for="point">point:</label>
		  <input type="number" id="point" name="point" value="<%=dto.getPoint() %>" required>
		</br>
		  <input type="submit" value="제출">
		<%} %>
	</form>
</body>
</html>