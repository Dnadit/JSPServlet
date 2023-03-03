<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<meta charset="UTF-8">
<title>CountUseEng</title>
</head>
<body>
	<h2>영어를 사용하고 있는 나라의 수</h2>
	<%
	JDBConnect jdbc = new JDBConnect(application);
	
	String sql = "select count(*) as '영어를 사용하고 있는 나라의 수' from countrylanguage where language = 'English'";
	Statement stmt = jdbc.con.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	%>
	<table class="table">	
	<thead>
	<tr>
	<th>count</th>
	</tr>
	</thead>	
	<%
	while (rs.next()) {
		String count = rs.getString(1);			
	%>
	<tr>
	<td><%= count %></td>
	</tr>
	<%
	}
	
	jdbc.close();	
	%>
	</table>
</body>
</html>