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
		replyList();
		$('.filename').on('click',function(e){
			e.preventDefault();
			var filename = $(this).attr('href');
			$(location).attr('href','${path}/board/download?filename='+filename);
		});
		$('#bUpdate').on('click',function(){
			var num = $('#num').val();
			$(location).attr('href','${path}/board/update?num='+num);
		});
		$('#bDelete').on('click',function(){
			var num = $('#num').val();
			$(location).attr('href','${path}/board/delete?num='+num);
		});
		$('#bList').on('click',function(){
			$(location).attr('href','${path}/board/list');
		});	
		$('#reInsert').on('click',function(){
			var num = $('#num').val();
			var replyContent = $('#replyContent').val();
			/* $(location).attr('href','${path}/board/list'); = 동시방식 */
			//비동기방식(ajax)
			$.ajax({
				type:'post', //메소드타입
				url:'${path}/reply/', //url
				//JSON.stringify() string -> json 변환
				data:JSON.stringify({'num':num, 'content':replyContent}), //보낼 데이터
				contentType:'application/json;charset=utf-8',
				dataType:'text', //반환받을 데이터형
				success:function(result){ //성공시 실행 할 문장		
					$('#replyContent').val('');
					replyList();
				}
			});
		});
		//댓글삭제
		$(document).on('click','#reDelete',function(){
			var rnum = $(this).attr('title');
			var num = $('#num').val();
			$.ajax({
				type:'delete',
				url:'${path}/reply/',
				data:JSON.stringify({'rnum':rnum, 'num':num}), //보낼 데이터
				contentType:'application/json;charset=utf-8',
				success:function(result){
					alert(result);
					replyList();
				}
			});
		});
		//댓글업데이트
		$(document).on('click','#reUpdate',function(){
			var rnum = $(this).attr('title');
			var replyContent = $(this).prev().prev().val();
			$.ajax({
				type:'put',
				url:'${path}/reply/',
				data:JSON.stringify({'rnum':rnum, 'content':replyContent}), //보낼 데이터
				contentType:'application/json;charset=utf-8',
				success:function(result){
					alert(result);
				}
			});
		});
		//답변글의 리스트를 호출하는 함수
		function replyList() {
			var num = $('#num').val();
			$.ajax({
				type:'get',
				url:'${path}/reply/'+num,
				dataType:'json',
				success:function(data){
					$('#replyList').html('');
					console.log(data);
					//반환받은 데이터 출력
					$(data).each(function(){
						var d = $('<p />').append(this.userid + ' ['+this.regdate+']');
						var c = $('<textarea /><br>').append(this.content);
						$('#replyList').append(d,c);
						$('#replyList').append($('<button id="reUpdate" title="'+this.rnum+'"/>').append('수정'));
						$('#replyList').append($('<button id="reDelete" title="'+this.rnum+'"/>').append('삭제'));
					});
				}
			});
		}
		
	});
</script>
</head> 
<body>
	<div class="container">
		<h2><span class="label label-default">한건조회</span></h2>
		<form class="form-horizontal">
			<div class="form-group">
				<label class="control-label col-sm-2" for="num" >번호</label>
				<div class="col-sm-10">
					<input type="text" id="num" name="num" value="${dto.num}" readonly>
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
						<a class="filename" href="${file.filename}">${file.filename}</a><br>
					</c:forEach>
				</div>
			</div>
		</form>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button id="bUpdate">수정</button>
			<button id="bDelete">삭제</button>
			<button id="bList">목록</button>
		</div>
	</div>
	
	
	<!-- 댓글처리 -->
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<textarea rows="5" cols="50" id="replyContent"></textarea>
			<button id="reInsert" class="btn btn-primary">댓글등록</button>
		</div>
	</div>
	<!-- 댓글목록 -->
	<div class="form-group">
		<div id="replyList" class="col-sm-offset-2 col-sm-10">
		</div>
	</div>
				
</body>
</html>