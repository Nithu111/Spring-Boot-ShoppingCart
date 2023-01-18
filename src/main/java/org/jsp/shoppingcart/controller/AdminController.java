package org.jsp.shoppingcart.controller;

import org.jsp.shoppingcart.dto.Admin;
import org.jsp.shoppingcart.exception.UserDefinedException;
import org.jsp.shoppingcart.helper.Login;
import org.jsp.shoppingcart.helper.ResponseStructure;
import org.jsp.shoppingcart.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admins")
public class AdminController {

	@Autowired
	AdminService service;

	@PostMapping("add")
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}

	@PostMapping("login")
	public ResponseStructure<Admin> login(@RequestBody Login login) throws UserDefinedException  {
		return service.adminLogin(login);
	}
}
