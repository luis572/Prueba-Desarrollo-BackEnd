package com.prueba.springboot.app.services;

import com.prueba.springboot.app.exception.ClienteEmailNotFoundException;
import com.prueba.springboot.app.exception.ClienteFieldAlreadyExistException;
import com.prueba.springboot.app.models.Cliente;

public interface ClienteService {
	
	Cliente registerCliente(Cliente cliente) throws ClienteFieldAlreadyExistException;
	
	Cliente getClienteByEmail(String email) throws ClienteEmailNotFoundException;
}
