package org.granbazar.ecommercegranbazar.model;

public class Categoria {
	private Long id;
	private String nombre;
	
	
	private static long total = 0;


	public Categoria(String nombre) {
		this.nombre = nombre;
		Categoria.total++;
		this.id = total;
	}//constructor
	
	public Categoria() {
		Categoria.total++;
		this.id = total;
	}//constructorVacío

	public String getNombre() {
		return nombre;
	}//getNombre


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre


	public Long getId() {
		return id;
	}//getId


	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}//toString

}//class
