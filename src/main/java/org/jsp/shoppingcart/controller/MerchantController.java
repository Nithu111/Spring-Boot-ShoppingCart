package org.jsp.shoppingcart.controller;

import org.jsp.shoppingcart.dto.Merchant;
import org.jsp.shoppingcart.helper.ResponseStructure;
import org.jsp.shoppingcart.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("merchants")
public class MerchantController {

	@Autowired
	MerchantService service;
	
	@PostMapping("signup")
	public ResponseStructure<Merchant> saveMerchant(@RequestBody Merchant merchant)
	{ 
		return service.saveMerchant(merchant);
	}
}
