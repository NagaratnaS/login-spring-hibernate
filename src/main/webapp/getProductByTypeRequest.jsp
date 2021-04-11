<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	function validate() {
		
		const type = document.infoForm.type.value;
		
		if (type== ""){
			alert("Type can not be null!!")
			return false;
		}
	}
	
</script>
</head>
<body>
	
	<form action="getproductbytype.do" name="infoForm" onsubmit="return validate()">
		<input type = "text" name = "type" placeholder="type">
		<input type = "submit" name = "SUBMIT">
	
	</form>

</body>
</html>