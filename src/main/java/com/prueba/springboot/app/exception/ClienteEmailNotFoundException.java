package com.prueba.springboot.app.exception;

public class ClienteEmailNotFoundException extends Exception {

	
	public static final String DESCRIPTION ="El Cliente no fue encontrado";
	
	public ClienteEmailNotFoundException() {
		super(DESCRIPTION);
	}
	
	public ClienteEmailNotFoundException(String detail) {
		super(DESCRIPTION+". "+detail);
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}