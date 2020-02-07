<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/include2.jsp" %> 
<html>
<head>
	<style type="text/css">
		/* .in {
		 	width:300px;
		    height:300px;
		    position:absolute;
		    left:50%;
		    top:50%;
		    margin-left:-150px;
		    margin-top:-150px;
		 }
		div{
			box-sizing: border-box;
			float: left;

		} */

		
	</style>
</head>
<body>
	<%-- <div  class="in">
	<form action="${path}/login" method="post" >
		<div class="input-group">
	    	<span class="input-group-addon"><i class="glyphicon glyphicon-user" ></i></span>
	    	<input id="id" type="text" class="form-control" name="id" placeholder="id" value="${sessionScope.userid}" style="width: 250px;">
	  	</div>
	  	<div class="input-group">
	    	<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	    	<input id="password" type="password" class="form-control" name="password" placeholder="Password"style="width: 250px;">
	  	</div>
	  	<div>
		<input class="btn btn-primary" type="submit" value="로그인">
		<input class="btn btn-success" type="button" value="회원가입" onclick="location.href='${path}/join'" >
		</div>
	</form>
	</div> --%>
	<div class="container-fluid bg-1 text-center">
	  <h3 class="margin">WELCOME BOARD</h3>
	  <img src="${path}/resources/img/cat.jpg" class="img-responsive img-circle margin" style="display:inline" alt="Bird" width="350" height="350">
	  <h3>나의 게시판 메인</h3>
	</div>	
</body>
</html>
