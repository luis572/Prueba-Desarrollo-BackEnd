package com.prueba.springboot.app.service;



import static org.junit.Assert.assertEquals;

import java.util.Optional;



import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.prueba.springboot.app.exception.ClienteEmailNotFoundException;
import com.prueba.springboot.app.exception.ClienteFieldAlreadyExistException;
import com.prueba.springboot.app.models.Cliente;
import com.prueba.springboot.app.persistence.ClienteRepository;
import com.prueba.springboot.app.services.impl.ClienteServiceImpl;

public class ClienteServiceTest {
	
	private static final Long ID_CLIENTE= 1L;
	private static final String NOMBRE="Luis";
	private static final String APELLIDO="PIZZA";
	private static final String DNI="123456789";
	private static final String EMAIL="luis@gmail.com";
	private static final String CONTRASENA="123456";
	private static final Cliente CLIENTE= new Cliente(); 
	
	
	
	@InjectMocks
	ClienteServiceImpl clienteService;
	
	@Mock
	ClienteRepository clienteRepository;
	
	@Before
	public void init() throws ClienteFieldAlreadyExistException{
		MockitoAnnotations.initMocks(this);
		CLIENTE.setIdCliente(ID_CLIENTE);
		CLIENTE.setNombre(NOMBRE);
		CLIENTE.setApellido(APELLIDO);
		CLIENTE.setDni(DNI);
		CLIENTE.setEmail(EMAIL);
		CLIENTE.setContrasena(CONTRASENA);
	}

	@Test
	public void registerCliente() throws ClienteFieldAlreadyExistException {
		Mockito.when(clienteRepository.save(CLIENTE)).thenReturn(CLIENTE);
		Cliente clienteSave=clienteRepository.save(CLIENTE);
		assertEquals(clienteSave,CLIENTE);
	}
	
	@Test 
	public void getClienteByEmail() throws ClienteEmailNotFoundException{
		Mockito.when(clienteRepository.findByEmail(EMAIL)).thenReturn(Optional.of(CLIENTE));
		clienteService.getClienteByEmail(EMAIL);
	}
	

}
