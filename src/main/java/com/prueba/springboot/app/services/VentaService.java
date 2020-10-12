package com.prueba.springboot.app.services;

import com.prueba.springboot.app.exception.VentaFieldAlreadyExistException;
import com.prueba.springboot.app.exception.VentaIdNotFoundException;
import com.prueba.springboot.app.models.Venta;

import rx.Single;
import rx.internal.reactivestreams.SingleAsPublisher;

import com.prueba.springboot.app.models.DetalleVenta;
import java.util.List;


public interface VentaService {
	
	Venta registerVenta(Venta venta) throws VentaFieldAlreadyExistException;
	
	Venta getVentaById(Long idVenta)  throws VentaIdNotFoundException;
	
	Single<List<DetalleVenta>> getDetallesByVentaId(Long idVenta) throws VentaIdNotFoundException;
	
}
