package org.jsp.MerchantProduct.repository;

import java.util.Optional;

import org.jsp.MerchantProduct.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantRepository extends JpaRepository<Merchant, Integer>{
	
	@Query("select m from Merchant m where m.phone=?1 and m.password=?2")
	Optional<Merchant> verifyByPhone(long phone,String password);
}
