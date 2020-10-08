package com.prueba.springboot.app.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalles_venta")
public class DetalleVenta implements Serializable {

	@Id
	@Column(name = "id_detalle_venta")
	private String idDetalleVenta;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	private Producto Producto; 
	
	
	public DetalleVenta() {

	}


	public String getIdDetalleVenta() {
		return idDetalleVenta;
	}


	public void setIdDetalleVenta(String idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	

	public Producto getProducto() {
		return Producto;
	}


	public void setProducto(Producto producto) {
		Producto = producto;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
