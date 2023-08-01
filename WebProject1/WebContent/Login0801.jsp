<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
	 function redirectToMemberJoinPage() {
         window.location.href = "MemberJoin0801.jsp";
     }
	</script>
</head>
<body>
	<h2>로그인</h2>
    <form action="LoginAction0801.jsp" method="post">
        <label for="username">ID:</label>
        <input type="text" id="username" style="margin-left: 9px;" name="username" required>
        <br>
        <label for="password">PW:</label>
        <input type="password" id="password" name="password" required>
        <br>
        <input type="submit" value="로그인" style="width: 212px;margin-top: 4px;">
        <br>
        <button type="button" style="width: 212px;margin-top: 4px;" onclick="redirectToMemberJoinPage()">회원가입</button>
    </form>
</body>
</html>