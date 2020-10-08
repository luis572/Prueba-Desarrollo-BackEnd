package com.prueba.springboot.app.services;

import com.prueba.springboot.app.exception.VentaFieldAlreadyExistException;
import com.prueba.springboot.app.exception.VentaIdNotFoundException;
import com.prueba.springboot.app.models.Venta;

public interface VentaService {
	
	Venta registerVenta(Venta venta) throws VentaFieldAlreadyExistException;
	
	Venta getVentaById(String idVenta)  throws VentaIdNotFoundException;
	
}
