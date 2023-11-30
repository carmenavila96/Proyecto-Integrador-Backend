package org.granbazar.ecommercegranbazar.model;

public class Producto {
	private Long id;
	private String nombre;
	private String estadoProducto;
	private String descripcion;
	private Double precio;
	private String imagen;
	private String envio;
	
	private static long total = 0;

	public Producto(String nombre, String estadoProducto, String descripcion, Double precio, String imagen,
			String envio) {
		this.nombre = nombre;
		this.estadoProducto = estadoProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.envio = envio;
		Producto.total++;
		this.id= total;
	}//constructor
	
	public Producto() {
		Producto.total++;
		this.id= total;
	}//constructorVacío

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getEstadoProducto() {
		return estadoProducto;
	}//getEstadoProducto

	public void setEstadoProducto(String estadoProducto) {
		this.estadoProducto = estadoProducto;
	}//setEstadoProducto

	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public Double getPrecio() {
		return precio;
	}//getPrecio

	public void setPrecio(Double precio) {
		this.precio = precio;
	}//setPrecio

	public String getImagen() {
		return imagen;
	}//getImagen

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}//setImagen

	public String getEnvio() {
		return envio;
	}//getEnvio

	public void setEnvio(String envio) {
		this.envio = envio;
	}//setEnvio

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", estadoProducto=" + estadoProducto + ", descripcion="
				+ descripcion + ", precio=" + precio + ", imagen=" + imagen + ", envio=" + envio + "]";
	}//toString

}//class
