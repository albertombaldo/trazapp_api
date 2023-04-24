package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Producto;
import com.example.demo.entity.Receta;
import com.example.demo.service.ProductoService;
import com.example.demo.service.RecetaService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService ps;
	@Autowired
	RecetaService rs;
	
	@GetMapping
	public Producto getProducto(@RequestParam Long id) {
		return ps.getProducto(id);
	}
	@GetMapping("/{nombre}")
	public List<Producto> getProductoPorNombre(@PathVariable String nombre) {
		return ps.getProductoPorNombre(nombre);
	}
	
	@GetMapping("/tipo/{tipo}")
	public List<Producto> getProductoPorTipo(@PathVariable String tipo) {
		return ps.getProductoPorTipo(tipo);
	}
	
	@GetMapping("/")
	public List<Producto> getTodosProductos() {
		return ps.getTodosProducto();
	}
	
	@GetMapping("/{id}/recetas")
	public List<Receta> getRecetasQueUsanProducto(@PathVariable Long id) {
		return rs.recetasQueConsumenUnaMP(id);
	}
	
	@PostMapping
	public ResponseEntity<?> altaProducto(@RequestBody Producto p){
		ps.saveOrUpdateProducto(p);
		return new ResponseEntity("Producto dado de alta correctamente", HttpStatus.OK);
	} 
	
	@PutMapping
	public ResponseEntity<?> modificarProducto(@RequestBody Producto p){
		ps.saveOrUpdateProducto(p);
		return new ResponseEntity("Producto modificado correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> eliminarProveedor(@RequestParam Long id){
		ps.deleteProducto(id);
		return new ResponseEntity("Producto eliminado correctamente", HttpStatus.OK);
	} 
}
