<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<style>
		.div_menu a{
			color: pink;
			font-size: 1.5rem;
			text-decoration: none;
			padding-right:30px;
		}
	</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class='div_menu'>
		<a href="/">홈</a>
		<a href="/posts">게시글</a>
		<a href="/users">사용자목록</a>
		<a href="/login">로그인</a>
	</div>
	<hr/>	
	<jsp:include page="${pageName}"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>