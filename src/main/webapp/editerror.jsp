<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集エラー</title>
</head>
<body>
	編集に失敗しました<br>
	<div style="color: red;"><%=request.getAttribute("errorMessage")%><br></div>
	従業員情報編集画面に<a href="menu-servlet">戻る</a>
</body>
</html>