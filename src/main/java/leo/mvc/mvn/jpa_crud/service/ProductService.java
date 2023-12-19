package leo.mvc.mvn.jpa_crud.service;

import java.util.List;

import leo.mvc.mvn.jpa_crud.dto.ProductDto;

public interface ProductService {

	ProductDto addProduct(ProductDto product);
	
	ProductDto getProductById(Integer productId);
	
	void deleteProduct(Integer productId);
	
	List<ProductDto> listAll();
	
	List<ProductDto> listAllByKeyword(String keyword);
}
