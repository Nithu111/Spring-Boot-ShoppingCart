package org.jsp.shoppingcart.repository;

import org.jsp.shoppingcart.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer>
{

}
