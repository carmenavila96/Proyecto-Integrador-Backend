package org.granbazar.ecommercegranbazar.service;

import java.util.List;
import java.util.Optional;

import org.granbazar.ecommercegranbazar.model.Venta;
import org.granbazar.ecommercegranbazar.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
	
	private final VentaRepository ventaRepository;
	
	@Autowired
	public VentaService(VentaRepository ventaRepository) {
		this.ventaRepository = ventaRepository;
	}//constructor
	

	public List<Venta> getAllVentas() {
		return ventaRepository.findAll();
	}//getAllVentas
	
	public Venta getVenta(long id) {
		return ventaRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("La venta con el id [" + id
						+ "] no existe")
				);
	}//getVenta
	
	public Venta deleteVenta(long id) {
		Venta vent=null;
		if(ventaRepository.existsById(id)) {
			vent = ventaRepository.findById(id).get();
			ventaRepository.deleteById(id);
		}//if existById
		return vent;
	}//deleteVenta
	
	public Venta addVenta(Venta venta) {
	
		   return ventaRepository.save(venta);

	}//addVenta
	
	public Venta updateVenta(long id, String fechaVenta, String metodoPago, Double totalVenta) {
		Venta vent = null;
		
			if(ventaRepository.existsById(id)) {
				vent = ventaRepository.findById(id).get();
				if (fechaVenta!= null) vent.setFechaVenta (fechaVenta);
				if (metodoPago!= null) vent.setMetodoPago (metodoPago);
				if (totalVenta!= null) vent.setTotalVenta (totalVenta);
				ventaRepository.save(vent);
			}//if
		
		return vent;
	}//updateVenta
	
}//class
