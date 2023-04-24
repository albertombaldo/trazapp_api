package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Utiliza;

public interface UtilizaService {

	public Utiliza saveOrUpdateUso(Utiliza u);
	public void deleteUso(Utiliza u);
	public List<Utiliza> obtenerTodosUsos();
	
}
