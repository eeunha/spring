<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

#list td:nth-child(1) {
	text-align: center;
}

#list td:nth-child(3) {
	text-align: center;
}

form {
	border: 1px solid #CCC;
	margin: 1rem;
	padding-bottom: .5rem;
}

form div {
	margin-bottom: 5px;
}
</style>
</head>
<body>
	<!-- list.jsp -->
	<h1>
		Elasticsearch <small>List</small>
	</h1>

	<div class="seperate">
		<button type="button" class="list"
			onclick="location.href='/elasticsearch/list.do';">결과 초기화</button>
		<button type="button" class="add"
			onclick="location.href='/elasticsearch/add.do';">문서추가하기</button>
	</div>

	<table id="list">
		<tr>
			<th>(문서)아이디</th>
			<th>메시지</th>
			<th>스코어</th>
		</tr>
		<c:forEach items="${list}" var="map">
			<tr>
				<td>${map.id}</td>
				<td>${map.message}</td>
				<td>${map.score}</td>
			</tr>
		</c:forEach>
	</table>

	<!-- 검색 -->
	<hr>

	<form method="GET" action="/elasticsearch/list.do">
		<div class="match_or">
			<h4>검색하기 :: match(or)</h4>
			<div>
				<input type="text" name="word"> <input type="submit"
					value="검색하기">
			</div>
		</div>
		<input type="hidden" name="type" value="match_or">
	</form>


	<form method="GET" action="/elasticsearch/list.do">
		<div class="match_and">
			<h4>검색하기 :: match(and)</h4>
			<div>
				<input type="text" name="word"> <input type="submit"
					value="검색하기">
			</div>
		</div>
		<input type="hidden" name="type" value="match_and">
	</form>


	<form method="GET" action="/elasticsearch/list.do">
		<div class="match_phrase">
			<h4>검색하기 :: match(phrase)</h4>
			<div>
				<input type="text" name="word"> <input type="submit"
					value="검색하기">
			</div>
			<div>
				<div class="group">
					<label>slop</label> <input type="number" name="slop" min="0"
						value="0">
				</div>
			</div>
		</div>
		<input type="hidden" name="type" value="match_phrase">
	</form>


	<form method="GET" action="/elasticsearch/list.do">
		<div class="match_bool">
			<h4>검색하기 :: match_bool(must, must not)</h4>
			<div class="group">
				<label>포함</label> 
				<input type="text" name="word">
			</div>
			<div class="group">
				<label>미포함</label> 
				<input type="text" name="word2">
			</div>
			<input type="submit" value="검색하기">
		</div>

		<input type="hidden" name="type" value="match_bool">
	</form>
	
	
	<form method="GET" action="/elasticsearch/list.do">
		<div class="match_should">
			<h4>검색하기 :: match_bool(should)</h4>
			<div>
				<input type="text" name="word"> 
				<input type="submit" value="검색하기">
			</div>
		</div>
		<input type="hidden" name="type" value="match_should">
	</form>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
	
		<c:if test="${type == 'match_all'}">
			//전체 목록 보기
			
		</c:if>
			
		<c:if test="${type != 'match_all'}">
		
			$('form').hide();
			$('.${type}').parent().show();
		
			//검색 결과
			$('.${type} input[name=word]').val('${word}');
			$('.${type} input[name=slop]').val('${slop}');s
			
		</c:if>
			
	</script>
</body>
</html>