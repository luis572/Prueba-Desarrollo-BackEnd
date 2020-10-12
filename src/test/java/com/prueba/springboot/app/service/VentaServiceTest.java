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
import com.prueba.springboot.app.exception.VentaIdNotFoundException;
import com.prueba.springboot.app.models.Producto;
import com.prueba.springboot.app.persistence.ProductoRepository;
import com.prueba.springboot.app.persistence.VentaRepository;
import com.prueba.springboot.app.services.impl.ProductoServiceImpl;
import com.prueba.springboot.app.services.impl.VentaServiceImpl;

public class VentaServiceTest {

	private static final Long ID_VENTA = 1L;

	@InjectMocks
	VentaServiceImpl ventaService;

	@Mock
	VentaRepository VentaRepository;

	@Before
	public void init() throws ClienteFieldAlreadyExistException {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = VentaIdNotFoundException.class)
	public void registerProductoTestError() throws VentaIdNotFoundException {
		Mockito.when(VentaRepository.findById(ID_VENTA)).thenReturn(Optional.empty());
		ventaService.getVentaById(ID_VENTA);
		fail();
	}

}
