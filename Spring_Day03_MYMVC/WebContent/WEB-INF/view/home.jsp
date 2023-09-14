<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈</h1>
	${msg }
	
	<form action="test4" method="POST">
		아이디 : <input type ="text" name="id">
		비번 : <input type ="password" name="pwd">
		나이 : <input type ="number" name="age">
		<button>등록</button>
	</form>
</body>
</html>