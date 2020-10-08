package com.prueba.springboot.app.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.springboot.app.exception.ProductFieldAlreadyExistException;
import com.prueba.springboot.app.exception.ProductoIdNotFoundException;
import com.prueba.springboot.app.models.Producto;
import com.prueba.springboot.app.persistence.ProductoRepository;
import com.prueba.springboot.app.services.ProductoService;


@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@Override
	public Producto registerProducto(Producto producto) throws ProductFieldAlreadyExistException {
		if(productoRepository.existsById(producto.getIdProducto())) {
			throw new ProductFieldAlreadyExistException("Producto con "+producto.getIdProducto()+" ya existente");
		}
		return productoRepository.save(producto);
	}

	@Override
	public Producto UpdateProducto(Producto producto) throws ProductoIdNotFoundException {
		if(!productoRepository.existsById(producto.getIdProducto())) {
			throw new  ProductoIdNotFoundException("Id del producto:"+producto.getIdProducto());
		}
		return productoRepository.save(producto);
	}

	@Override
	public Producto getProductoById(String idProducto) throws ProductoIdNotFoundException {
		Optional<Producto> producto=productoRepository.findById(idProducto);
		return producto.orElseThrow(()-> new ProductoIdNotFoundException("Id del producto:"+idProducto));
	}

	@Override
	public void deleteProducto(String idProducto) throws ProductoIdNotFoundException{
		if(!productoRepository.existsById(idProducto)) {
			throw new  ProductoIdNotFoundException("Id del producto:"+idProducto);
		}
		productoRepository.deleteById(idProducto);
	}

	
}
