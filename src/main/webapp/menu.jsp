<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>メニュー</title>
	<link rel="stylesheet" href="./style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<%
	if(session.getAttribute("USER_ID") == null){
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	%>
	<div id="particles-js">
	
	</div> <!-- ここがcanvasになる -->

  	<!-- particles.js -->
  	<script src="particles.min.js"></script>

  	<!-- ご自身のパスに変更 -->
  	<script src="main.js"></script>
	<div class="container content">
		<jsp:include page="header.jsp"></jsp:include>
		<h2 style="padding: 1rem 2rem;border-left: 5px solid #000;nd: #F4F4F4;">メニュー</h2>
		<br><br>
		<form action="task-registration-servlet" method="post">
			<div>
				<button type="submit" class="btn btn-secondary" name="register">タスク登録</button> <br>
				タスクを登録します。
			</div>
		</form>
		<br><br><br><br>
		<form action="task-list-servlet" method="post">
			<div>
				<button type="submit" class="btn btn-secondary"  name="showlist">タスク一覧</button> <br>
				登録されているタスクの一覧を表示します。
				また、タスクの編集や削除などを行えます。
			</div>
		</form>
	</div>
</body>
</html>