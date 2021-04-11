<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
	function validate() {
		const emaiLID = document.infoForm.emailID.value;
		
		if (emailID == "") {
			alert("EmailID can not be null")
			return false;
		}
	}
</script>
<body>
	
	<form action="update2.jsp" name="infoForm" onsubmit="return validate()">
		<input type = "text" name = "emailID" placeholder="emailID">
		<input type = "submit" value = "SUBMIT">
	</form>

</body>
</html>