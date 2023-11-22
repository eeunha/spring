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
	<!-- ex05.jsp -->
	<h1>데이터 전송 <small>단일값</small></h1>
	
	<form method="POST" action="/spring/ex05ok.do">
		
		<div><input type="text" name="data"></div>
		<div><input type="submit" value="보내기"></div>
		
	</form>
	
	
	<h1>데이터 전송 <small>복합값</small></h1>
	
	<form method="POST" action="/spring/ex05ok.do">
		<div>이름: <input type="text" name="name"></div>
		<div>나이: <input type="text" name="age"></div>
		<div>주소: <input type="text" name="address"></div>
		<div><input type="submit" value="보내기"></div>
		
		<input type="hidden" name="seq" value="5">
	</form>
	
	
	<h1>데이터 전송 <small>다중값</small></h1>
	
	<form method="POST" action="/spring/ex05ok.do"> <!-- 동일한 name -> 배열로 받을 수 있다. -->
		<div><input type="checkbox" name="cb" value="red"> 빨강</div>
		<div><input type="checkbox" name="cb" value="blue"> 파랑</div>
		<div><input type="checkbox" name="cb" value="yellow"> 노랑</div>
		<div><input type="checkbox" name="cb" value="black"> 검정</div>
		<div><input type="checkbox" name="cb" value="green"> 초록</div>
		<div><input type="submit" value="보내기"></div>
	</form>
	
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		
	</script>
</body>
</html>