package org.granbazar.ecommercegranbazar.model;

public class Vendedor {
	private Long id;
	private String nombre;
	private String correo;
	private Integer codigoPostal;
	private String direccion;
	private String telefono;
	private String contrasena;
	
	
	private static long total = 0;


	public Vendedor(String nombre, String correo, Integer codigoPostal, String direccion, String telefono,
			String contrasena) {
		this.nombre = nombre;
		this.correo = correo;
		this.codigoPostal = codigoPostal;
		this.direccion = direccion;
		this.telefono = telefono;
		this.contrasena = contrasena;
		Vendedor.total++;
		this.id = total;
	}//constructor
	
	public Vendedor() {
		Vendedor.total++;
		this.id = total;
	}//constructorVacio

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

	public int getCodigoPostal() {
		return codigoPostal;
	}//getCodigoPostal

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}//setCodigoPostal

	public String getDireccion() {
		return direccion;
	}//getDireccion

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}//setDireccion

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
		return "Vendedor [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", codigoPostal=" + codigoPostal
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", contrasena=" + contrasena + "]";
	}//toString

}//class
