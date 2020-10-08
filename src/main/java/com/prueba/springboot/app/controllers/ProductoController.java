package com.prueba.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.springboot.app.exception.ProductFieldAlreadyExistException;
import com.prueba.springboot.app.exception.ProductoIdNotFoundException;
import com.prueba.springboot.app.models.Producto;
import com.prueba.springboot.app.services.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@PostMapping
	public ResponseEntity<?> registerProdcuto(@RequestBody Producto producto) throws ProductFieldAlreadyExistException {
		return new ResponseEntity<>(productoService.registerProducto(producto),HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> updateProducto(@RequestBody Producto producto) throws ProductoIdNotFoundException {
		return new ResponseEntity<>(productoService.UpdateProducto(producto),HttpStatus.OK);
	}

	@DeleteMapping("/idproducto/{idproducto}")
	public ResponseEntity<?> deleteProducto(@PathVariable String idproducto) throws ProductoIdNotFoundException {
		productoService.deleteProducto(idproducto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/idproducto/{idproducto}")
	public ResponseEntity<?> getProductoById(@PathVariable String idproducto) throws ProductoIdNotFoundException {
		return new ResponseEntity<>(productoService.getProductoById(idproducto),HttpStatus.OK);
	}
}
