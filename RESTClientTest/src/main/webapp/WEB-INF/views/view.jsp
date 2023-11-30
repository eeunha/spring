<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Address</title>
<%@ include file="/WEB-INF/views/inc/asset.jsp"%>
<style>

</style>
</head>
<body>
	<!-- view.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp"%>
	
	<div class="list full">
		<div>홍길동</div>
		<div>나이</div>
		<div>성별</div>
		<div>주소</div>
	</div>
	
	<div>
		<button type="button" class="del" onclick="del();">삭제하기</button>
		<button type="button" class="list"
			onclick="location.href='/client/list.do';">목록보기</button>
	</div>
	
	<script>
		$.ajax({
			type: 'GET',
			url: 'http://localhost:8090/rest/address/${seq}',
			dataType: 'json',
			success: item => {
				$('.list > div:nth-child(1)').text(item.name);
				$('.list > div:nth-child(2)').text(item.age);
				$('.list > div:nth-child(3)').text(item.gender);
				$('.list > div:nth-child(4)').text(item.address);
			},
			error: (a, b, c) => {
				console.log(a, b, c);
			}
		});
		
		function del() {
			$.ajax({
				type: 'DELETE',
				url: 'http://localhost:8090/rest/address/${seq}',
				dataType: 'json',
				success: result => {
					if (result == 1) {
						location.href = '/client/list.do';
					} else {
						alert('failed');
					}
				},
				error: (a, b, c) => {
					console.log(a, b, c);
				}
			
			});
		}
	</script>
</body>
</html>