package leo.mvc.mvn.jpa_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/home")
	public String home() {
		System.out.println("-------------- page : " + this.toString());
		return "fragments/homePage :: ajaxLoadedContent";
	}
	
	@GetMapping(value = "/addProduct")
	public String renderProductForm() {
		System.out.println("-------------- page : " + this.toString());
		return "fragments/productForm :: ajaxLoadedContent";
	}
	
	@GetMapping(value = "/allProducts")
	public String getAllProducts() {
		System.out.println("-------------- page : " + this.toString());
		return "fragments/productList :: ajaxLoadedContent";
	}
}
