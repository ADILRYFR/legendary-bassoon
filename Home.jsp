<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String user = (String)session.getAttribute("user");
out.println("Welcome to the Home Page ");%>
<br>
<%
out.println("Mr./Ms."+user);
%>



</body>
</html>