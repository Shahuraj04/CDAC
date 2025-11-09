<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tester</title>
</head>
<body>
	<h5>Servertime: ${requestScope.serverTS}</h5>
	<h5>
		<a href="department/list">List All Departments</a>
		<%-- HTTP://HOST:PORT/CTX_PATH/department/list --%>
	</h5>

</body>
</html>