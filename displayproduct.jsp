<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>PId</th>
<th>PName</th>
<th>Price</th>
</tr>


<%
Object obj = session.getAttribute("listofproducts");
if(obj!=null){
	List<Product> listOfProduct = (List<Product>)obj;
	Iterator<Product> it =  listOfProduct.iterator();
	while(it.hasNext()){
		Product p = it.next();
		%>
		<tr>
		<td><%=p.getPid() %></td>
		<td><%=p.getPname() %></td>
		<td><%=p.getPrice() %></td>
		</tr>
		
		<%
		
		
		
	}
	
}
%>
</table>
</body>
</html>