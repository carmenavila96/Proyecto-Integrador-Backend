package org.granbazar.ecommercegranbazar.service;

import java.util.List;
import java.util.Optional;

import org.granbazar.ecommercegranbazar.model.Producto;
import org.granbazar.ecommercegranbazar.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductoService {
	
	private final ProductoRepository productoRepository; 
	
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}//constructor
	
	
	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}//getAllProductos

	public Producto getProducto(long id) {
		
		return productoRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El producto con el id [" + id
						+ "] no existe")
				);
		
	}//getProducto

	public Producto deleteProducto(long id) {
		Producto prod=null;
		
		if(productoRepository.existsById(id)){//asegurarme de que existe el producto
			prod = productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}//if existById
		
		return prod;
	}//deleteProducto

	public Producto addProducto(Producto producto) {
		// TODO: validación
		Optional<Producto> tmpProd = productoRepository.findByNombre(producto.getNombre());
		if (tmpProd.isEmpty()) { //no se encuentra el producto con ese nombre
			return productoRepository.save(producto);
		} else {
			System.out.println("Ya existe el producto con el nombre ["
					+ producto.getNombre() + "]"); 
			return null;
		}//else
	}//addProducto

	public Producto updateProducto(long id, String nombre, String estadoProducto, String descripcion, Double precio, String imagen, String envio, String categoria) {
		Producto prod = null;
		if(productoRepository.existsById(id)) {
			 prod = productoRepository.findById(id).get();
			if(nombre!=null) prod.setNombre(nombre);
			if(estadoProducto!=null) prod.setEstadoProducto(estadoProducto);
			if(descripcion!=null) prod.setDescripcion(descripcion);
			if(precio!=null) prod.setPrecio(precio);
			if(imagen!=null) prod.setImagen(imagen);
			if(envio!=null) prod.setEnvio(envio);
			if(categoria!=null) prod.setCategoria(categoria);
			
			productoRepository.save(prod);
		}//existById
		return prod;
	}//updateProducto
	
	
	
	
}//class
