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

import com.example.demo.entity.Proveedor;
import com.example.demo.service.ProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	ProveedorService ps;
	
	@GetMapping
	public Proveedor getProveedor(@RequestParam Long id) {
		return ps.getProveedor(id);
	}
	
	@GetMapping("/{nombre}")
	public List<Proveedor> getProveedor(@PathVariable String nombre) {
		return ps.getProveedorPorNombre(nombre);
	}
	
	@GetMapping("/")
	public List<Proveedor> getProveedores(){
		return ps.getAllProveedor();
	}
	
	@PostMapping
	public ResponseEntity<?> altaProveedor(@RequestBody Proveedor p){
		ps.saveOrUpdateProveedor(p);
		return new ResponseEntity("Proveedor dado de alta correctamente", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> modificarProveedor(@RequestBody Proveedor p){
		ps.saveOrUpdateProveedor(p);
		return new ResponseEntity("Proveedor modificado correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> eliminarProveedor(@RequestParam Long id){
		ps.deleteProveedor(id);
		return new ResponseEntity("Proveedor eliminado correctamente", HttpStatus.OK);
	}
}
