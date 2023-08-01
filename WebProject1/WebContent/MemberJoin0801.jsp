<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
    <form action="MemberJoinAction0801.jsp" method="post">
        <label for="username">ID:</label>
        <input type="text" id="username" style="margin-left: 26px;" name="username" required>
        <br>
        <label for="password">PW:</label>
        <input type="password" id="password" style="margin-left: 18px;" name="password" required>
        <br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
        <br>
        <input type="submit" value="작성완료" style="width: 229px;margin-top: 4px;">
    </form>
</body>
</html>