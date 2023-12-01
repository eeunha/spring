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
</style>
</head>
<body>
	<!-- index.jsp -->
	<h1>
		WebSocket <small>chat</small>
	</h1>

	<div>
		<div class="group">
			<label>대화명</label> <input type="text" name="name" id="name"
				class="short">
		</div>
	</div>

	<div>
		<button type="button" class="in">들어가기</button>
		<button type="button" class="in" data-name="강아지">들어가기(강아지)</button>
		<button type="button" class="in" data-name="고양이">들어가기(고양이)</button>
		<button type="button" class="in" data-name="호랑이">들어가기(호랑이)</button>
		<button type="button" class="in" data-name="거북이">들어가기(거북이)</button>
		<button type="button" class="in" data-name="망아지">들어가기(망아지)</button>
		<button type="button" class="in" data-name="송아지">들어가기(송아지)</button>
	</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		$('.in').click(
				function() {

					let name = $('#name').val();

					if ($(event.target).data('name') != null
							&& $(event.target).data('name') != '') {
						name = $(event.target).data('name');
					}

					let child = window.open('/socket/chat.do', 'chat',
							'width=404 height=510');

					//child.connect(name);

					child.addEventListener('load', function() {
						//자식창 다 뜨고나면 발생
						child.connect(name);
					});

					$('.in').css('opacity', .5).prop('disabled', true);
					$('#name').prop('readOnly', true);

				});
	</script>
</body>
</html>