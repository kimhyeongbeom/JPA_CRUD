window.onload = redirectHome;

function redirectHome() {
	$("#ajaxLoadedContent").load("/home");
}

function redirectAddProduct() {
	$("#ajaxLoadedContent").load("/addProduct");
}

function redirectAllProducts() {
	$("#ajaxLoadedContent").load("/allProducts");
}

function redirectProductDetails(productId) {
	$("#ajaxLoadedContent").load("/productDetails/" + productId);
}

function redirectUpdateProduct(productId) {
	$("#ajaxLoadedContent").load("/updateProduct/" + productId);
}

function redirectSearchProduct(keywork) {
	$("#ajaxLoadedContent").load("/searchProducts/" + keywork);
}

function deleteProduct(productId) {
	if ( confirm("Remove this product?") ) {
		$.ajax({
			url: "http://localhost:8080/deleteProduct/" + productId,
			type: "GET"
		})
		.done(function() {
			redirectAllProducts();
		})
		.fail(function() {
			alert("Fail!");
		})	
	}
}
 