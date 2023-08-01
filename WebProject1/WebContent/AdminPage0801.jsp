<%@page import="dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Member member = new Member();
	ArrayList<MemberDto> memberlist = member.getMembers();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script>
		function redirectToLoginPage() {
		    location.href = 'Login0801.jsp';
		}
		 function deleteMember(memberId) {
			    location.href = 'MemberDeleteAction.jsp?memberId=' + encodeURIComponent(memberId);
		 }
		 function updateMember(memberId) {
			    location.href = 'MemberInformationUpdate0801.jsp?memberId=' + encodeURIComponent(memberId);
		 }
	</script>
	<style>
		table {
				border-collapse: collapse;
			}
			th,td {
				border: 1px solid grey;
				padding: 8px;
			}
		.fr{
			float : right;
		}
		.login_bt{
			    position: relative;
			    bottom: 49px;
			    right: 91px;
		}
	</style>
</head>
<body>
	<div style="width : 500px;">
		<div>
			<h1>회원관리</h1>
			<button onclick="redirectToLoginPage()" class="fr login_bt">로그인</button>
		</div>	<!-- 회원관리 -->
		<div>
			<table>
				<tr>
					<th>ID</th>
					<th>PW</th>
					<th>Name</th>
					<th>Point</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<%for(MemberDto dto : memberlist) {%>
				<tr>
					<td class="bno"><%=dto.getId() %></td>
					<td><%=dto.getPw() %></td>
					<td><%=dto.getName() %></td>
					<td><%=dto.getPoint() %></td>
					<td><button class="modify_bt" onclick="updateMember('<%= dto.getId() %>')">수정</button></td>
					<td><button class="delete_bt" onclick="deleteMember('<%= dto.getId() %>')">삭제</button></td>
				</tr>
				<%} %>
			</table>
		</div> <!-- 회원관리 테이블 -->
		<div>
			<h1>스케줄러 관리</h1>
			<button class="start" onclick="window.location.href='StartSchedulerAction.jsp?start=true'">스케줄러(20초마다 포인트1증가) 실행 시작</button>
			<button class="end" onclick="window.location.href='StartSchedulerAction.jsp?stop=true'">스케줄러 실행 종료</button>
		</div> <!--스케줄러관리 -->
	</div>
</body>
</html>