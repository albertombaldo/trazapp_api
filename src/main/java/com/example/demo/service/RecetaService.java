package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Receta;

public interface RecetaService {

	public Receta getReceta(Long id);
	public void deleteReceta(Long id);
	public List<Receta> getAllRecetas();
	public List<Receta> recetasQueConsumenUnaMP(Long idMP);
	public List<Receta> getRecetasPorNombre(String nombre);
	public Receta saveOrUpdateReceta(Receta r);
}
