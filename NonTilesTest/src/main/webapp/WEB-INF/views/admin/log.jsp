<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Example</title>
<%@ include file="/WEB-INF/inc/asset.jsp" %>
<style>

</style>
</head>
<body>
	<!-- admin > log.jsp -->
	<%@ include file="/WEB-INF/inc/main_menu.jsp" %>
	
	<%@ include file="/WEB-INF/inc/admin_menu.jsp" %>
	
	<main>
		<h1>관리자 <small>로그</small></h1>
		<pre style="padding: 1rem;">
INFO : org.springframework.web.servlet.handler.SimpleUrlHandlerMapping - Mapped URL path [/resources/**] onto handler 'org.springframework.web.servlet.resource.ResourceHttpRequestHandler#0'
INFO : org.springframework.web.servlet.DispatcherServlet - FrameworkServlet 'appServlet': initialization completed in 2110 ms
11월 27, 2023 10:10:03 오전 org.apache.catalina.core.StandardContext reload
INFO: 이름이 [/nontiles]인 컨텍스트를 다시 로드하는 것을 완료했습니다.
		</pre>		
	</main>
	
	<script>
		
	</script>
</body>
</html>