package org.jsp.shoppingcart.repository;

import org.jsp.shoppingcart.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>
{

	Admin findByEmail(String email);

}
