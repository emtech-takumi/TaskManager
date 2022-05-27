<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h2>メニュー</h2>
	<form action="task-registration-servlet" method="post">
	<input type="submit" value="タスク登録" name="register">
	<br>
	</form>
	<form action="task-list-servlet" method="post">
	<input type="submit" value="タスク一覧" name="showlist">
	<br>
	</form>
	<form action="logout-servlet" method="post">
	<input type="submit" value="ログアウト" name="post">
	</form>
	
</body>
</html>