package com.prueba.springboot.app.exception;


public class VentaIdNotFoundException extends Exception {

	
	public static final String DESCRIPTION ="Venta no encontrada";
	
	public VentaIdNotFoundException() {
		super(DESCRIPTION);
	}
	
	public VentaIdNotFoundException(String detail) {
		super(DESCRIPTION+". "+detail);
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}