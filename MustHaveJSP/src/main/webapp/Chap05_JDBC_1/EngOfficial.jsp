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
	<h2>영어를 공식언어로 사용하고 있는 나라</h2>
	<%
	JDBConnect jdbc = new JDBConnect(application);
	
	String sql = ("select Region, Name "
			+ "from countrylanguage, country "
			+ "where countrylanguage.CountryCode=country.Code && language ='English' && isOfficial ='T'");
	Statement stmt = jdbc.con.createStatement();
	
	ResultSet rs = stmt.executeQuery(sql);
	%>
	<table class="table">	
	<thead>
	<tr>
	<th>대륙</th><th>나라</th>
	</tr>
	</thead>	
	<%
	while (rs.next()) {
		String region = rs.getString(1);
		String name = rs.getString(2);
	%>
	<tr>
	<td><%= region %></td><td><%= name %></td>
	</tr>
	<%
	}
	
	jdbc.close();	
	%>
	</table>
</body>
</html>