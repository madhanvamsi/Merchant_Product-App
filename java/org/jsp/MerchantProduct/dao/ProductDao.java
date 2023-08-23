package org.jsp.MerchantProduct.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.MerchantProduct.dto.Product;
import org.jsp.MerchantProduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product)
	{
		return repository.save(product);
	}
	public Optional<Product> findById(int id)
	{
		return repository.findById(id);
		
	}
	public void deleteProduct(int id)
	{
		repository.deleteById(id);
	}
	
	public Optional<Product> verifyByBrand(String brand)
	{
		return repository.verifyByBrand(brand);
	}
	
	public Optional<Product> verifyByCategory(String category)
	{
		return repository.verifyByCategory(category);
	}
	
	public List<Product> verifyProductByMId(int m_id)
	{
		return repository.verifyProductByMerchantId(m_id);
	}
}
