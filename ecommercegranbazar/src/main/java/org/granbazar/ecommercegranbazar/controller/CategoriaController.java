package org.granbazar.ecommercegranbazar.controller;

import java.util.List;

import org.granbazar.ecommercegranbazar.model.Categoria;
import org.granbazar.ecommercegranbazar.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/categorias/") //http://localhost:8080/api/categorias/
public class CategoriaController {
	private final CategoriaService categoriaService;
	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}//constructor para inicializar categoria
	
	@GetMapping
	public List<Categoria> getAllCategorias(){
		return categoriaService.getAllCategorias();
	}//getAllCategorias
	
	@GetMapping(path="{catId}")			//http://localhost:8080/api/categorias/1
	public Categoria getCategoria(@PathVariable("catId") long id){
		return categoriaService.getCategoria(id);
	}//getCategoria
	
	@DeleteMapping(path= "{catId}")  //http://localhost:8080/api/categorias/1
	public Categoria deleteCategoria(@PathVariable("catId") long id){
		return categoriaService.deleteCategoria(id);
	}//deleteCategoria

	@PostMapping 
	public Categoria addCategoria(@RequestBody Categoria categoria) {
		 return categoriaService.addCategoria(categoria);
	}//addCategoria
	
	@PutMapping(path= "{catId}")
	public Categoria updateCategoria(@PathVariable("catId") long id,
			@RequestParam(required= false) String nombre
			){ return categoriaService.updateCategoria(id, nombre); 
	}//updateCategoria
}//class
