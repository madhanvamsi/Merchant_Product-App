package org.jsp.MerchantProduct.controller;

import java.util.List;

import org.jsp.MerchantProduct.dto.Product;
import org.jsp.MerchantProduct.dto.ResponseStructure;
import org.jsp.MerchantProduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService service;
	@PostMapping("/products/{m_id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,@PathVariable int m_id)
	{
		return service.saveProduct(product, m_id);
	}
	@DeleteMapping("/products/{m_id}")
	public ResponseEntity<ResponseStructure<String>> deleteProduct(@PathVariable int m_id)
	{
		return service.deleteProduct( m_id);
	}
	@GetMapping("/verifyByBrand")
	public ResponseEntity<ResponseStructure<Product>> verifyByBrand(@RequestParam String brand)
	{
		return service.verifyByBrand(brand);
	}
	@GetMapping("/verifyByCategory")
	public ResponseEntity<ResponseStructure<Product>> verifyByCategory(@RequestParam String category)
	{
		return service.verifyByCategory(category);
	}
	@GetMapping("/products/verifyProductByMId/{m_id}")
	public ResponseEntity<ResponseStructure<List<Product>>> verifyProductByMId(@PathVariable int m_id)
	{
		return service.verifyProductByMId(m_id);
	}

}
