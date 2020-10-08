package com.prueba.springboot.app.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.springboot.app.models.Cliente;




public interface ClienteRepository extends CrudRepository<Cliente, String> {
	
	boolean existsByDni(String dni);

	boolean existsByEmail(String email);
	
	Optional<Cliente> findByEmail(String email);
	
}
