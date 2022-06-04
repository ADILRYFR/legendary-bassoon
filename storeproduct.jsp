<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action ="ProductController" method="post">
<label>PID</label>
<input type="number" name="pid"><br>


<label>PName</label>
<input type="text" name="pname"><br>
<label>Price</label>
<input type="number" name="price"><br>
<input type="submit" name="submit"><br>
<input type="reset" name="reset"><br>


</form>

</body>
</html>