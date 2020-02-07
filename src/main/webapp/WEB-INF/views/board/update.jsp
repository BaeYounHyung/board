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
		$('#bUpdate').on('click',function(e){
			e.preventDefault();
			$('#form1').attr('action','${path}/board/update');
			$('#form1').attr('method','post');
			$('#form1').attr('enctype','multipart/form-data');
			$('#form1').submit();
		});
		$('#bList').on('click',function(e){
			e.preventDefault();
			$(location).attr('href','${path}/board/list');
		});
		
	});
</script>
</head>
<body>
<div class="container">
<h2><span class="label label-default">수정</span></h2>
	<form id="form1" class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-sm-2" for="num" >번호</label>
			<div class="col-sm-10">
				<input type="text" name="num" value="${dto.num}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">이메일</label>
			<div class="col-sm-10">
				<input type="email" name="email" value="${dto.email}">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="subject">제목</label>
			<div class="col-sm-10">
				<input type="text" name="subject" value="${dto.subject}">
			</div>
		</div>
		<div class="form-group">
		  	<label class="control-label col-sm-2" for="content" >내용</label>
			<div class="col-sm-10">
				<textarea rows="5" name="content">${dto.content}</textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="readcount" >조회수</label>
			<div class="col-sm-10">
				<input type="text" name="readcount" value="${dto.readcount}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="regdate" >등록일자</label>
			<div class="col-sm-10">
				<input type="date" name="regdate" value="${dto.regdate}" readonly> 
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">첨부파일</label>
			<div class="col-sm-10">
				<c:forEach items="${list}" var="file">
					<a class="afile" >${file.filename}</a><br>
					<input type="hidden" name="fnum" value="${file.fnum }">
				</c:forEach>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">파일</label>
			<div class="col-sm-10">	
   				<input multiple="multiple" type="file" name="file">
   			</div>
   		</div>
   		<div class="form-group">
   			<div class="col-sm-offset-2 col-sm-10">
				<button id="bUpdate" class="btn btn-success">수정</button>
				<button id="bList" class="btn btn-info">목록</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>