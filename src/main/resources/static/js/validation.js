function validateProduct() {
	var name = document.getElementById("name").value;
	var category = document.getElementById("category").value;
	var price = document.getElementById("price").value;
	var imageUrl = document.getElementById("imageUrl").value;
	
	var nameError = document.getElementById("nameError");
	var categoryError = document.getElementById("categoryError");
	var priceError = document.getElementById("priceError");
	var imageUrlError = document.getElementById("imageUrlError");
	
	var priceNum = Number(price);
	var returnValue = true;
	
	if (name === "" || name.length > 50 ) {
		nameError.style.visibility = "visible";
		returnValue = false;
	} else {
		nameError.style.visibility = "hidden";
	}
	if (category === "" || category.length > 50 ) {
		categoryError.style.visibility = "visible";
		returnValue = false;
	} else {
		categoryError.style.visibility = "hidden";
	}
	if (price === "" || priceNum < 10 ) {
		priceError.style.visibility = "visible";
		returnValue = false;
	} else {
		priceError.style.visibility = "hidden";
	}
	if (imageUrl === "" || imageUrl.length > 255 ) {
		imageUrlError.style.visibility = "visible";
		returnValue = false;
	} else {
		imageUrlError.style.visibility = "hidden";
	}
	
	return returnValue;
}

function validateNumber(e) {
	var pattern = /^\d{0,4}(\.\d{0,4})?$/g;
	
	return pattern.test(e.key);
}

function validateKeyword(keywork) {
	var returnValue = false;
	
	if (keywork ==="" || keywork.length < 3 ) {
		alert("Minimum 3 letters required!");	
	} else {
		returnValue = true;
	}
	
	return returnValue;
}