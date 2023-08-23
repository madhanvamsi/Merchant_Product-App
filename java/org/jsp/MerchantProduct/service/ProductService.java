package org.jsp.MerchantProduct.service;

import java.util.List;
import java.util.Optional;

import org.jsp.MerchantProduct.dao.MerchantDao;
import org.jsp.MerchantProduct.dao.ProductDao;
import org.jsp.MerchantProduct.dto.Merchant;
import org.jsp.MerchantProduct.dto.Product;
import org.jsp.MerchantProduct.dto.ResponseStructure;
import org.jsp.MerchantProduct.exception.IdNotFoundException;
import org.jsp.MerchantProduct.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductDao Pdao;
	@Autowired
	private MerchantDao mdao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, int m_id) {
		Optional<Merchant> user = mdao.verifyById(m_id);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		if (user.isPresent()) {
			Merchant m = user.get();
			m.getProducts().add(product);
			product.setMerchant(m);
			mdao.updateMerchant(user.get());
			Pdao.saveProduct(product);
			structure.setData(Pdao.saveProduct(product));
			structure.setMessage("product saved with the id :" + product.getId());
			structure.setStatuscode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);
		}
		throw new  IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Product> repro = Pdao.findById(id);
		if (repro.isPresent()) {
			Pdao.deleteProduct(id);
			structure.setData("product deleted successfully");
			structure.setMessage("product found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new  IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<Product>> verifyByBrand(String brand) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Product> repro = Pdao.verifyByBrand(brand);
		if (repro.isPresent()) {
			structure.setData(repro.get());
			structure.setMessage("product found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<Product>> verifyByCategory(String category) {
		ResponseStructure<Product> structure = new ResponseStructure<>();
		Optional<Product> repro = Pdao.verifyByCategory(category);
		if (repro.isPresent()) {
			structure.setData(repro.get());
			structure.setMessage("product found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialsException();
	}

	public ResponseEntity<ResponseStructure<List<Product>>> verifyProductByMId(int m_id) {
		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
			structure.setData(Pdao.verifyProductByMId(m_id));
			structure.setMessage("Product found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
	
	}
}
