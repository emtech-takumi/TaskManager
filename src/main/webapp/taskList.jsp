<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,Model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧表示画面</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="./bootstable.min.js"></script>
</head>
<body>
	<%
	List<TaskBean> tasks = (List) session.getAttribute("TASK_LIST");
	%>
	<div class="container">
		<jsp:include page="header.jsp"></jsp:include>
		<h2>タスク一覧</h2>
		<form action="redirect-servlet" method="POST">
		<div class="table-content">
			<table class="table table-borded table-responsive table-striped" id="table-list">
				<thead class="table-dark">
					<tr>
						<th></th>
						<th>タスク名</th>
						<th>カテゴリ情報</th>
						<th>期限</th>
						<th>担当者情報</th>
						<th>ステータス情報</th>
						<th>メモ</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
					for (TaskBean task : tasks) {
					%>
					<tr>
						<td><input class="form-check-input" type="checkbox" name="task_id"
							value="<%=task.getTaskId()%>"></td>
						<%="<td>" + task.getTaskName() + "</td>"%>
						<%="<td>" + task.getCategoryName() + "</td>"%>
						<%="<td>" + (task.getDeadLine()==null ? "" : task.getDeadLine()) + "</td>"%>
						<%="<td>" + task.getUserName() + "</td>"%>
						<%="<td>" + task.getStatus() + "</td>"%>
						<%="<td>" + task.getMemo() + "</td>"%>
						<td>
							<button type="submit" name="<%=task.getTaskId()%>" class="btn btn-outline-secondary">編集</button>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
			<button type="submit" name="delete" class="btn btn-outline-secondary">削除</button>
		</form>
		<a href="menu-servlet">メニューに戻る</a>
	</div>
</body>
</html>