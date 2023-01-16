package org.jsp.shoppingcart.controller;

import org.jsp.shoppingcart.dto.Customer;
import org.jsp.shoppingcart.helper.ResponseStructure;
import org.jsp.shoppingcart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomerController {

	@Autowired
	CustomerService service;

	@PostMapping("signup")
	public ResponseStructure<Customer> saveCustomer(@RequestBody Customer customer) {
		return service.saveCustomer(customer);
	}

	@PutMapping("signup/{id}")
	public ResponseStructure<Customer> saveCustomer(@PathVariable int id, @RequestParam int otp) {
		return service.verifyCustomer(id, otp);
	}

}
