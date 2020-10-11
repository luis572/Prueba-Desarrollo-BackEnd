package com.prueba.springboot.app.controllers;

import java.util.Date;

import javax.servlet.ServletException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.springboot.app.exception.ClienteEmailNotFoundException;
import com.prueba.springboot.app.exception.ClienteFieldAlreadyExistException;
import com.prueba.springboot.app.models.Cliente;
import com.prueba.springboot.app.services.ClienteService;
import com.prueba.springboot.app.util.*;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	private static final Logger logger = LogManager.getLogger(ClienteController.class);
	
	@Autowired
	ClienteService clienteService;
	
    @Autowired
    private PasswordEncryptor passwordEncryptor;
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Cliente clienteLogin) throws ServletException, ClienteEmailNotFoundException{
    	String jwtToken = "";
        if (clienteLogin.getEmail() == null || clienteLogin.getContrasena()== null) {
        	logger.error("Error");
            throw new ServletException("Please fill in username and password");
        }

        String email = clienteLogin.getEmail();
        String password = clienteLogin.getContrasena();

        Cliente cliente = clienteService.getClienteByEmail(email);

        String pwd = cliente.getContrasena();

        if (!passwordEncryptor.checkPassword(password, pwd)) {
        	logger.info("datos incorrectos en el logueo");
            throw new ServletException("Invalid login. Please check your name and password.");
        }

        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date()).signWith(
                SignatureAlgorithm.HS256, "secretkey").compact();
        logger.debug("Logueo exitoso");
        return new ResponseEntity<>(new Token(jwtToken, cliente), HttpStatus.OK);
    }

	@PostMapping("/register")
	public ResponseEntity<?> registerCliente(@RequestBody Cliente cliente) throws ClienteFieldAlreadyExistException{
		return new ResponseEntity<>(clienteService.registerCliente(cliente),HttpStatus.CREATED);
	}
	
}
