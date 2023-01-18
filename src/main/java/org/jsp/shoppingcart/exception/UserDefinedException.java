package org.jsp.shoppingcart.exception;

public class UserDefinedException extends Exception {
	String msg;

	public UserDefinedException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
}
