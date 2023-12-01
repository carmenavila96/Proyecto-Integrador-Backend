package org.granbazar.ecommercegranbazar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String fechaVenta;
	@Column(nullable = false)
	private String metodoPago;
	@Column(nullable = false)
	private Double totalVenta;
	
	public Venta(String fechaVenta, String metodoPago, Double totalVenta) {
		this.fechaVenta = fechaVenta;
		this.metodoPago = metodoPago;
		this.totalVenta = totalVenta;
	}//constructor

	public Venta() {
	
	}//constructorVacio

	public String getFechaVenta() {
		return fechaVenta;
	}//getFechaVenta

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}//setFechaVenta

	public String getMetodoPago() {
		return metodoPago;
	}//getMetodoPago

	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}//setMetodoPago

	public Double getTotalVenta() {
		return totalVenta;
	}//getTotalVenta

	public void setTotalVenta(Double totalVenta) {
		this.totalVenta = totalVenta;
	}//setTotalVenta

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Venta [id=" + id + ", fechaVenta=" + fechaVenta + ", metodoPago=" + metodoPago + ", totalVenta="
				+ totalVenta + "]";
	}//toString

}//class
