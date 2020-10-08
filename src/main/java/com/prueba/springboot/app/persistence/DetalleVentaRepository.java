package com.prueba.springboot.app.persistence;

import org.springframework.data.repository.CrudRepository;

import com.prueba.springboot.app.models.DetalleVenta;

public interface DetalleVentaRepository extends CrudRepository<DetalleVenta, String> {

}
