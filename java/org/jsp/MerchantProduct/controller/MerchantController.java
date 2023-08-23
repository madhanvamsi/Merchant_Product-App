package org.jsp.MerchantProduct.controller;

import org.jsp.MerchantProduct.dto.Merchant;
import org.jsp.MerchantProduct.dto.ResponseStructure;
import org.jsp.MerchantProduct.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@CrossOrigin
public class MerchantController {
	@Autowired
	private MerchantService service;
	@PostMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant)
	{
		return service.saveMerchant(merchant);
	}
	@PutMapping("/merchants")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant)
	{
		return service.UpdateMerchant(merchant);
	}
	@GetMapping("/verifyByPhone")
	public ResponseEntity<ResponseStructure<Merchant>> verifyByPhone(@RequestParam long phone,@RequestParam String password)
	{
		return service.verifyByPhone(phone, password);
	}

}
