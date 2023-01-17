package org.jsp.shoppingcart.dao;

import org.jsp.shoppingcart.dto.Product;
import org.jsp.shoppingcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDao 
{
@Autowired
ProductRepository repository;

public Product saveProduct(Product product) 
{
	return repository.save(product);
}
}
