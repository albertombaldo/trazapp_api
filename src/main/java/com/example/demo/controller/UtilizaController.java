package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UtilizaService;
import com.example.demo.entity.Utiliza;

@RestController
@RequestMapping("/uso")
public class UtilizaController {
    @Autowired
    UtilizaService us;

    //localhost:8080/trazapp/uso?id=2
	@GetMapping
	public Utiliza getUsos(@RequestParam Long id) {
		return us.getUso(id);
	}
	@GetMapping("/receta")
	public List<Utiliza> usosDeUnaReceta(@RequestParam Long id) {
		return us.usosDeUnaReceta(id);
	}

    @PostMapping
	public ResponseEntity<?> altaUso(@RequestBody Utiliza r) {
		Utiliza uso = us.saveOrUpdateUso(r);
		return new ResponseEntity("Uso dado de alta correctamente", HttpStatus.OK);
	}
}
