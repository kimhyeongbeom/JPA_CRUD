package leo.mvc.mvn.jpa_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import leo.mvc.mvn.jpa_crud.dto.ProductDto;
import leo.mvc.mvn.jpa_crud.service.ProductService;

@Controller
public class MainController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/home")
	public String home() {
		return "fragments/homePage :: ajaxLoadedContent";
	}
	
	@GetMapping(value = "/addProduct")
	public String renderProductForm(ModelMap map) {
		ProductDto productDto = new ProductDto();
		map.put("product", productDto);
		return "fragments/productForm :: ajaxLoadedContent";
	}
	
	@PostMapping(value = "/storeProduct")
	public String storeProduct(@ModelAttribute("product") ProductDto product) {

		System.out.println("----------------product : " + product );

		productService.addProduct(product);
		return "fragments/homePage :: ajaxLoadedContent";
	}
	
	@GetMapping(value = "/allProducts")
	public String getAllProducts(ModelMap map) {
		List<ProductDto> allProducts = productService.listAll();

		System.out.println("----------------allProducts : " + allProducts );

		map.put("allProducts", allProducts);
		map.put("recordsPerPage", 5); // 1 page당 보여지는 갯수
		return "fragments/productList :: ajaxLoadedContent";
	}
	
	@GetMapping(value = "/productDetails/{productId}")
	public String getProductDetails(@PathVariable("productId") Integer productId, ModelMap map) {
		ProductDto productDto = productService.getProductById(productId);
		map.put("product", productDto);
		return "fragments/productDetails :: ajaxLoadedContent";
	}
	
	@GetMapping(value = "/updateProduct/{productId}")
	public String renderUpdateProductForm(@PathVariable("productId") Integer productId, ModelMap map) {
		ProductDto productDto     = new ProductDto();
		ProductDto currentProduct = productService.getProductById(productId);
		map.put("product", productDto);
		map.put("currentProduct", currentProduct);
		return "fragments/updateProductForm :: ajaxLoadedContent";
	}
	
	@GetMapping(value = "/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") Integer productId) {
		productService.deleteProduct(productId);
		return "fragments/homePage :: ajaxLoadedContent";
	}
	
	@GetMapping(value = "/searchProducts/{keyword}")
	public String search(@PathVariable("keyword") String keyword, ModelMap map) {
		List<ProductDto> allProducts = productService.listAllByKeyword(keyword);
		map.put("allProducts", allProducts);
		map.put("recordsPerPage", 2); // 1 page당 보여지는 갯수
		return "fragments/searchResult :: ajaxLoadedContent";
	}
}
