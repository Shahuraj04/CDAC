<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--import JSTL supplied core tag library --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Login Form</title>
</head>
<body>
	<c:if test="${not empty err_mesg}">
		<h5 style="color: red;" align="center">${err_mesg}</h5>
	</c:if>
	<c:if test="${not empty param.message}">
		<h5 style="color: red;" align="center">${message}</h5>
	</c:if>
	<form action="authenticate" method="post">
	<input type="hidden" name="login" value="doctor">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter Doctor Email</td>
				<td><input type="text" name="doc_em" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="doc_pass" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>