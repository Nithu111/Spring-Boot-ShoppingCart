package org.jsp.shoppingcart.dao;

import java.util.Optional;

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

public Merchant findById(int id)
{
	Optional<Merchant> option = repository.findById(id); 
	if(option.isPresent())
	{
		return option.get();
	}
	else
		return null;
}

public Merchant findByEmail(String email) {
	return repository.findByEmail(email);
}
}
