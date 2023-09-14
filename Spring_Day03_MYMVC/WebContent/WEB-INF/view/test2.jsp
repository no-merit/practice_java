<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>test2</h2>
	1. ${pageScope.msg }<br>
	2. ${requestScope.msg }<br>
	3. ${sessionScope.msg }<br>
	4. ${applicationScope.msg }<br>
	5. ${msg }<br>
</body>
</html>