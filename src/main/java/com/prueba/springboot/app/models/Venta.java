package com.prueba.springboot.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.MetaValue;

@Table(name = "ventas")
@Entity
public class Venta implements Serializable {

	@Id
	@Column(name = "id_venta")
	private String idVenta;


	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venta")
	private List<DetalleVenta> detallesVenta;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	public Venta() {
		List<DetalleVenta> detallesVenta =new ArrayList<DetalleVenta>();
	}

	public String getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<DetalleVenta> getDetallesVenta() {
		return detallesVenta;
	}

	public void setDetallesVenta(List<DetalleVenta> detallesVenta) {
		this.detallesVenta = detallesVenta;
	}

	public void addDetalleVenta(DetalleVenta detalleVenta) {
		this.detallesVenta.add(detalleVenta);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
