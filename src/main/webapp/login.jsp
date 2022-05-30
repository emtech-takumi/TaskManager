<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン画面</title>
	<link rel="stylesheet" href="./style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<div id="particles-js">
	
	</div> <!-- ここがcanvasになる -->

  	<!-- particles.js -->
  	<script src="particles.min.js"></script>

  	<!-- ご自身のパスに変更 -->
  	<script src="main.js"></script>
  	<div class="login">
  		<form action="login-servlet" method="post">
		<div class = container>
        <br>
        <font size=5 face="Segoe UI">タスク管理システム</font>
        <br>
        <h2>ログイン</h2>
        <%if(request.getAttribute("ERROR") != null){%>
        <font color="red">
        	<%= (String)request.getAttribute("ERROR") %>
        </font>
        <%} %>
        <div class = col-6>
            <div class="form-floating mb-3">
                <input type="text" name="user_id" class="form-control" id="floatingInput" placeholder="User ID">
                <label for="floatingInput">User ID</label>
            </div>
            <div class="form-floating">
                <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password">
                <label for="floatingPassword">Password</label>
            </div>
            <br>
            <button type="submit" class="btn btn-secondary">ログイン</button>
        	</div>
        </div>
	</form>
  	</div>
</body>
</html>