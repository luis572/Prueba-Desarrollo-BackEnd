package com.prueba.springboot.app.controllers;




import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prueba.springboot.app.exception.ClienteFieldAlreadyExistException;
import com.prueba.springboot.app.models.Cliente;
import com.prueba.springboot.app.services.ClienteService;



public class ClienteControllerTest {
	
	private static final Long ID_CLIENTE= 1L;
	private static final String NOMBRE="Luis";
	private static final String APELLIDO="PIZZA";
	private static final String DNI="123456789";
	private static final String EMAIL="luis@gmail.com";
	private static final String CONTRASENA="123456";
	
	private static  Cliente CLIENTE_REST; 
	
	
	@Mock
	ClienteService clienteService;
	
	@InjectMocks
	ClienteController clienteController;
	
	@Before
	public void init() throws ClienteFieldAlreadyExistException{
		MockitoAnnotations.initMocks(this);
		CLIENTE_REST=new Cliente();
		CLIENTE_REST.setIdCliente(ID_CLIENTE);
		CLIENTE_REST.setNombre(NOMBRE);
		CLIENTE_REST.setApellido(APELLIDO);
		CLIENTE_REST.setDni(DNI);
		CLIENTE_REST.setEmail(EMAIL);
		CLIENTE_REST.setContrasena(CONTRASENA);
	
		Mockito.when(clienteService.registerCliente(CLIENTE_REST)).thenReturn(CLIENTE_REST);
	}

	@Test
	public void registerCliente() throws ClienteFieldAlreadyExistException {
		final ResponseEntity<?> response= clienteController.registerCliente(CLIENTE_REST);
		assertEquals(response.getStatusCode(),HttpStatus.CREATED);
		assertEquals(response.getBody(),CLIENTE_REST);
	}
	

}
