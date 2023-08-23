package org.jsp.MerchantProduct.service;

import java.util.Optional;

import org.jsp.MerchantProduct.dao.MerchantDao;
import org.jsp.MerchantProduct.dto.Merchant;
import org.jsp.MerchantProduct.dto.ResponseStructure;
import org.jsp.MerchantProduct.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao Mdao;

	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setData(Mdao.saveMerchant(merchant));
		structure.setMessage("user saved with id :" + merchant.getId());
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Merchant>> UpdateMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setData(Mdao.updateMerchant(merchant));
		structure.setMessage("user updated");
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Merchant>> verifyByPhone(long phone, String password) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		Optional<Merchant> remer = Mdao.verifyByPhone(phone, password);
		if (remer.isPresent()) {
			structure.setData(remer.get());
			structure.setMessage(password);
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

}
