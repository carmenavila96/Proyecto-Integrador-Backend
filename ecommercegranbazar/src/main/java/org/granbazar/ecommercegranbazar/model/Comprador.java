package org.granbazar.ecommercegranbazar.model;

public class Comprador {
	private Long id;
	private String nombre;
	private String correo;
	private String telefono;
	private String contrasena;
	
	
	private static long total = 0;


	public Comprador(String nombre, String correo, String telefono, String contrasena) {
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.contrasena = contrasena;
		Comprador.total++;
		this.id = total;
	}//constructor
	
	public Comprador() {
		Comprador.total++;
		this.id= total;
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
