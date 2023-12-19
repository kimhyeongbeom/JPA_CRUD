package leo.mvc.mvn.jpa_crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import leo.mvc.mvn.jpa_crud.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

	@Query(value = "select * from products where name ilike concat('%', :keyword, '%') "
			+ "or category ilike concat('%', :keyword, '%')", nativeQuery = true)
	List<ProductEntity> findAllByKeyword(@Param("keyword") String keyword);

}
