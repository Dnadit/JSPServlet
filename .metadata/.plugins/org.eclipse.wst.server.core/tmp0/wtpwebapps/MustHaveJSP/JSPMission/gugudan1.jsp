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
	if (request.getParameter("dan") != null) {
	%>
	<h1>구구단 <%= request.getParameter("dan")%>단</h1>
	<%
		for (int i=Integer.parseInt(request.getParameter("dan")); i<Integer.parseInt(request.getParameter("dan"))+1; i++) {
			for (int j=1; j<10; j++) {
	%>
				<%= i %> * <%= j %> = <%= i * j %><br/>
	<%
			}
		}
	} else {
	%>
	<h4>주소창 맨뒤에 ?dan=보고싶은 구구단 단 수</h4>
	<%
	}
	%>
</body>
</html>