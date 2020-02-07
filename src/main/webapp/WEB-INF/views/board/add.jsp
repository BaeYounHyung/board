<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../include/include.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function () {
		$('#bInsert').on('click',function(e){
			e.preventDefault();
			$('#form1').attr('action','${path}/board/insert');
			$('#form1').attr('method','post');
			$('#form1').attr('enctype','multipart/form-data');
			$('#form1').submit();
		});
		$('#btnList').on('click', function(e) {
			e.preventDefault(); //객체의 기본기능을 소멸						
			$(location).attr('href', '${path}/board/list');
		});
		$('#back').on('click',function(e){
			e.preventDefault();
			$(location).attr('href','${path}/board/list');
		});
	});
</script>
</head>
<body>
<div class="container">
	<h2><span class="label label-default">게시물 추가</span></h2>
	<form id="form1">
		<div class="form-group">
			<label class="control-label col-sm-2">제목</label>
			<div class="col-sm-10">
				<input type="text" name="subject"> <br>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" >아이디</label>
			<div class="col-sm-10">
				<input type="text"  name="userid" value="${sessionScope.logindto.id}" readonly>
			</div>
		</div>
		<div class="form-group">		
			<label class="control-label col-sm-2">이메일</label>
			<div class="col-sm-10">
				<input type="email" name="email" >
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">내용</label>
			<div class="col-sm-10">
				<textarea name="content"></textarea>  <br>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">파일</label>
			<div class="col-sm-10">			
				<input multiple="multiple" type="file" name="file"><br>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">	
				<button type="button" id="bInsert" class="btn btn-success">확인</button>
				<input type="reset" value="취소" class="btn btn-warning">
				<button id="btnList" class="btn btn-info">목록</button>
			</div>	
		</div>
	</form>
</div>
</body>
</html>