package org.jsp.MerchantProduct.exception;

public class InvalidCredentialsException extends  RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "invalid credentilas";
	}

}
