package leo.mvc.mvn.jpa_crud.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer productId;

	private String name;

	private String category;

	private Double price;

	private String imageUrl;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
