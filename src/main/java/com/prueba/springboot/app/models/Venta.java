package com.prueba.springboot.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "ventas")
@Entity
public class Venta implements Serializable {

	@Id
	@Column(name = "id_venta")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long idVenta;

	@ManyToOne(fetch =FetchType.LAZY)
	@JsonBackReference 
	private Cliente cliente; 

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_venta")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<DetalleVenta> detallesVenta;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	
	public Venta() {
		this.detallesVenta =new ArrayList<DetalleVenta>();
	}

	@PrePersist
	public void dateVenta() {
		fecha=new Date();
	}
	
	public Long getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Long idVenta) {
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

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
