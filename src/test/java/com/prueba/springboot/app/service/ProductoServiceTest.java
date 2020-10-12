package com.prueba.springboot.app.service;

import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.prueba.springboot.app.exception.ClienteFieldAlreadyExistException;
import com.prueba.springboot.app.exception.ProductFieldAlreadyExistException;
import com.prueba.springboot.app.models.Producto;
import com.prueba.springboot.app.persistence.ProductoRepository;
import com.prueba.springboot.app.services.impl.ProductoServiceImpl;

public class ProductoServiceTest {

	private static final Long ID_PRODUCTO = 1L;
	private static final String NOMBRE = "Lavadora";
	private static final Double PRECIO = 105000.00;

	private static final Producto PRODUCTO = new Producto();

	@InjectMocks
	ProductoServiceImpl productoService;

	@Mock
	ProductoRepository productoRepository;

	@Before
	public void init() throws ClienteFieldAlreadyExistException {
		MockitoAnnotations.initMocks(this);
		PRODUCTO.setIdProducto(ID_PRODUCTO);
		PRODUCTO.setNombre(NOMBRE);
		PRODUCTO.setPrecio(PRECIO);
	}

	@Test(expected = ProductFieldAlreadyExistException.class)
	public void registerProductoTestError() throws ProductFieldAlreadyExistException {
		Mockito.when(productoRepository.existsById(ID_PRODUCTO)).thenReturn(true);
		productoService.registerProducto(PRODUCTO);
		fail();
	}

}
