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
<title>JDBC</title>
</head>
<body>
	<h2>회원 목록 조회 테스트(executeQuery() 사용)</h2>
	<%
	// DB에 연결
	JDBConnect jdbc = new JDBConnect();
	
	// 쿼리문 생성
	String sql = "SELECT id, pass, name, regidate FROM member";
	Statement stmt = jdbc.con.createStatement();
	
	// 쿼리 수행
	ResultSet rs = stmt.executeQuery(sql);
	%>
	<table class="table">	
	<tr>
	<th>id</th><th>pw</th><th>name</th><th>regidate</th>
	</tr>
	<%
	// 결과 확인(웹 페이지에 출력)
	while (rs.next()) {
		String id = rs.getString(1);
		String pw = rs.getString(2);
		String name = rs.getString("name");
		java.sql.Date regidate = rs.getDate("regidate");
	%>
					
		<tr>
		<td><%= id %></td><td><%= pw %></td><td><%= name %></td><td><%= regidate %></td>
		</tr>
	<%
	//out.println(String.format("%s %s %s %s", id, pw, name, regidate) + "<br/>");	
	}
	%>
	</table>
	<%
	// 연결 닫기
	jdbc.close();
	%>	
	
</body>
</html>