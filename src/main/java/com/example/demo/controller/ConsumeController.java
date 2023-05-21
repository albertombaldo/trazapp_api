package com.example.demo.controller;

import com.example.demo.entity.Consume;
import com.example.demo.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumo")
public class ConsumeController {

    @Autowired
    ConsumeService cs;

    @GetMapping
    public Consume getConsumo(@RequestParam Long id) {
        return cs.getConsumo(id);
    }

    @GetMapping("/produccion/{loteProd}")
    public List<Consume> obtenerConsumosLoteProd(@PathVariable String loteProd) {
        return cs.obtenerConsumosLoteProd(loteProd);
    }

    @PostMapping
    public ResponseEntity<?> anadirConsumo(@RequestBody Consume c){
        cs.saveOrUpdateConsumo(c);
        return new ResponseEntity("Consumo dado de alta correctamente", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> eliminarConsumo(@RequestParam Long id) {
        cs.deleteConsumo(id);
        return new ResponseEntity("Consumo eliminado correctamente", HttpStatus.OK);
    }
}
