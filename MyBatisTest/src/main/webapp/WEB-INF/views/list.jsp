<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Example</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>

</style>
</head>
<body>
	<!-- list.jsp -->
	<h1>결과</h1>
	
	<div class="message" title="결과">${result}</div>
	
	<div class="message" title="레코드 수">${count}</div>
	
	<div class="message" title="DTO">${dto}</div>

	<div class="list">
		<c:forEach items="${names}" var="name">
			<div>${name}</div>
		</c:forEach>
	</div>
	
	<div class="list">
		<c:forEach items="${list}" var="dto">
			<div>${dto.name} - ${dto.age} - ${dto.address}</div>
		</c:forEach>
	</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		
	</script>
</body>
</html>