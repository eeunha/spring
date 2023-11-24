<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<link rel="stylesheet" href="/code/resources/highlight/styles/github.min.css">
<style>
table tr:nth-child(1) th {
	width: 120px;
}

table tr:nth-child(1) td {
	width: 263px;
}

#code {
	margin: 1rem;
	border: 1px solid #CCC;
}

#code * {
	font-family: consolas;
}
</style>
</head>
<body>
	<!-- view.jsp -->

	<h1>
		Code <small>view</small>
	</h1>

	<table>
		<tr>
			<th>번호</th>
			<td>${dto.seq}</td>
			<th>날짜</th>
			<td>${dto.regdate}</td>
		</tr>
		<tr>
			<td colspan="4">${dto.subject}</td>
		</tr>
	</table>

	<!-- 개행문자를 있는 그대로 처리 -->
	<pre id="code">
	<code class="language-${dto.language}">
		<c:out value="${dto.code}" />
	</code>
	</pre>

	<div>
		<button type="button" class="back"
			onclick="location.href='/code/list.do';">돌아가기</button>
	</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="/code/resources/highlight/highlight.min.js"></script>
	<script>
		hljs.highlightAll();
	</script>
</body>
</html>