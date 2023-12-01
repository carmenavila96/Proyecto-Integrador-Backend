package org.granbazar.ecommercegranbazar.controller;

import java.util.List;

import org.granbazar.ecommercegranbazar.model.Venta;
import org.granbazar.ecommercegranbazar.service.VentaService;
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
@RequestMapping(path="/api/ventas/") //http://localhost:8080/api/ventas/
public class VentaController {
	private final VentaService ventaService;
	@Autowired
	public VentaController(VentaService ventaService) {
		this.ventaService = ventaService;
	}//constructor para inicializar Venta
	
	@GetMapping
	public List<Venta> getAllVentas(){
		return ventaService.getAllVentas();
	}//getAllVentas
	
	@GetMapping(path="{ventId}")			//http://localhost:8080/api/vendedores/1
	public Venta getVenta(@PathVariable("ventId") long id){
		return ventaService.getVenta(id);
	}//getVenta
	
	@DeleteMapping(path= "{ventId}")  //http://localhost:8080/api/vendedores/1
	public Venta deleteVenta(@PathVariable("ventId") long id){
		return ventaService.deleteVenta(id);
	}//deleteVenta

	@PostMapping 
	public Venta addVenta(@RequestBody Venta venta) {
		 return ventaService.addVenta(venta);
	}//addVenta
	
	@PutMapping(path= "{ventId}")
	public Venta updateVenta(@PathVariable("ventId") long id,
			@RequestParam(required= false) String fechaVenta, 
			@RequestParam(required= false) String metodoPago, 
			@RequestParam(required= false) Double totalVenta
			){ return ventaService.updateVenta(id, fechaVenta, metodoPago, totalVenta); 
	}//updateVenta
}//class
