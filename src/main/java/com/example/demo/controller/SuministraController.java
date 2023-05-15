package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Suministra;
import com.example.demo.service.SuministraService;

@RestController
@RequestMapping("/suministro")
public class SuministraController {

	@Autowired
	SuministraService ss;
	
	//localhost:8080/trazapp/suministro?id=10
	@GetMapping
	public Suministra getSuministro(@RequestParam Long id) {
		return ss.getSuministro(id);
	}
	
	//localhost:8080/trazapp/suministro/
	@GetMapping("/")
	public List<Suministra> getAllSuministros() {
		return ss.getTodosSuministros();
	}
	
	//localhost:8080/trazapp/suministro/albaran?num=787655H
	@GetMapping("/albaran")
	public List<Suministra> getSuministrosPorAlbaran(@RequestParam String num) {
		return ss.getSuministrosPorAlbaran(num);
	}
	@GetMapping("/ultimos_suministros")
	public List<Suministra> getSuministrosPorProductoYFechaAsc(@RequestParam Long id_producto){
		return ss.getSuministrosPorProductoYFechaAsc(id_producto);
	}
	
	@PostMapping
	public ResponseEntity<?> anadirSuministro(@RequestBody Suministra s){
		ss.saveOrUpdateSuministro(s);
		return new ResponseEntity("Suministro dado de alta correctamente", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> modificarSuministro(@RequestBody Suministra s){
		ss.saveOrUpdateSuministro(s);
		return new ResponseEntity("Suministro modificado correctamente", HttpStatus.OK);
	}
	
	//"http://localhost:8080/trazapp/suministro/modificar_stock?id=4&cantidad=354
	@PutMapping("/modificar_stock")
	public ResponseEntity<?> modificarStock(@RequestParam Long id, @RequestParam float cantidad){
		ss.actualizarStock(id, cantidad);
		return new ResponseEntity("Stock modificado correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> eliminarSuministro(@RequestParam Long id) {
		ss.deleteSuministro(id);
		return new ResponseEntity("Suministro eliminado correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping("/albaran")
	public ResponseEntity<?> eliminarALbaran(@RequestParam String num) {
		ss.deleteAlbaran(num);
		return new ResponseEntity("Albarán eliminado correctamente", HttpStatus.OK);
	}
}
