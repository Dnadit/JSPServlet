<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String sel = request.getParameter("sel");
String num = request.getParameter("num");

if(sel.equals("dan")) {	
	response.sendRedirect("gugudan1.jsp?" + sel + "=" + num);
} else if(sel.equals("col")) {
	response.sendRedirect("gugudan2.jsp?" + sel + "=" + num);
} else {
	out.println("error");
}
%>