<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 파일 호출</title>
</head>
<body>
	<form action="gugudanMain.jsp" method="get">
		<input type="radio" name="sel" value="dan" />Type1<br>
		<input type="radio" name="sel" value="col" />Type2<br>
		<input type="text" name="num" />단수/열수<br>
		<input type="submit" value="선택" />
	</form>
</body>
</html>