package leo.mvc.mvn.jpa_crud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leo.mvc.mvn.jpa_crud.converter.TempConverter;
import leo.mvc.mvn.jpa_crud.dto.ProductDto;
import leo.mvc.mvn.jpa_crud.entity.ProductEntity;
import leo.mvc.mvn.jpa_crud.repository.ProductRepository;
import leo.mvc.mvn.jpa_crud.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private TempConverter tempConverter;
	
	@Override
	public ProductDto addProduct(ProductDto product) {
		System.out.println("----------------addProduct start------------------------------" );
		System.out.println("----------------product : " + product );
		ProductEntity productEntity = tempConverter.productDtoToEntity(product);

		System.out.println("----------------productEntity : " + productEntity );
		
		ProductEntity storedProduct = productRepository.save(productEntity);
		System.out.println("----------------storedProduct : " + storedProduct );
		ProductDto returnValue = tempConverter.productEntityToDto(storedProduct);
		System.out.println("----------------returnValue : " + returnValue );
		System.out.println("----------------addProduct end------------------------------" );
		return returnValue;
	}

	@Override
	public ProductDto getProductById(Integer productId) {
		ProductDto returnValue = null;
		Optional<ProductEntity> productOpt = productRepository.findById(productId);
		if ( productOpt.isPresent() ) {
			returnValue = tempConverter.productEntityToDto(productOpt.get());
		}
		return returnValue;
	}

	@Override
	public void deleteProduct(Integer productId) {
		productRepository.deleteById(productId);
		productRepository.flush();
	}

	@Override
	public List<ProductDto> listAll() {
		List<ProductDto> returnValue = new ArrayList<ProductDto>();
		List<ProductEntity> allProducts = productRepository.findAll();
		allProducts.forEach( (productEntity) -> {
			ProductDto productDto = tempConverter.productEntityToDto(productEntity);
			returnValue.add(productDto);
		});
			
		return returnValue;
	}

	@Override
	public List<ProductDto> listAllByKeyword(String keyword) {
		List<ProductDto> returnValue = new ArrayList<ProductDto>();
		List<ProductEntity> allProducts = productRepository.findAllByKeyword(keyword);
		allProducts.forEach( (productEntity) -> {
			ProductDto productDto = tempConverter.productEntityToDto(productEntity);
			returnValue.add(productDto);
		});
			
		return returnValue;
	}
}
