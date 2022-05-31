<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録エラー</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
	<br>
	登録に失敗しました。<br>
	<div style="color: red;"><%=request.getAttribute("errorMessage")%><br></div>
	<%
	if(session.getAttribute("USER_ID") == null){
	%>
	タスク登録画面に<a href="login.jsp">戻る</a>
	<%
	}else{
	%>
	タスク登録画面に<a href="#" onclick="history.back(-1);return false;">戻る</a>
	<%
	}
	%>
</div>
</body>
</html>