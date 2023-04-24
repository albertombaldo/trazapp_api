package com.example.demo.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Produccion;
import com.example.demo.repository.ProduccionRepo;
import com.example.demo.service.ProduccionService;

@Service
public class ProduccionServiceImp implements ProduccionService{

	@Autowired
	ProduccionRepo pr;
	
	@Override
	public Produccion getProduccion(Long lote) {
		return pr.findById(lote).orElse(null);
	}

	@Override
	public List<Produccion> getAllProducciones() {
		return pr.findAll();
	}

	@Override
	public List<Produccion> getProduccionesPorFecha(Date fecha) {
		return pr.produccionesDeUnaFecha(fecha);
	}

	@Override
	public List<Produccion> getProduccionesPorProductoFinal(Long idpf) {
		return pr.produccionesDeUnProducto(idpf);
	}

	@Override
	public void deleteProduccion(Long id) {
		pr.deleteById(id);
	}

	@Override
	public Produccion saveOrUpdatePorduccion(Produccion p) {
		return pr.save(p);
	}

}
