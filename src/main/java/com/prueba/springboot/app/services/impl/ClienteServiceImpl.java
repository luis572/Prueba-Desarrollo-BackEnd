package com.prueba.springboot.app.services.impl;

import java.util.Optional;

import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.springboot.app.exception.ClienteEmailNotFoundException;
import com.prueba.springboot.app.exception.ClienteFieldAlreadyExistException;
import com.prueba.springboot.app.models.Cliente;
import com.prueba.springboot.app.persistence.ClienteRepository;
import com.prueba.springboot.app.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	private PasswordEncryptor passwordEncryptor;

	@Override
	public Cliente registerCliente(Cliente cliente) throws ClienteFieldAlreadyExistException {
		if(clienteRepository.existsById(cliente.getIdCliente())) {
			throw new ClienteFieldAlreadyExistException("El id ya existe");
		}
		if(clienteRepository.existsByDni(cliente.getDni())) {
			throw new ClienteFieldAlreadyExistException("El Dni ya existe");
		}
		if(clienteRepository.existsByEmail(cliente.getEmail())) {
			throw new ClienteFieldAlreadyExistException("El Email ya existe");
		}
		cliente.setContrasena(passwordEncryptor.encryptPassword(cliente.getContrasena()));
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente getClienteByEmail(String email) throws ClienteEmailNotFoundException {
		
		Optional<Cliente> cliente= clienteRepository.findByEmail(email);
		
		return cliente.orElseThrow(()-> new ClienteEmailNotFoundException());
	}

}
