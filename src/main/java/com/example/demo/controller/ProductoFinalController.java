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

import com.example.demo.entity.ProductoFinal;
import com.example.demo.service.ProductoFinalService;

@RestController
@RequestMapping("/productofinal")
public class ProductoFinalController {

	@Autowired
	ProductoFinalService pfs;
	
	@GetMapping
	public ProductoFinal getProductoFinal(@RequestParam Long id) {
		return pfs.getProductoFinal(id);
	}
	
	@GetMapping("/")
	public List<ProductoFinal> getAllProductoFinal() {
		return pfs.getAllProductoFinal();
	}
	
	@PostMapping
	public ProductoFinal saveOrUpdateProductoFinal(@RequestBody ProductoFinal pf) {
		return pfs.saveOrUpdateProductoFinal(pf);
	}
	
	//Poner mejor un campo de activo/no activo para mantener los albaranes de la tabla envío y las producciones?????
	//Comprobar que el producto tiene producciones y mostrar mensaje de que no se puede borrar del sistema??
	@DeleteMapping
	public ResponseEntity<?> deleteProductoFinal(@RequestParam Long id){
		pfs.deleteProductoFinal(id);
		return new ResponseEntity("Producto eliminado correctamente", HttpStatus.OK);
	}
}
