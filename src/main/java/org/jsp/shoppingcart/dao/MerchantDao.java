package org.jsp.shoppingcart.dao;

import org.jsp.shoppingcart.dto.Merchant;
import org.jsp.shoppingcart.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MerchantDao 
{
@Autowired
MerchantRepository repository;

public Merchant savemerchant(Merchant merchant)
{
	return repository.save(merchant);
}
}
