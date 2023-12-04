<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>
	
	<!-- mylogout.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Login Page</h2>
	
	<!-- 
		*** 주의
		1. method="POST"
		2. action="/컨텍스트명/로그아웃페이지"
		3. 아이디: name="username"
		3. 암호: name="password"
	 -->
	 
	 <form method="POST" action="/spring/auth/mylogout.do">
	 	<div>
	 		<button class="in">로그아웃</button>
	 	</div>
	 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	 </form>
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		
	</script>
</body>
</html>