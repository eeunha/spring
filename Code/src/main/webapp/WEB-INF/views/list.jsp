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
#main {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
}

.item {
	border: 1px solid #AAA;
	width: 240px;
	margin: 5px;
	cursor: pointer;
}

.item>div:nth-child(1) {
	padding: .5rem;
}

.item>div:nth-child(2) {
	min-height: 150px;
	display: flex;
	justify-content: center;
	align-items: center;
	border-top: 1px solid #AAA;
	border-bottom: 1px solid #AAA;
}

.item>div:nth-child(3) {
	padding: .5rem;
	text-align: right;
}

#filter {
	text-align: right;
	padding-right: 2rem;
}

#filter input {
	background-color: #FFF;
}
</style>
</head>
<body>
	<!-- list.jsp -->
	<h1>
		Code <small>list</small>
	</h1>

	<div id="filter">
		<input type="button" value="Java" data-language="java"
			data-selected="0" data-color="cornflowerblue"> <input
			type="button" value="SQL" data-language="sql" data-selected="0"
			data-color="tomato"> <input type="button" value="HTML"
			data-language="html" data-selected="0" data-color="gold"> <input
			type="button" value="CSS" data-language="css" data-selected="0"
			data-color="yellowgreen"> <input type="button"
			value="JavaScript" data-language="js" data-selected="0"
			data-color="orange">
	</div>

	<div id="main">
		<c:forEach items="${list}" var="dto">
			<div class="item"
				onclick="location.href='/code/view.do?seq=${dto.seq}';">
				<c:choose>
					<c:when test="${dto.language == 'java'}">
						<c:set var="color" value="cornflowerblue" />
					</c:when>
					<c:when test="${dto.language == 'sql'}">
						<c:set var="color" value="tomato" />
					</c:when>
					<c:when test="${dto.language == 'html'}">
						<c:set var="color" value="gold" />
					</c:when>
					<c:when test="${dto.language == 'css'}">
						<c:set var="color" value="yellowgreen" />
					</c:when>
					<c:when test="${dto.language == 'js'}">
						<c:set var="color" value="orange" />
					</c:when>
					<c:otherwise>
						<c:set var="color" value="white" />
					</c:otherwise>
				</c:choose>

				<div style="background-color: ${color};">${dto.language}</div>
				<div>${dto.subject}</div>
				<div>${dto.regdate}</div>
			</div>
		</c:forEach>
	</div>
	<div>
		<button type="button" class="add"
			onclick="location.href='/code/add.do';">추가하기</button>
	</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		$('#filter > input').click(function() { //버튼 색 지정

			let param = '';

			if ($(this).data('selected') == 0) {
				//선택이 안된 경우				
				$(this).css('background-color', $(this).data('color'));
				$(this).data('selected', '1');
			} else {
				$(this).css('background-color', $(this).data('#FFF'));
				$(this).data('selected', '0');
			}

			$('#filter > input').each(function(index, item) {
				if ($(item).data('selected') == '1') { // 선택된 애들
					//alert($(item).data('language'));
					param += 'language=' + $(item).data('language') + '&';
				}
			});

			//alert(param);
			location.href = '/code/list.do?' + param;

		});
		
		<c:forEach items="${language}" var="lang">
			$('#filter input[data-language=${lang}]').data('selected', '1');
			$('#filter input[data-language=${lang}]').css('background-color', $('#filter input[data-language=${lang}]').data('color'));
		</c:forEach>
	</script>
</body>
</html>