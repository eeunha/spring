<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<!-- member > favorite.jsp -->
	<%@ include file="/WEB-INF/inc/main_menu.jsp" %>
	
	<%@ include file="/WEB-INF/inc/member_menu.jsp" %>
	
	<main>
		<h1>회원 <small>즐겨찾기</small></h1>
		<div class="list">
			<div><a href="#">구글</a></div>
			<div><a href="#">아마존</a></div>
			<div><a href="#">깃헙</a></div>
		</div>
	</main>
	
	<script>
		
	</script>
</body>
</html>