<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>
<body>

<h2>Create Account </h2>
<form action="LoginController" method="post">
    <label>Email</label>
    <input type="email" name="email"/><br/>
    <label>Password</label>
    <input type="password" name="password"/><br/>
    
    <input type="submit" value="SignIn"/>
    <input type="reset" value="reset"/>
   </form>
   <br>
  
  <a href="Signin.jsp">SignIn</a>

</body>
</html>