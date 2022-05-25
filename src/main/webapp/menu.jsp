<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>
	<h2>メニュー</h2>
	<form action="formRegisterServlet" method="post">
	<input type="submit" value="タスク登録" name="register">
	<br>
	</form>
	<form action="formTaskListServlet" method="post">
	<input type="submit" value="タスク一覧" name="showlist">
	<br>
	</form>
	<form action="formLogoutServlet" method="post">
	<input type="submit" value="ログアウト" name="post">
	</form>
	
</body>
</html>