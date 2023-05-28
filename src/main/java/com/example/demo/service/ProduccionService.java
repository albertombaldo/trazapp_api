package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.Produccion;

public interface ProduccionService {

	public Produccion getProduccion(Long lote);
	public List<Produccion> getAllProducciones();
	public List<Produccion> getProduccionesPorFecha(Date fecha);
	public List<Produccion> getProduccionesPorProductoFinal(Long idpf);
	public List<Produccion> produccionesDeUnProductoPorFechaAsc(Long idpf);
	public void deleteProduccion(Long id);
	public Produccion saveOrUpdatePorduccion(Produccion p);
	
}
