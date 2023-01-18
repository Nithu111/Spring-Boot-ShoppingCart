package org.jsp.shoppingcart.service;

import org.jsp.shoppingcart.dao.AdminDao;
import org.jsp.shoppingcart.dto.Admin;
import org.jsp.shoppingcart.exception.UserDefinedException;
import org.jsp.shoppingcart.helper.Login;
import org.jsp.shoppingcart.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	AdminDao dao;

	public ResponseStructure<Admin> saveAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<>();
		structure.setData(dao.saveAdmin(admin));
		structure.setMessage("Account created Succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseStructure<Admin> adminLogin(Login login) throws UserDefinedException   {
		ResponseStructure<Admin> structure = new ResponseStructure<>();

		String email = login.getEmail();
		String password = login.getPassword();

		Admin admin = dao.findByEmail(email);
		if (admin == null) {
			throw new UserDefinedException("Email not found");
		} else {
			if (admin.getPassword().equals(password)) {
				structure.setData(admin);
				structure.setMessage("Login Success");
				structure.setStatus(HttpStatus.FOUND.value());
			} else {
				throw new UserDefinedException("Password MissMatch");
			}
		}

		return structure;
	}
}
