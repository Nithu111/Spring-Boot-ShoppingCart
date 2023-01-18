package org.jsp.shoppingcart.exception;

import org.jsp.shoppingcart.helper.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController 
{

	@ExceptionHandler(value = UserDefinedException.class)
	public ResponseEntity<ResponseStructure<String>> generalException(UserDefinedException ie){
		ResponseStructure<String> responseStructure = new ResponseStructure<String>() ;
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("There is some exception");
		responseStructure.setData(ie.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
	}
}
