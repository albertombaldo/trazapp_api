package com.example.demo.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Receta;
import com.example.demo.repository.UtilizaRepo;
import com.example.demo.repository.RecetaRepo;
import com.example.demo.service.RecetaService;

@Service
@Transactional
public class RecetaServiceImp implements RecetaService{

	@Autowired
	RecetaRepo rr;

	@Override
	public Receta getReceta(Long id) {
		return rr.findById(id).orElse(null);
	}

	@Override
	public void deleteReceta(Long id) {
		rr.deleteById(id);
	}

	@Override
	public List<Receta> getAllRecetas() {
		return rr.findAll();
	}

	@Override
	public List<Receta> recetasQueConsumenUnaMP(Long idMP) {
		return rr.recetasQueConsumenUnaMP(idMP);
	}

	@Override
	public Receta saveOrUpdateReceta(Receta r) {
		return rr.save(r);
	}

	@Override
	public List<Receta> getRecetasPorNombre(String nombre) {
		return rr.getRecetasPorNombre(nombre);
	}
}
