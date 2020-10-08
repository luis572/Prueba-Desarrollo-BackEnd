package com.prueba.springboot.app.exception;

public class ProductoIdNotFoundException extends Exception {

	
	public static final String DESCRIPTION ="El producto no encontrado";
	
	public ProductoIdNotFoundException() {
		super(DESCRIPTION);
	}
	
	public ProductoIdNotFoundException(String detail) {
		super(DESCRIPTION+". "+detail);
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}