<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
	<%
	int dan = Integer.parseInt(request.getParameter("dan"));
	%>
	<h1>구구단 <%= dan %>단</h1>
	<%
	for (int i=1; i<10; i++) {
	%>	
		<%= dan %> * <%= i %> = <%= dan * i %> <br>
	<%
	}
	%>
</body>
</html>