<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Example</title>
<%-- <%@ include file="/WEB-INF/inc/asset.jsp" %> --%> <!-- 사용할 순 있으나 files 쓸거니까 쓰지말자. -->
<tiles:insertAttribute name="asset" />
<style>

</style>
</head>
<body>
	<!-- index.jsp -->
	<tiles:insertAttribute name="main_menu" />
	
	<main>
		<h1>시작 페이지</h1>
	</main>
	
	
	<script>
		
	</script>
</body>
</html>