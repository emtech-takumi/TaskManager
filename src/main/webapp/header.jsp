<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<%
	if(session.getAttribute("USER_ID") == null){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
%>
<div style="text-align : right; padding : 20px; border-bottom:1px solid gray;">
	<a href="menu-servlet" style="float: left; display:inline;">
		<img src="team_logo.png" width=80>
	</a>
	<form action="logout-servlet" method="POST" style="display:inline">
		User ID : <%= session.getAttribute("USER_ID") %>
		<button type="submit" class="btn btn-secondary">ログアウト</button>
	</form>
	<br>
</div>
