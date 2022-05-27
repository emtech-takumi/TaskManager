<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,Model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧表示画面</title>
</head>
<body>
	<%
	List<TaskBean> tasks = (List) session.getAttribute("TASK_LIST");
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<h2>タスク一覧</h2>
	<form action="redirect-servlet" method="POST">
		<table border="1">
			<thead>
				<tr>
					<th>check</th>
					<th>タスク名</th>
					<th>カテゴリ情報</th>
					<th>期限</th>
					<th>担当者情報</th>
					<th>ステータス情報</th>
					<th>メモ</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (TaskBean task : tasks) {
				%>
				<tr>
					<td><input type="checkbox" name="task_id"
						value="<%=task.getTaskId()%>"></td>
					<%="<td>" + task.getTaskName() + "</td>"%>
					<%="<td>" + task.getCategoryName() + "</td>"%>
					<%="<td>" + task.getDeadLine() + "</td>"%>
					<%="<td>" + task.getUserName() + "</td>"%>
					<%="<td>" + task.getStatus() + "</td>"%>
					<%="<td>" + task.getMemo() + "</td>"%>
					<td><input type="submit" value="編集"
						name="<%=task.getTaskId()%>"></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<input type="submit" value="削除" name="delete">
	</form>
	<a href="menu-servlet">メニューに戻る</a>
</body>
</html>