package com.prueba.springboot.app.exception;

public class ClienteFieldAlreadyExistException extends Exception {

	
	public static final String DESCRIPTION ="Cliente Ya existente en la base de datos";
	
	public ClienteFieldAlreadyExistException() {
		super(DESCRIPTION);
	}
	
	public ClienteFieldAlreadyExistException(String detail) {
		super(DESCRIPTION+". "+detail);
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
