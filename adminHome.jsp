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
String admin= (String) session.getAttribute("admin");
if(admin==null){
	response.sendRedirect("index.jsp");
}
out.println("Welcome to Admin Homme Page "+admin);
%>
<br>
<a href="ProductController">View all Products</a>
<a href="storeproduct.jsp">Store Product</a>
<br>
<a href="index.jsp">Logout</a>

</body>
</html>