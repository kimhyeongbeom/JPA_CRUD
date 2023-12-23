window.onload = redirectHome;

function redirectHome() {
	$("#ajaxLoadedContent").load(contextRoot + "/home");
}

function redirectAddProduct() {
	$("#ajaxLoadedContent").load(contextRoot + "/addProduct");
}

function redirectAllProducts() {
	$("#ajaxLoadedContent").load(contextRoot + "/allProducts");
}

function redirectProductDetails(productId) {
	$("#ajaxLoadedContent").load(contextRoot + "/productDetails/" + productId);
}

function redirectUpdateProduct(productId) {
	$("#ajaxLoadedContent").load(contextRoot + "/updateProduct/" + productId);
}

function redirectSearchProduct(keywork) {
	$("#ajaxLoadedContent").load(contextRoot + "/searchProducts/" + keywork);
}

function deleteProduct(productId) {
	if ( confirm("Remove this product?") ) {
		$.ajax({
			url: "http://localhost:8080" + contextRoot + "/deleteProduct/" + productId,
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
 