<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録エラー</title>
</head>
<body>
	登録に失敗しました。<br>
	<div style="color: red;"><%=request.getAttribute("errorMessage")%><br></div>
	従業員情報登録画面に<a href="task-registration-servlet">戻る</a>
</body>
</html>