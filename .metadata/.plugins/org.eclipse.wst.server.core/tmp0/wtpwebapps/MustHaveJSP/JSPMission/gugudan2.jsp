<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력 col</title>
</head>
<body>
	<%
	if (request.getParameter("col") != null) {
	%>
	<h1>구구단 <%= request.getParameter("col")%>개</h1>
	<%
		for (int i=2; i<Integer.parseInt(request.getParameter("col"))+1; i++) {
			for (int j=1; j<10; j++) {
	%>
				<%= i %> * <%= j %> = <%= i * j %> <br/>
	<%
			}
		}
	} else {
	%>
	<h4>주소창 맨뒤에 ?col=보고싶은 구구단 갯수</h4>
	<%
	}
	%>
</body>
</html>