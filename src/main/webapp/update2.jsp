<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function validate() {
		
		const userName = document.infoForm.userName.value;
		
		if (userName == ""){
			alert("Username can not be null")
			return false;
		}
	}
</script>
<body>
	<% String emailID = request.getParameter("emailID"); %>
	<form action="update.do" name="infoForm" onsubmit="return validate()">
		<input type="hidden" value=<%= emailID %> name="emailID" readonly>
		<input type="date"  name = "dateOfBirth" placeholder="dateOfBirth">
		<input type = "userName" name = "userName" placeholder="userName">
		<input type = "submit" name = "SUBMIT">
	</form>
</body>
</html>