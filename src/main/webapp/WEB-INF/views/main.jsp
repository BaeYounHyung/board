<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/include2.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<script type="text/javascript">
	$(function() {
		//목록
		$('#aBoardList').on('click', function(e) {
			if ('${sessionScope.logindto}' ==''){
				alert('로그인을 먼저 하세요!');
				e.preventDefault(); //객체의 기본기능을 소멸
			}else{
				$(this).attr('href', '${path}/board/list');
			}
		});	
		//홈
		$('#aHome').on('click', function(e) {
			$(this).attr('href', '${path}/home');
		});
		//로그인
		$('#btnLogin').on('click', function(e) {
			//아이디/패스워드 체크
			e.preventDefault(); //객체의 기본기능을 소멸
			$('#form').attr('action','${path}/login');
			$('#form').attr('method','post');
			$('#form').submit();
		});
		//로그아웃
		$('#aLogout').on('click', function(e) {
			if('${sessionScope.logindto}' != ''){
			e.preventDefault(); //객체의 기본기능을 소멸
			$(location).attr('href', '${path}/logout');				
			}
		});
		//회원가입
		$('#btnJoin').on('click', function(e) {
			$(this).attr('href','${path}/join');
			$('#myModal').modal('hide');
			
		});
	});



</script>
<style>
  body {
    font: 20px Montserrat, sans-serif;
    line-height: 1.8;
    color: #f5f6f7;
  }
  p {font-size: 16px;}
  .p1{
  	color: black;
  }
  .margin {margin-bottom: 45px;}
  .bg-1 { 
    background-color: #474e5d; 
    color: #ffffff;
  }
  .bg-2 { 
    background-color: #ffffff; /* Dark Blue */
    color: #ffffff;
  }
  .bg-3 { 
    background-color: #2f2f2f; /* White */
    color: #555555;
  }
   .bg-4 { 
    background-color: #2f2f2f; /* Black Gray */
    color: #fff;
  }
  .container-fluid {
    padding-top: 70px;
    padding-bottom: 70px;
  }
  .navbar {
    padding-top: 15px;
    padding-bottom: 15px;
    border: 0;
    border-radius: 0;
    margin-bottom: 0;
    font-size: 12px;
    letter-spacing: 5px;
  }
  .navbar-nav  li a:hover {
    color: #1abc9c !important;
  }
  		iframe {
	border : none;
	width : 100%;
	height : 700px;
	
}
  </style>
</head>
<body>

</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
       <a class="navbar-brand" href="" id="aHome" target="myframe">홈</a>
      <a class="navbar-brand" href="" id="aBoardList" target="myframe">게시판</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#" data-toggle="modal" data-target="#myModal" id="aLogin">로그인</a></li>
        <li><a href="" id="aLogout">로그아웃</a></li>
      </ul>
    </div>
        <!-- Modal -->
	  <div class="modal fade" id="myModal" role="dialog">
	    <div class="modal-dialog modal-sm">
	      <div class="modal-content">
			<div class="modal-header">
		 		<h4 class="modal-title">로그인</h4>
		    </div>
	        <div class="modal-body">	    
				<form id ="form">
				  	<div class="input-group">
				    	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				    	<input id="id" type="text" class="form-control" name="id" placeholder="id">
				  	</div>
				  	<div class="input-group">
				    	<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
				    	<input id="password" type="password" class="form-control" name="password" placeholder="Password">
				  	</div>
				</form>
			</div>
	 		<div class="modal-footer">
	 			<a href=""  class="btn btn-primary" id="btnLogin">로그인</a>
	 			<a href="" class="btn btn-success" id="btnJoin" target="myframe">회원가입</a>
			</div>      
	      </div>
	    </div>
	  </div>
  </div>
</nav>	 
<!-- First Container -->
<iframe name="myframe" src="${path}/home">

</iframe>
<!-- Footer -->
<footer class="container-fluid bg-4 text-center">
  <p class="p1">배윤형의 게시판 <a href="http://www.kjacademy.co.kr/">zxxx056@naver.com</a></p> 
</footer>
</body>
</html>