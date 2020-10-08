package com.prueba.springboot.app.exception;

public class ProductFieldAlreadyExistException extends Exception {

	
	public static final String DESCRIPTION ="El Producto ya se encuentra en la base de datos";
	
	public ProductFieldAlreadyExistException() {
		super(DESCRIPTION);
	}
	
	public ProductFieldAlreadyExistException(String detail) {
		super(DESCRIPTION+". "+detail);
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}