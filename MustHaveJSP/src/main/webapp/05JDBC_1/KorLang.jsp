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
<title>QueryTable</title>
</head>
<body>
	<h2>대한민국이 사용하고 있는 언어</h2>
	<%
	JDBConnect jdbc = new JDBConnect(application);
	
	String sql = "select CountryCode, language from countrylanguage where CountryCode = 'KOR'";
	Statement stmt = jdbc.con.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	%>
	<table class="table">	
	<thead>
	<tr>
	<th>국가 코드</th><th>언어</th>
	</tr>
	</thead>	
	<%
	while (rs.next()) {
		String code = rs.getString(1);
		String language = rs.getString(2);
	%>
	<tr>
	<td><%= code %></td><td><%= language %></td>
	</tr>
	<%
	}
	
	jdbc.close();	
	%>
	</table>
</body>
</html>