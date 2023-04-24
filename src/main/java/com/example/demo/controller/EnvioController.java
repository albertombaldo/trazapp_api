package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Envio;
import com.example.demo.service.EnvioService;

@RestController
@RequestMapping("/envio")
public class EnvioController {

	@Autowired
	EnvioService es;
	
	@GetMapping
	public Envio getEnvio(@RequestParam Long id) {
		return es.getEnvio(id);
	}
	
	@GetMapping("/")
	public List<Envio> getAllEnvios(){
		return es.getAllEnvios();
	}
	
	@GetMapping("/cliente")
	public List<Envio> getEnviosPorCliente(@RequestParam Long id) {
		return es.getEnviosPorCliente(id);
	}
	
	@GetMapping("/producto")
	public List<Envio> getEnviosPorProducto(@RequestParam Long id) {
		return es.getEnviosPorProducto(id);
	}
	
	@PostMapping
	public Envio saveOrUpdateEnvio(@RequestBody Envio e) {
		return es.saveOrUpdateEnvio(e);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteEnvio(@RequestParam Long id){
		es.deleteEnvio(id);
		return new ResponseEntity("Envio eliminado correctamente", HttpStatus.OK);
	}
}
