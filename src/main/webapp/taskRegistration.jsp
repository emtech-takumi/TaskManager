<%@page import="Model.entity.CategoryBean"%>
<%@page import="Model.entity.StatusBean"%>
<%@page import="Model.entity.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク登録画面</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	List<CategoryBean> categoryList = (List<CategoryBean>)request.getAttribute("CATEGORY_LIST");
	List<StatusBean> statusList = (List<StatusBean>)request.getAttribute("STATUS_LIST");
	List<UserBean> userList = (List<UserBean>)request.getAttribute("USER_LIST");	
%>
	<h2>タスク登録</h2>
	<form action="task-registration-request" method="post">
		<table>
			<tr><th>タスク名</th><td><input type="text"></td></tr>
			<tr><th>カテゴリ</th>
			<td>
				<select>
					
				</select>
			</td></tr>
			<tr><th>期限</th>
			<td><input type="date"></td></tr>
			<tr><th>担当者</th>
			<td><select>
			<%
			for(UserBean user : userList){
			%>
				<option value="<%=user.getUserId()%>"><%=user.getUserName()%></option>
			<%
			}
			%>
			</select></td></tr>
			<tr><th>ステータス</th><td>
			<select>
			<option>未着手</option>
			</select>
			</td></tr>
			<tr><th>メモ</th><td><textarea rows="3" cols="50"></textarea></td></tr>
		</table>
		<input type="submit" value="登録" style="text-align: right;">
	</form>
</body>
</html>