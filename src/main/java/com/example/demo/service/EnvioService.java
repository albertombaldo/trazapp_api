package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Envio;

public interface EnvioService {

	public Envio getEnvio(Long id);
	public List<Envio> getAllEnvios();
	public List<Envio> getEnviosPorCliente(Long idCliente);
	public List<Envio> getEnviosPorLoteProducto(String lote);
	public List<Envio> getEnviosPorAlbaran(String albaran);
	public void deleteEnvio(Long id);
	public Envio saveOrUpdateEnvio(Envio e);
	
}
