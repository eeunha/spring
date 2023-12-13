<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<!-- add.jsp -->
	<h1>
		Elasticsearch <small>Add</small>
	</h1>

	<form method="POST" action="/elasticsearch/addok.do">
		<table class="vertical">
			<tr>
				<th>(문서)아이디</th>
				<td><input type="text" name="id" class="short" required
					autofocus></td>
			</tr>
			<tr>
				<th>메시지</th>
				<td><input type="text" name="message" class="full" required></td>
			</tr>
		</table>

		<div class="seperate">
			<button type="button" class="list"
				onclick="location.href='/elasticsearch/list.do';">돌아가기</button>
			<button type="submit" class="add">문서추가하기</button>
		</div>
	</form>


	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		
	</script>
</body>
</html>