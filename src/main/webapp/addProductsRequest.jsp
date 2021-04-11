<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="js/products.js"></script>
<body>
	<form action="addproducts.do" name="infoForm" onsubmit="return validate()">
	
		<input type = "text" name = "productID" placeholder="productID">
		<input type = "text" name = "productName" placeholder="productName">
		<input type = "text" name = "type" placeholder="type">
		<input type = "text" name = "price" placeholder="price">
		<input type = "submit" value = "SUBMIT">
	
	
	</form>

</body>
</html>