<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.wolken.wolkenapp.entity.ProductsEntity" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<% List<ProductsEntity> entityList = (List<ProductsEntity>)request.getAttribute("entityList"); %>
	<% for(int i=0;i<entityList.size();i++) {
		out.println(entityList.get(i).getProductID());
		out.println(entityList.get(i).getProductName());
		out.println(entityList.get(i).getType());
		out.println(entityList.get(i).getPrice());
		out.println("\n");
		
	} %>
	
	<a href = "index.jsp">HOME</a>

</body>
</html>