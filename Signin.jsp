<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signin</title>
</head>
<body>


<h2>Login Page</h2>
<form  action ="LoginController" method="get">
    <label>Email</label>
    <input type="email" name="email"/><br/>
    <label>Password</label>
    <input type="password" name="password"/><br/>
    <label>Type Of User</label>
    <input type="radio" name="typeOfUser" value="Admin">Admin
    <input type="radio" name="typeOfUser" value="User">User<br>
    <input type="submit" value="SignIn"/>
    <input type="reset" value="reset"/>


</form>
<br>
  <a href="Signup.jsp">SignUp</a>

</body>
</html>