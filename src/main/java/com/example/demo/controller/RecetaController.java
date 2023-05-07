package com.example.demo.controller;

import java.util.ArrayList;
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

import com.example.demo.entity.Receta;
import com.example.demo.entity.Utiliza;
import com.example.demo.service.RecetaService;
import com.example.demo.service.UtilizaService;

@RestController
@RequestMapping("/receta")
public class RecetaController {

	@Autowired 
	RecetaService rs;
	@Autowired 
	UtilizaService us;
	
	//localhost:8080/trazapp/receta?id=2
	@GetMapping
	public Receta getReceta(@RequestParam Long id) {
		return rs.getReceta(id);	
	}
	//localhost:8080/trazapp/receta/arepa
	@GetMapping("/{nombre}")
	public List<Receta> getRecetasPorNombre(@PathVariable String nombre) {
		return rs.getRecetasPorNombre(nombre);	
	}
	@GetMapping("/nombre/{nombre}")
	public Receta getRecetaPorNombre(@PathVariable String nombre) {
		return rs.getRecetaPorNombre(nombre);
	}
	
	@GetMapping("/")
	public List<Receta> getTodasRecetas() {
		return rs.getAllRecetas();	
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteReceta(@RequestParam Long id){
		Receta r = rs.getReceta(id);
		for(Utiliza c : r.getMaterias_primas()) {
			us.deleteUso(c);
		}
		rs.deleteReceta(id);
		return new ResponseEntity("Receta eliminada correctamente", HttpStatus.OK);
	}
	
	/*{
    "id_receta": 0,
    "nombre": "Pan Integral",
    "materias_primas": [
        {
            "producto": {
                "id_producto": 1,
                "nombre": "Harina de trigo",
                "tipo": "MP"
            },
            "cantidad": 700.0
        },
        {
            "producto": {
                "id_producto": 2,
                "nombre": "Harina de trigo integral",
                "tipo": "MP"
            },
            "cantidad": 100.0
        },
        {
            "producto": {
                "id_producto": 3
            },
            "cantidad": 2.5
        }
    ]
	}*/
	//localhost:8080/trazapp/recet
	@PostMapping
	public ResponseEntity<?> altaReceta(@RequestBody Receta r) {
		Receta alta = rs.saveOrUpdateReceta(r);
		List<Utiliza> consumos = new ArrayList();
		for(Utiliza c : r.getMaterias_primas()) {
			c.setReceta(alta);
			consumos.add(c);
			us.saveOrUpdateUso(c);
		}
		alta.setMaterias_primas(consumos);
		rs.saveOrUpdateReceta(alta);
		return new ResponseEntity("Receta dada de alta correctamente", HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> modificarReceta(@RequestBody Receta r) {
		rs.saveOrUpdateReceta(r);
		return new ResponseEntity("Receta modificada correctamente", HttpStatus.OK);
	}
	
}
