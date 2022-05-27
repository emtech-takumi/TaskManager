<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="logout-servlet" method="POST">
	User ID : <%= session.getAttribute("USER_ID") %>
	<input type="submit" value="ログアウト">
</form>