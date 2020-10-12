package com.prueba.springboot.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.springboot.app.exception.VentaFieldAlreadyExistException;
import com.prueba.springboot.app.exception.VentaIdNotFoundException;
import com.prueba.springboot.app.models.DetalleVenta;
import com.prueba.springboot.app.models.Venta;
import com.prueba.springboot.app.persistence.VentaRepository;
import com.prueba.springboot.app.services.ProductoService;
import com.prueba.springboot.app.services.VentaService;

import rx.Single;

@Service
public class VentaServiceImpl implements VentaService {
	
	@Autowired
	VentaRepository ventaRepository;

	@Autowired
	ProductoService productoService;
	
	@Override
	public Venta registerVenta(Venta venta) throws VentaFieldAlreadyExistException {
		if(ventaRepository.existsById(venta.getIdVenta())) {
			throw new VentaFieldAlreadyExistException("Id: "+venta.getIdVenta());
		}
		return ventaRepository.save(venta);
	}

	@Override
	public Venta getVentaById(Long idVenta) throws VentaIdNotFoundException {
		Optional<Venta> venta=ventaRepository.findById(idVenta);
		return venta.orElseThrow(()-> new VentaIdNotFoundException("Id:"+idVenta));
	}

	@Override
	public Single<List<DetalleVenta>> getDetallesByVentaId(Long idVenta) throws VentaIdNotFoundException {
		return Single.create(singleSubscriber ->{
			Optional<Venta> venta=ventaRepository.findById(idVenta);
			try {
				singleSubscriber.onSuccess(venta.orElseThrow(()-> new VentaIdNotFoundException("Id:"+idVenta)).getDetallesVenta());
			} catch (VentaIdNotFoundException e) {
				e.printStackTrace();
			}
		});
	}


}
