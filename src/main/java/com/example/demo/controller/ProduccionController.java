package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Produccion;
import com.example.demo.service.ProduccionService;

@RestController
@RequestMapping("/produccion")
public class ProduccionController {

	@Autowired
	ProduccionService ps;
	
	@GetMapping
	public Produccion getProduccion(@RequestParam Long id) {
		return ps.getProduccion(id);
	}
	
	@GetMapping("/")
	public List<Produccion> getTodasProducciones() {
		return ps.getAllProducciones();
	}
	
	@GetMapping("/{fecha}")
	public List<Produccion> getProduccionesPorFecha(@PathVariable Date fecha) {
		return ps.getProduccionesPorFecha(fecha);
	}
	
	@GetMapping("/id_producto/{idProducto}")
	public List<Produccion> getProduccionesPorProducto(@PathVariable Long idProducto) {
		return ps.getProduccionesPorProductoFinal(idProducto);
	}

	@GetMapping("/id_producto/{idProducto}/porfechaasc")
	public List<Produccion> produccionesDeUnProductoPorFechaAsc(@PathVariable Long idProducto) {
		return ps.produccionesDeUnProductoPorFechaAsc(idProducto);
	}
	
	@PostMapping
	public Produccion saveOrUpdateProduccion(@RequestBody Produccion c) {
		return ps.saveOrUpdatePorduccion(c);
	}
	
	//Ver bien cómo hacer los consumos por si hay que devolver las cantidades antes de borrar la producción
	//Poner un límite de tiempo para poder borrar la producción??
	//Poner que sólo pueden eliminarlas admin/encargados??
	@DeleteMapping
	public ResponseEntity<?> deleteProduccion(@RequestParam Long id){
		ps.deleteProduccion(id);
		return new ResponseEntity("Producción eliminada correctamente", HttpStatus.OK);
	}

}
