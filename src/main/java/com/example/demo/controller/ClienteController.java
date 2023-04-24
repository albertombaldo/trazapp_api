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

import com.example.demo.entity.Cliente;
import com.example.demo.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService cs;
	
	//localhost:8080/trazapp/cliente?id=1
	@GetMapping
	public Cliente getCliente(Long id) {
		return cs.getCliente(id);
	}
	
	//localhost:8080/trazapp/cliente/
	@GetMapping("/")
	public List<Cliente> getAllClientes() {
		return cs.getAllClientes();
	}
	
	//localhost:8080/trazapp/cliente/nombre
	@GetMapping("/{nombre}")
	public List<Cliente> getClientesPorNombre(@PathVariable String nombre) {
		return cs.getClientesPorNombre(nombre);
	}
	
	@PostMapping
	public Cliente saveCliente(@RequestBody Cliente c) {
		return cs.saveOrUpdateCliente(c);
	}
	
	@PutMapping
	public Cliente updateCliente(@RequestBody Cliente c) {
		return cs.saveOrUpdateCliente(c);
	}
	
	//Poner mejor un campo de activo/no activo para mantener los albaranes de la tabla envío?????
	//Comprobar que el cliente tiene pedidos y mostrar mensaje de que no se puede borrar del sistema por los pedidos??
	@DeleteMapping
	public ResponseEntity<?> deleteCliente(@RequestParam Long id){
		cs.deleteCliente(id);
		return new ResponseEntity("Cliente eliminado correctamente", HttpStatus.OK);
	}
}
