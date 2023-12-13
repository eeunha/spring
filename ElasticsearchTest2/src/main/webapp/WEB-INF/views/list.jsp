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
	#list th:nth-child(1) {
		width: 150px;	
	}
	#list th:nth-child(2) {
		width: auto;	
	}
	#list th:nth-child(3) {
		width: 120px;	
	}
</style>
</head>
<body>
	<!-- list.jsp -->
	<h1>Elasticsearch <small>List</small></h1>
	
	<div class="seperate">
		<span></span>
		<button type="button" class="add" onclick="location.href='/elasticsearch/add.do';">문서추가하기</button>
	</div>
	
	<table id="list">
		<tr>
			<th>(문서)아이디</th>
			<th>메시지</th>
			<th>스코어</th>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		
	</script>
</body>
</html>