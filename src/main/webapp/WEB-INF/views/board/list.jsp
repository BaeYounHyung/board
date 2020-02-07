<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../include/include.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(function () {
		$('#bList').on('click',function () {
			var searchKey = $('#searchKey').val();
			var search = $('#search').val();
			$(location).attr('href','${path}/board/list?searchKey='+searchKey+'&searchValue='+search+'&curPage=1');
			
		});
		$('#bInsert').on('click',function () {
			$(location).attr('href','${path}/board/insert');
			
		});
		$('#bLogout').on('click',function () {
			$(location).attr('href','${path}/logout');
			
		});
		$('.subject').on('click',function(e){
			e.preventDefault();
			var num = $(this).attr('href');
			$(location).attr('href','${path}/board/selectOne?num='+num);
		}); 
		//페이지를 클릭했을때
		$('.Page').on('click', function(e) {
			e.preventDefault(); //객체의 기본기능 소멸
			var curPage = $(this).attr("href"); //현재 선택 페이지
			$(location).attr('href', '${path}/board/list?curPage=' + curPage);
		});
	});	
</script>
</head>
<body> 
<div class="container">
<h2><span class="label label-default">게시판 목록</span></h2>
	<div id='dsearch'>
		<select id="searchKey">
			<!-- c:out : 출력, System.out.println 메서드와 비슷한 역할
				 selected : 선택고정 -->
			<option value="" <c:out value="${pdto.searchKey==''?'selected':''}" />></option>
			<option value="userid" <c:out value="${pdto.searchKey=='userid'?'selected':''}" />>아이디</option>
			<option value="subject" <c:out value="${pdto.searchKey=='subject'?'selected':''}" />>제목</option>
			<option value="content" <c:out value="${pdto.searchKey=='content'?'selected':''}" />>내용</option>
			<option value="subcon" <c:out value="${pdto.searchKey=='subcon'?'selected':''}" />>제목+내용</option>
		</select>
	<div class="input-group">
		<input type="text" id="search"  value="${pdto.searchValue}"class="form-control" placeholder="Search" >
		 <div class="input-group-btn">
			<button id="bList"class="btn btn-success"><i class="glyphicon glyphicon-search"></i></button>
		</div>
	</div>
		<button id="bInsert"class="btn btn-success">등록</button>
	</div>
	<c:if test="${list!=null}">
	<table class="table table-striped">
		<tr>
			<th>순번</th>
			<th>아이디</th>
			<th>이메일</th>
			<th>제목</th>
			<th>조회수</th>
			<th>댓글수</th>
			<th>등록일자</th>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.num}</td>
				<td>${dto.userid}</td>
				<td>${dto.email}</td>
				<td><a class="subject" href="${dto.num}">${dto.subject}</a></td>
				<td>${dto.readcount}</td>
				<td>${dto.replycount}</td>
				<td><fmt:formatDate value="${dto.regdate}" pattern="YYYY-MM-dd"/></td>
			</tr>
		</c:forEach>
	</table><br>
	<!-- 네비게이션 -->
		<ul class="pagination">
		<c:if test="${pdto.startPage != 1}">
			<li><a class="Page" href="${pdto.startPage-1}">이전</a></li>			
		</c:if>
		<c:forEach var="i" begin="${pdto.startPage}" end="${pdto.endPage}" step="1">
			<c:if test="${pdto.curPage==i}">
				<li class="disabled"><a class="Page" href="${i}">${i}</a></li>
			</c:if>
			<c:if test="${pdto.curPage!=i}">
				<li><a class="Page" href="${i}">${i}</a></li>
			</c:if>			
		</c:forEach>
		<c:if test="${pdto.endPage != pdto.totPage }">
			<li><a class="Page" href="${pdto.endPage+1}">다음</a></li>	
		</c:if>
		</ul>
	</c:if>
</div>
</body>
</html>