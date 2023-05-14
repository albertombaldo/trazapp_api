package com.example.demo.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Suministra;
import com.example.demo.repository.SuministraRepo;
import com.example.demo.service.SuministraService;

@Service
@Transactional
public class SuministraServiceImp implements SuministraService{

	@Autowired
	SuministraRepo sr;
	
	@Override
	public Suministra getSuministro(Long idSuministra) {
		return sr.findById(idSuministra).orElse(null);
	}

	@Override
	public List<Suministra> getTodosSuministros() {
		return sr.findAll();
	}

	@Override
	public void deleteSuministro(Long idSuministra) {
		sr.deleteById(idSuministra);
	}

	@Override
	public List<Suministra> getSuministrosPorAlbaran(String albaran) {
		return sr.obtenerProductosAlbaran(albaran);
	}

	@Override
	public List<Suministra> getSuministrosPorProductoYFechaAsc(Long id_producto) {
		return sr.getSuministrosPorProductoYFechaAsc(id_producto);
	}

	@Override
	public Suministra saveOrUpdateSuministro(Suministra s) {
		return sr.save(s);
	}

	@Override
	public void deleteAlbaran(String albaran) {
		sr.eliminarAlbaran(albaran);
	}

	@Override
	public void actualizarStock(Long idSuministro, float cantidad) {
		sr.modificarStock(idSuministro, cantidad);
	}

}
