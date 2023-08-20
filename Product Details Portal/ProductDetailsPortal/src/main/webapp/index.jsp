<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Product Form</h1>

<form action="addproduct" method="post">
ProductId: <input type="number" name="id"><br><br>
Product Type: <input type="text" name="type"><br><br>
ProductName: <input type="text" name="name"><br><br>
Product Price: <input type="text" name="price"><br><br>
<input type="submit" value="AddProduct"><br><br>
</form>

</body>
</html>