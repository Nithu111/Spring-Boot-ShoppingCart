package org.jsp.shoppingcart.service;

import org.jsp.shoppingcart.dao.AdminDao;
import org.jsp.shoppingcart.dto.Admin;
import org.jsp.shoppingcart.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminService 
{

	@Autowired
	AdminDao dao;
	
	public ResponseStructure<Admin> saveAdmin(Admin admin)
	{
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		structure.setData(dao.saveAdmin(admin));
		structure.setMessage("Account created Succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}
}
