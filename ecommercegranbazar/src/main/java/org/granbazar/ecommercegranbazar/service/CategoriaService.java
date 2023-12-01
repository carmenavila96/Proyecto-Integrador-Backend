package org.granbazar.ecommercegranbazar.service;

import java.util.List;
import java.util.Optional;

import org.granbazar.ecommercegranbazar.model.Categoria;
import org.granbazar.ecommercegranbazar.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoriaService {
	
	private final CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}//constructor

	public List<Categoria> getAllCategorias() {
		return categoriaRepository.findAll();
	}//getAllCategorias

	
	public Categoria getCategoria(long id) {
		return categoriaRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("La categoria con el id [" + id
						+ "] no existe")
				);
	}//getCategoria
	

	public Categoria deleteCategoria(long id) {
		Categoria cat = null;
		
		if(categoriaRepository.existsById(id)){//asegurarme de que existe la categoría
			cat = categoriaRepository.findById(id).get();
			categoriaRepository.deleteById(id);
		}//if
		 return cat;
	}//deleteCategoria
	
	public Categoria addCategoria(Categoria categoria) {
		// TODO: validación
		Optional<Categoria> tmpCat = categoriaRepository.findByNombre(categoria.getNombre());
		if (tmpCat.isEmpty()) { //no se encuentra el producto con ese nombre
			return categoriaRepository.save(categoria);
		} else {
			System.out.println("Ya existe la categoria con el nombre ["
					+ categoria.getNombre() + "]"); 
			return null;
		}//else
	}//addCategoria

	public Categoria updateCategoria(long id, String nombre) {
		Categoria cat = null;
		if(categoriaRepository.existsById(id)) {
			 cat = categoriaRepository.findById(id).get();
			if(nombre!=null) cat.setNombre(nombre);
			
			categoriaRepository.save(cat);
		}//existById
		return cat;
	}//updatePCategoria

}//class
