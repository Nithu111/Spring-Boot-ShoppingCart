package org.jsp.shoppingcart.service;

import java.util.List;
import java.util.Random;

import org.jsp.shoppingcart.dao.MerchantDao;
import org.jsp.shoppingcart.dao.ProductDao;
import org.jsp.shoppingcart.dto.Merchant;
import org.jsp.shoppingcart.dto.Product;
import org.jsp.shoppingcart.exception.UserDefinedException;
import org.jsp.shoppingcart.helper.Emailverification;
import org.jsp.shoppingcart.helper.Login;
import org.jsp.shoppingcart.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	@Autowired
	MerchantDao dao;

	@Autowired
	ProductDao productDao;

	@Autowired
	Emailverification emailverification;

	public ResponseStructure<Merchant> saveMerchant(Merchant merchant) {
		Random random = new Random();
		int otp = random.nextInt(100000, 999999);
		merchant.setOtp(otp);

		emailverification.sendVerification(merchant);

		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setData(dao.savemerchant(merchant));
		structure.setMessage("Verify your Email");
		structure.setStatus(HttpStatus.PROCESSING.value());
		return structure;
	}

	public ResponseStructure<Merchant> verifyMerchant(int id, int otp) throws UserDefinedException {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();

		Merchant merchant = dao.findById(id);

		if (merchant == null) {
			throw new UserDefinedException("Id not found");
		} else {
			if (otp == merchant.getOtp()) {
				merchant.setStatus(true);
				structure.setData(dao.savemerchant(merchant));
				structure.setMessage("Account created Succesfully");
				structure.setStatus(HttpStatus.CREATED.value());
			} else {
				throw new UserDefinedException("OTP MIssmatch");
			}
		}

		return structure;
	}

	public ResponseStructure<Merchant> merchantLogin(Login login) throws UserDefinedException {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();

		String email = login.getEmail();
		String password = login.getPassword();

		Merchant merchant = dao.findByEmail(email);
		if (merchant == null) {
			throw new UserDefinedException("Email Not Found");
		} else {
			if (merchant.isStatus()) {
				if (merchant.getPassword().equals(password)) {
					structure.setData(merchant);
					structure.setMessage("Login Success");
					structure.setStatus(HttpStatus.FOUND.value());
				} else {
					throw new UserDefinedException("Password Missmatch");
				}
			} else {
			throw new UserDefinedException("Verify your email first");
			}
		}

		return structure;
	}

	public ResponseStructure<Merchant> addProduct(int id, Product product) {
		Merchant merchant = dao.findById(id);
		product.setMerchant(merchant);
		
		List<Product> products = merchant.getProducts();
		products.add(productDao.saveProduct(product));
		merchant.setProducts(products);
		
		ResponseStructure<Merchant> structure=new ResponseStructure<>();
		structure.setData(dao.savemerchant(merchant));
		structure.setMessage("Product added Succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
		
	}

	public ResponseStructure<Product> updateProduct(Product product) {
		ResponseStructure<Product> structure=new ResponseStructure<>();
		structure.setData(productDao.saveProduct(product));
		structure.setMessage("Product Updated Succesfully");
		structure.setStatus(HttpStatus.OK.value());
		return structure;
	}

	public ResponseStructure<Product> deleteProduct(int id) throws UserDefinedException {
		Product product=productDao.fetchProduct(id);
		if(product==null)
		{
			throw new UserDefinedException("Product Not Found");
		}
		else {
			Merchant merchant=product.getMerchant();
			List<Product> products = merchant.getProducts();
			products.remove(product);
			dao.savemerchant(merchant);
			
			product.setMerchant(null);
			productDao.saveProduct(product);
			productDao.deleteById(id);
			ResponseStructure<Product> structure=new ResponseStructure<>();
			structure.setData(product);
			structure.setMessage("Product deleted Succesfully");
			structure.setStatus(HttpStatus.ACCEPTED.value());
			return structure;
		}
	}

}
