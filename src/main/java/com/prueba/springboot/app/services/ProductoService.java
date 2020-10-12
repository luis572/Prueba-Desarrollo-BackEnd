package com.prueba.springboot.app.services;

import com.prueba.springboot.app.exception.ProductFieldAlreadyExistException;
import com.prueba.springboot.app.exception.ProductoIdNotFoundException;
import com.prueba.springboot.app.models.Producto;

public interface ProductoService {

	Producto registerProducto(Producto producto) throws ProductFieldAlreadyExistException;
	
	Producto UpdateProducto(Producto producto) throws ProductoIdNotFoundException ;
	
	Producto getProductoById(Long idProducto) throws ProductoIdNotFoundException;
	
	void deleteProducto(Long idProducto) throws ProductoIdNotFoundException ;
	
}
