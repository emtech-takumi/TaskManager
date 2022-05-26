<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク削除確認画面</title>
</head>
<body>
        <h2>削除確認画面</h2>
        以下の情報を削除してもよろしいですか？    
        <table>
       	<% TaskBean task = (TaskBean) session.getAttribute("TASK");  %>
       		<tr>
                <td>タスク名</td>
                <td><%=task.getTaskName() %>/td>
            </tr>
            <tr>
                <td>カテゴリ情報</td>
                <td><%=task.getCategoryId() %></td>
            </tr>
            <tr>
                <td>期限</td>
                <td><%=task.getDeadLine() %></td>
            </tr>
            <tr>
                <td>担当者名</td>
                <td><%=task.getUserName() %></td>
            </tr>
            <tr>
                <td>ステータス情報</td>
                <td><%=task.getStatus() %></td>
            </tr>
            <tr>
                <td>メモ</td>
                <td></td>
            </tr>
        </table>
        <form action="TaskDeleteServlet" method=post>
        <input type="button" value="削除する">
        </form>
        <form action="TaskListServlet" method=post>
        <input type="button" value="キャンセル">
    	</form>
</body>
</html>