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
<h2>タスク一覧</h2>
<form>
	<table>
	<thead>
		<tr>
			<th>タスク名</th>
			<th>カテゴリ情報</th>
			<th>期限</th>
			<th>担当者情報</th>
			<th>ステータス情報</th>
			<th>メモ</th>
		</tr>
	</thead>
	<tbody>
	<%for(TaskBean task : tasks){%>
		<tr>
		 	<%="<td>"+task.getTaskName()+"</td>" %>
		 	<%="<td>"+task.getCategoryName()+"</td>" %>
		 	<%="<td>"+task.getDeadLine()+"</td>" %>
		 	<%="<td>"+task.getUserName()+"</td>" %>
		 	<%="<td>"+task.getStatus()+"</td>" %>
		 	<%="<td>"+task.getMemo()+"</td>" %>
		 	<td>
		 		<input type="button" value="編集" name="edit">
		 		<input type="button" value="削除" name="delete">
		 	</td>
		</tr>
	<%} %>
	</tbody>
</table>
	
</form>
<a href="menu-servlet">メニューに戻る</a>
</body>
</html>