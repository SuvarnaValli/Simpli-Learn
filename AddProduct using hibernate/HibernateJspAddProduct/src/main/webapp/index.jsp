<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hibernate Jsp Add Product</h1>

<h2>Create Record</h2>
<form action="save" method="post">
Product Name <input type="text" name="name" placeholder="Enter the Product Name"><br><br>
Product Price <input type="text" name="price" placeholder="Enter the Product Price"><br><br>
Product Company Name <input type="text" name="Company" placeholder="Enter the  Product Company"><br><br>
<input type="submit" value="SAVE Details" >
 </form>

</body>
</html>