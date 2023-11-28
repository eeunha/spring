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
#attach-zone {
	border: 1px solid #CCC;
	boarder-radius: 3px;
	background-color: #EFEFEF;
	width: 575px;
	height: 150px;
	overflow: auto;
	background-color: #EFEFEF;
	padding: .5rem;
}

#attach-zone .item {
	display: flex;
	justify-content: space-between;;
	font-size: 14px;
	margin: 5px 10px;
}

input[name=attach] {
	display: none;
}
</style>
</head>
<body>
	<!-- add.jsp -->
	<h1>
		장소 <small>등록하기</small>
	</h1>

	<form method="POST" action="/file/multi/addok.do"
		enctype="multipart/form-data">
		<table class="vertical">
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" required class="full"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" required class="full"></textarea></td>
			</tr>
			<!-- 			<tr>
				<th>파일</th>
				<td><input type="file" name="attach" multiple></td>
			</tr> -->
			<tr>
				<th>파일</th>
				<td><input type="file" name="attach" multiple>
					<div id="attach-zone"></div></td>
			</tr>
		</table>
		<div>
			<button type="button" class="back"
				onclick="location.href='/file/multi/list.do';">돌아가기</button>
			<button type="submit" class="add">등록하기</button>
		</div>
	</form>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>
		$('#attach-zone').on('dragenter', function(e) {
			e.preventDefault();
			e.stopPropagation();
		}).on("dragover", function(e) {
			e.preventDefault();
			e.stopPropagation();
		}).on('dragleave', function(e) {
			e.preventDefault();
			e.stopPropagation();
		}).on('drop', function(e) { //파일 드래그 앤 드랍 시
			e.preventDefault();
			e.stopPropagation();

			const files = e.originalEvent.dataTransfer.files;

			$(this).html('');
			
			if (files != null && files != undefined) {
				let temp = '';

				for (let i = 0; i < files.length; i++) {
					//console.log(files[i].name);
					
					let filename = files[i].name;
					let filesize = files[i].size /1024/1024; //MB
					
					filesize = filesize < 1 ? filesize.toFixed(2) : filesize.toFixed(2);
					
					temp += `
						<div class="item">
							<span>\${filename}</span>
							<span>\${filesize}MB</span>
						</div>
					`;
				}

				$(this).append(temp);
				
				$('input[name=attach]').prop('files', files);
			} 
		});
	</script>
</body>
</html>