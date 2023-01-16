package org.jsp.shoppingcart.repository;

import org.jsp.shoppingcart.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{

}
