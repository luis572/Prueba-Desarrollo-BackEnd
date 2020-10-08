package com.prueba.springboot.app.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.springboot.app.models.Producto;


public interface ProductoRepository extends CrudRepository<Producto,String>{

}
