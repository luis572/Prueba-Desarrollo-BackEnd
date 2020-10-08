package com.prueba.springboot.app.exception;

public class VentaFieldAlreadyExistException extends Exception {

	
	public static final String DESCRIPTION ="la venta ya se encuentra en la base de datos";
	
	public VentaFieldAlreadyExistException() {
		super(DESCRIPTION);
	}
	
	public VentaFieldAlreadyExistException(String detail) {
		super(DESCRIPTION+". "+detail);
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
