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
	String col1 = request.getParameter("col");
	int col = Integer.parseInt(col1);

	%>
	<h1>구구단 <%= col %>개</h1>
	<%		
		for (int i=2; i<10; i++) {
			for (int j=1; j<10; j++) {
				for (int k=0; k<col; k++) {
					if(i+k > 9)
						break;					
	%>
				<%= i+k %> * <%= j %> = <%= (i+k) * j %> 
	<%	
				}
	%>	
				<br>
	<%			
			}			
		}
	%> 
	
	
</body>
</html>