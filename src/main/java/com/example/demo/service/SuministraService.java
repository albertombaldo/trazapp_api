package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Suministra;

public interface SuministraService {

	public Suministra getSuministro(Long idSuministra);
	public List<Suministra> getTodosSuministros();
	public void deleteSuministro(Long idSuministra);
	public void deleteAlbaran(String albaran);
	public List<Suministra> getSuministrosPorAlbaran(String albaran);
	public List<Suministra> getSuministrosPorProductoYFechaAsc(Long id_producto);
	public Suministra saveOrUpdateSuministro(Suministra s);
	public void actualizarStock(Long idSuministro, float cantidad);
}
