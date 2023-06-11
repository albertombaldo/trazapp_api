package com.example.demo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Envio;
import com.example.demo.repository.EnvioRepo;
import com.example.demo.service.EnvioService;

@Service
public class EnvioServiceImp implements EnvioService{

	@Autowired
	EnvioRepo er;
	
	@Override
	public Envio getEnvio(Long id) {
		return er.findById(id).orElse(null);
	}

	@Override
	public List<Envio> getAllEnvios() {
		return er.findAll();
	}

	@Override
	public List<Envio> getEnviosPorCliente(Long idCliente) {
		return er.getEnviosPorCliente(idCliente);
	}

	@Override
	public List<Envio> getEnviosPorLoteProducto(String lote) {
		return er.getEnviosPorProducto(lote);
	}

	@Override
	public List<Envio> getEnviosPorAlbaran(String albaran) {
		return er.getEnviosPorAlbaran(albaran);
	}

	@Override
	public void deleteEnvio(Long id) {
		er.deleteById(id);
	}

	@Override
	public Envio saveOrUpdateEnvio(Envio e) {
		return er.save(e);
	}

}
