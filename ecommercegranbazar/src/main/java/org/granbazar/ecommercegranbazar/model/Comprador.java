package org.granbazar.ecommercegranbazar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compradores")
public class Comprador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String correo;
	@Column(nullable = false)
	private String telefono;
	@Column(nullable = false)
	private String contrasena;
	


	public Comprador(String nombre, String correo, String telefono, String contrasena) {
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.contrasena = contrasena;
	}//constructor
	
	public Comprador() {
	
	}//constructor vacío


	public String getNombre() {
		return nombre;
	}//getNombre


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre


	public String getCorreo() {
		return correo;
	}//getCorreo


	public void setCorreo(String correo) {
		this.correo = correo;
	}//setCorreo


	public String getTelefono() {
		return telefono;
	}//getTelefono


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono


	public String getContrasena() {
		return contrasena;
	}//getContrasena


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}//setContrasena


	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Comprador [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono
				+ ", contrasena=" + contrasena + "]";
	}//toString

}//class
