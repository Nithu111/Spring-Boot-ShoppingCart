package org.jsp.shoppingcart.dao;

import java.util.Optional;

import org.jsp.shoppingcart.dto.Customer;
import org.jsp.shoppingcart.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDao 
{
@Autowired
CustomerRepository repository;

public Customer saveCustomer(Customer customer)
{
	return repository.save(customer);
}

public Customer findById(int id) {
	Optional<Customer> optional = repository.findById(id);
	if(optional.isPresent())
	{
		return optional.get();
	}else
		return null;
}
}
