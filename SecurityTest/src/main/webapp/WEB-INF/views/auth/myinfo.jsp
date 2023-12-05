<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
	<!-- myinfo.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>MyInfo Page <small>내 정보</small></h2>
	
	<!-- 
		property="principal"
		- CustomUser 객체
		
	 -->
	<div class="message" title="principal">
		<sec:authentication property="principal"/> <!-- principal - 예약어 -->
	</div>
	
	<div class="message" title="MemberDTO">
		<sec:authentication property="principal.dto"/>
	</div>
	
	<div class="message" title="사용자 이름">
		<sec:authentication property="principal.dto.username"/>
	</div>
	
	<div class="message" title="사용자 아이디">
		<sec:authentication property="principal.dto.userid"/> 
		<sec:authentication property="principal.username"/> 
	</div>
	
	<div class="message" title="사용자 권한">
		<sec:authentication property="principal.dto.authlist"/>
	</div>
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		
	</script>
</body>
</html>