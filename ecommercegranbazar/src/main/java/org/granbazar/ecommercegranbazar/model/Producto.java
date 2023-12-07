package org.granbazar.ecommercegranbazar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//POJO Plain Old Java Project
	@Entity
	@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String estadoProducto;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private Double precio;
	@Column(nullable = false)
	private String imagen;
	@Column(nullable = false)
	private String envio;
	@Column(nullable = false)
	private String categoria;
	
	
  
	public Producto(String nombre, String estadoProducto, String descripcion, Double precio, String imagen,
			String envio, String categoria) {
		this.nombre = nombre;
		this.estadoProducto = estadoProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.envio = envio;
		this.categoria = categoria;
	}//constructor
	
	public Producto() {

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
	
	public String getCategoria() {
		return categoria;
	}//getEnvio

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}//setEnvio
	
	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", estadoProducto=" + estadoProducto + ", descripcion="
				+ descripcion + ", precio=" + precio + ", imagen=" + imagen + ", envio=" + envio + ", categoria="
				+ categoria + "]";
	}//toString



}//class
