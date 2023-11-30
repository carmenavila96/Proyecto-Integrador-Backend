package org.granbazar.ecommercegranbazar.service;

import java.util.ArrayList;

import org.granbazar.ecommercegranbazar.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductoService {
	public final ArrayList<Producto> lista = new ArrayList<Producto>();
	
	@Autowired
	public ProductoService() {
		lista.add(new Producto("Blazer", "Segunda mano", "Blazer azul", 299.20, "blazer.jpg", "Estafeta"));
		lista.add(new Producto("Tostadora", "Segunda mano", "Tostadora rosa", 150.50, "tostadora.jpg", "Correos de México"));
		lista.add(new Producto("Cien Años de Soledad", "Nuevo con etiqueta", "Libro Cien Años de Soledad", 200.25, "libro.jpg", "Fedex"));
		lista.add(new Producto("Pantalón de Mezclilla", "Nuevo sin etiqueta", "Pantalón de mezclilla verde", 150.45, "pantalon.jpg", "Estafeta"));
		lista.add(new Producto("Televisión 75 pulgadas", "Seminuevo", "Pantalla de 75 pulgadas", 599.23, "television.jpg", "Fedex"));
	}//constructor

	public ArrayList<Producto> getAllProductos() {
		return lista;
	}//getAllProductos

	public Producto getProducto(long id) {
		Producto prod = null;
		for (Producto producto : lista) {
			if(id == producto.getId()) {
				prod = producto;
				break;
			}//if
		}//forEach
		return prod;
	}//getProducto

	public Producto deleteProducto(long id) {
		Producto prod = null;
		for (Producto producto : lista) {
			if(id == producto.getId()) {
				prod = producto;
				lista.remove(producto);
				break;
			}//if
		}//forEach
		return prod;
	}//deleteProducto

	public Producto addProducto(Producto producto) {
		  lista.add(producto);
		  return producto;
	}//addProducto

	public Producto updateProducto(long id, String nombre, String estadoProducto, String descripcion, Double precio, String imagen,
			String envio) {
		Producto prod = null;
		for (Producto producto : lista) {
			if(id == producto.getId()) {
				if (nombre!= null) producto.setNombre (nombre);
				if (estadoProducto!= null) producto.setEstadoProducto (estadoProducto);
				if (descripcion!= null) producto.setDescripcion (descripcion);
				if (precio!= null) producto.setPrecio (precio);
				if (imagen!= null) producto.setImagen (imagen);
				if (envio!= null) producto.setEnvio(envio);
				prod = producto;
			    break;
			}//if
		}//forEach
		return prod;
	}//updateProducto
}//class
