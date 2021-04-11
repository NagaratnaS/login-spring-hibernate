<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String emailID = request.getParameter("emailID"); %>
	<form action="update.do">
		<input type="hidden" value=<%= emailID %> name="emailID" readonly>
		<input type="date"  name = "dateOfBirth" placeholder="dateOfBirth">
		<input type = "userName" name = "userName" placeholder="userName">
		<input type = "submit" name = "SUBMIT">
	</form>
</body>
</html>