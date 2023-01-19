package org.jsp.shoppingcart.dao;

import java.util.List;
import java.util.Optional;

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

public List<Product> fetchAllProduct() {
	return repository.findAll();
}

public Product fetchProduct(int id) 
{
	Optional<Product> optional = repository.findById(id);
	if(optional.isEmpty())
	{
		return null;
	}
	else
		return optional.get();
}

public void deleteById(int id) {
	repository.deleteById(id);
}

}
