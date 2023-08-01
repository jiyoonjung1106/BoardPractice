<%@page import="dao.Member"%>
<%@page import="dao.PointDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username = (String) session.getAttribute("username");
	PointDao point = new PointDao();
	Member member = new Member();
	String name = member.getMember(username);
	int pointmoney = member.getPoint(username);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src ="js/jquery-3.7.0.min.js"></script>
	<style>
		.border {
			border : 1px solid green;
		}
		.fr{
			float : right;
		}
		.fl{
			flaot : left;
		}
		.subject{
		    position: relative;
    		right: 252px;
    	}
    	.img{
    		    position: relative;
			    top: 22px;
			    left: 54px;
    	}
    	.main_login{
    		    position: relative;
    			bottom: 58px;
    	}
    	.main_point{
    		        position: relative;
				    bottom: 57px;
				    left: 132px;
    	}
	</style>
	<script>
		function logout() {
			  location.href = "LogoutAction0801.jsp";
		}
		$(function(){
			$(".program").click(function(){
				location.href = "PointProgramMinusAction.jsp?userpoint=<%=pointmoney%>&point=<%=point.subjectProgramPoint()%>";
			});
			$(".java").click(function(){
				location.href = "PointJavaMinusAction.jsp?userpoint=<%=pointmoney%>&point=<%=point.subjectProgramPoint()%>";
			});
			$(".c").click(function(){
				location.href = "PointCMinusAction.jsp?userpoint=<%=pointmoney%>&point=<%=point.subjectProgramPoint()%>";
			});
		});
		document.addEventListener("DOMContentLoaded", function() {
            document.getElementById("adImage").addEventListener("click", function () {
                var minPoint = 1; 
                var maxPoint = 1000;
                var randomPoint = Math.floor(Math.random() * (maxPoint - minPoint + 1)) + minPoint;

                alert("적립 점수: " + randomPoint + "점");
                location.href = "http://koreaisacademy.com";
            });
        });
	</script>
</head>
<body>
	<div>
		<div>
				<h1>메인페이지</h1>
			<div class="fr main_login">
				<span><%=name %>(<%=username %>)님 안녕하세요.</span>
				<button type="button" onclick="logout()">로그아웃</button>
			</div>
			<br>
			<div>
				<span class="fr userpoint main_point">포인트 : <%=pointmoney %>점</span>
			</div>
		</div>
		<div>
			<h2>구입할 컨텐츠를 선택하세요.</h2>
			<img class="fl program" src="Images/Intro_350_408.png">
			<span class="subject"><%=point.subjectProgramPoint() %>포인트</span>
			<img class="fl java" src="Images/Java_350_408.png">
			<span class="subject"><%=point.subjectJavaPoint() %>포인트</span>
			<img class="fl c" src="Images/Cpp_350_408.png">
			<span class="subject"><%=point.subjectCPoint() %>포인트</span>
		</div>
		<div>
			<div>
				<span class="fr">&lt;광고&gt;</span>
				<img class="fr img" src="Images/korea_it.png" id="adImage">
			</div>
		</div>
	</div>
</body>
</html>