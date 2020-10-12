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

import com.prueba.springboot.app.exception.VentaFieldAlreadyExistException;
import com.prueba.springboot.app.exception.VentaIdNotFoundException;
import com.prueba.springboot.app.models.Venta;
import com.prueba.springboot.app.services.VentaService;

import rx.Scheduler;
import rx.Single;
import rx.schedulers.Schedulers;

@RestController
@RequestMapping("/api/venta")
public class VentaController {
	
	@Autowired
	VentaService ventaService;
	
	@PostMapping
	public ResponseEntity<?> registerVenta(@RequestBody Venta Venta) throws VentaFieldAlreadyExistException {
		return new ResponseEntity<>(ventaService.registerVenta(Venta),HttpStatus.CREATED);
	}

	@GetMapping("/idventa/{idventa}")
	public ResponseEntity<?> getVentaById(@PathVariable Long idventa) throws VentaIdNotFoundException {
		return new ResponseEntity<>(ventaService.getVentaById(idventa),HttpStatus.OK);
	}
	
	@GetMapping("/detalles/{idventa}")
	public Single<ResponseEntity<?>> getDetallesVentaById(@PathVariable Long idventa) throws VentaIdNotFoundException {
		return ventaService.getDetallesByVentaId(idventa).subscribeOn(Schedulers.io()).map(s ->
			new ResponseEntity<>(s,HttpStatus.OK));
	}
}
