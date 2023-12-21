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