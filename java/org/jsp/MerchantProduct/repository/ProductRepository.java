package org.jsp.MerchantProduct.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.MerchantProduct.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p where p.merchant.id=?1")
	List<Product> verifyProductByMerchantId(int m_id);
	@Query("select p from Product p where p.brand=?1")
	Optional<Product> verifyByBrand(String brand);
	
	@Query("select p from Product p where p.category=?1")
	Optional<Product> verifyByCategory(String category);
	
}
