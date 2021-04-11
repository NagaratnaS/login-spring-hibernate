<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	<% out.println(request.getAttribute("userName"));%>
	<% out.println(request.getAttribute("contactNumber")); %>
	<% out.println(request.getAttribute("dob")); %>
	<% out.println(request.getAttribute("emailid")); %>
	<% out.println(request.getAttribute("gender")); %>
	<a href = "index.jsp">HOME</a>
	</body>
	
</html>