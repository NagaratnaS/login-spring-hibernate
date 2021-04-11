function validate() {
	const productID = document.infoForm.productID.value;
	const productName = document.infoForm.productName.value;
	const type = document.infoForm.type.value;
	const price = document.infoForm.price.value;
	
	if (productID == ""){
		alert("ProductID can not be null")
		return false;
	}
	
	if (productName.length < 2 && productName.length > 8) {
		alert("Product name should be between 2 and 8 ")
		return false;
	}
	
	if (type.length < 2 && type.length > 6) {
		alert("Type should be between 2 and 6 ")
		return false;
	}
	
	if (price == ""){
		alert("Price can not be null")
		return false;
	}
	
	
}