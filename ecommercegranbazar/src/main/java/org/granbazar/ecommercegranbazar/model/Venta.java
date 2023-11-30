package org.granbazar.ecommercegranbazar.model;

public class Venta {
	private Long id;
	private String fechaVenta;
	private String metodoPago;
	private Double totalVenta;
	
	private static long total = 0;

	public Venta(String fechaVenta, String metodoPago, Double totalVenta) {
		super();
		this.fechaVenta = fechaVenta;
		this.metodoPago = metodoPago;
		this.totalVenta = totalVenta;
		Venta.total++;
		this.id = total;
	}//constructor

	public Venta() {
		Venta.total++;
		this.id = total;
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
