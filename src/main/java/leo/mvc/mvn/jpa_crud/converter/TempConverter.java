package leo.mvc.mvn.jpa_crud.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import leo.mvc.mvn.jpa_crud.dto.ProductDto;
import leo.mvc.mvn.jpa_crud.entity.ProductEntity;

@Component
public class TempConverter {

	@Autowired
	private ModelMapper mapper; // ModelMapper를 이용하여 entity와 dto를 상호 변환 합니다.
	
	public ProductDto productEntityToDto(ProductEntity productEntity) {
		ProductDto returnValue = mapper.map(productEntity, ProductDto.class);
		return returnValue;
	}
	
	public ProductEntity productDtoToEntity(ProductDto productDto) {
		ProductEntity returnValue = mapper.map(productDto, ProductEntity.class);
		return returnValue;
	}
}
