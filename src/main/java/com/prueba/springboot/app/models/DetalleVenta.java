package com.prueba.springboot.app.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalles_venta")
public class DetalleVenta implements Serializable {

	@Id
	@Column(name = "id_detalle_venta")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long idDetalleVenta;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_producto")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Producto producto; 
	
	
	public DetalleVenta() {

	}


	public Long getIdDetalleVenta() {
		return idDetalleVenta;
	}


	public void setIdDetalleVenta(Long idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	

	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
