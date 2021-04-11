<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	function validate() {
		const userName = document.infoForm.userName.value;
		
		if (userName == "") {
			alert("Username can not be null!!")
			return false;
		}
	}
</script>
</head>
<body>
	<form action="getUserByUserName.do" name="infoForm" onsubmit="return validate()">
		<input type="text" name="userName" placeholder="userName">
		<input type="submit" value="GET">
	</form>
</body>
</html>