package org.jsp.shoppingcart.dao;

import org.jsp.shoppingcart.dto.Admin;
import org.jsp.shoppingcart.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminDao 
{

	@Autowired
	AdminRepository repository;
	
	public Admin saveAdmin(Admin admin)
	{
		return repository.save(admin);
	}

	public Admin findByEmail(String email) {
		return repository.findByEmail(email);
	}
}
