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
table th {
	width: 150px;
}

table tr:nth-child(1) td:nth-child(12) {
	width: 150px;
}

table tr:nth-child(3) td {
	height: 100px;
}

table tr:nth-child(4) img {
	display: block;
	border: 1px solid #CCC;
	border-radius: 3px;
	padding: 5px;
	margin: 15px auto;
	max-width: 700px;
}

#map {
	width: 700px;
	height: 500px;
	margin: 15px auto;
	border: 1px solid #CCC;
	border-radius: 3px;
}
</style>
</head>
<body>
	<!-- view.jsp -->
	<h1>
		장소 <small>상세보기</small>
	</h1>

	<table>
		<tr>
			<th>번호</th>
			<td>${dto.seq}</td>
			<th>날짜</th>
			<td>${dto.regdate}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${dto.subject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><c:out value="${dto.content}" /></td>
		</tr>
		<tr>
			<td colspan="4"><c:forEach items="${dto.picList}" var="pdto">
					<img src="/file/resources/files/${pdto.filename}">
				</c:forEach></td>
		</tr>
		<c:if test="${not empty lat}">
		<tr>
			<td colspan="4">
				<div id="map"></div>
			</td>
		</tr>
		</c:if>
	</table>
	<div>
		<button type="button" class="back"
			onclick="location.href='/file/multi/list.do';">돌아가기</button>
	</div>

	<!-- 지도api -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=791cfd7b7418b2b7b60ed25fffbcec27"></script>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
	
	<c:if test="${not empty lat}">
		const container = document.getElementById('map');

		const options = {
			center: new kakao.maps.LatLng(${lat}, ${lng}),
			level: 3
		}

		const map = new kakao.maps.Map(container, options);
		
		const marker = new kakao.maps.Marker({
			position: new kakao.maps.LatLng(${lat}, ${lng})
		});
		
		marker.setMap(map);
	</c:if>
	
	</script>
</body>
</html>