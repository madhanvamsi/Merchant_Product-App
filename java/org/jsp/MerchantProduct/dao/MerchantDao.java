package org.jsp.MerchantProduct.dao;

import java.util.Optional;

import org.jsp.MerchantProduct.dto.Merchant;
import org.jsp.MerchantProduct.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository repository;
	
	public Merchant saveMerchant(Merchant merchant)
	{
		return repository.save(merchant);
	}
	public Merchant updateMerchant(Merchant merchant)
	{
		return repository.save(merchant);
	}
	
	public Optional<Merchant> verifyByPhone(long phone,String password)
	{
		return repository.verifyByPhone(phone, password);
	}
	public Optional<Merchant> verifyById(int id)
	{
		return repository.findById(id);
	}
	

}
