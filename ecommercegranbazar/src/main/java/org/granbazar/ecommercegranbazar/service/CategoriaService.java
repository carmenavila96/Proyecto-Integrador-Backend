package org.granbazar.ecommercegranbazar.service;

import java.util.ArrayList;

import org.granbazar.ecommercegranbazar.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoriaService {
	
	public final ArrayList<Categoria> lista = new ArrayList<Categoria>();
	
	@Autowired
	public CategoriaService() {
		lista.add(new Categoria("Ropa y Accesorios"));
		lista.add(new Categoria("Entretenimiento"));
		lista.add(new Categoria("Electrodomésticos"));
		lista.add(new Categoria("Electrónicos"));
		lista.add(new Categoria("Recién Añadidos"));
	}//constructor

	public ArrayList<Categoria> getAllCategorias() {
		return lista;
	}//getAllCategorias

	public Categoria getCategoria(long id) {
		Categoria cat = null;
		for (Categoria categoria : lista) {
			if(id == categoria.getId()) {
				cat = categoria;
				break;
			}//if
		}//forEach
		return cat;
	}//getCategoria

	public Categoria deleteCategoria(long id) {
		Categoria cat = null;
		for (Categoria categoria : lista) {
			if(id == categoria.getId()) {
				cat = categoria;
				lista.remove(categoria);
				break;
			}//if
		}//forEach
		return cat;
	}//deleteCategoria

	public Categoria addCategoria(Categoria categoria) {
		 lista.add(categoria);
		 return categoria;
	}//addCategoria

	public Categoria updateCategoria(long id, String nombre) {
		Categoria cat = null;
		for (Categoria categoria : lista) {
			if(id == categoria.getId()) {
				if (nombre!= null) categoria.setNombre (nombre);
				cat= categoria;
			    break;
			}//if
		}//forEach
		return cat;
	}//updateCategoria

}//class
