package com.example.demo.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Utiliza;
import com.example.demo.repository.UtilizaRepo;
import com.example.demo.service.UtilizaService;

@Transactional
@Service
public class UtilizaServiceImp implements UtilizaService{

	@Autowired
	UtilizaRepo ur;

	@Override
	public Utiliza saveOrUpdateUso(Utiliza c) {
		return ur.save(c);
	}

	@Override
	public Utiliza getUso(Long id) {
		return ur.findById(id).orElse(null);
	}

	@Override
	public void deleteUso(Utiliza u) {
		ur.delete(u);
	}

	@Override
	public List<Utiliza> obtenerTodosUsos() {
		return ur.findAll();
	}

	@Override
	public List<Utiliza> usosDeUnaReceta(Long id_receta) {
		return ur.usosDeUnaReceta(id_receta);
	}

}
