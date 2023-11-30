package org.granbazar.ecommercegranbazar.service;

import java.util.ArrayList;

import org.granbazar.ecommercegranbazar.model.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
	
	public final ArrayList<Venta> lista = new ArrayList<Venta>();
		
	@Autowired
	public VentaService() {
		lista.add(new Venta("23-11-29", "Tarjeta débito", 299.23));
		lista.add(new Venta("23-11-28", "Tarjeta crédito", 150.50));
		lista.add(new Venta("23-11-27", "Tarjeta débito", 200.45));
		lista.add(new Venta("23-11-27", "Tarjeta crédito", 150.89));
		lista.add(new Venta("23-11-26", "Tarjeta débito", 599.05));
	}//constructor
	
	public ArrayList<Venta> getAllVentas() {
		return lista;
	}//getAllVentas
	
	public Venta getVenta(long id) {
		Venta vent = null;
		for (Venta venta : lista) {
			if(id == venta.getId()) {
			vent = venta;
			break;
			}//if
		}//foreach
		return vent;
	} //getVenta
	
	public Venta deleteVenta(long id) {
		Venta vent = null;
		for (Venta venta : lista) {
			if (id == venta.getId()) {
				vent = venta;
		        lista.remove(venta);
		        break;
			} //if
		}//foreach
		return vent;
	}//deleteVenta
	
	public Venta addVenta(Venta venta) {
		lista.add(venta);
		return venta;
	}//addVenta
	
	public Venta updateVenta(long id, String fechaVenta, String metodoPago, Double totalVenta) {
		Venta vent = null;
		for (Venta venta : lista) {
			if(id == venta.getId()) {
				if (fechaVenta!= null) venta.setFechaVenta (fechaVenta);
				if (metodoPago!= null) venta.setMetodoPago (metodoPago);
				if (totalVenta!= null) venta.setTotalVenta (totalVenta);
				vent = venta;
			    break;
			}//if
		}//forEach
		return vent;
	}//updateVenta
}//class
