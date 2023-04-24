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
	UtilizaRepo cr;
	
	
	@Override
	public Utiliza saveOrUpdateUso(Utiliza c) {
		return cr.save(c);
	}

	@Override
	public void deleteUso(Utiliza u) {
		cr.delete(u);
	}

	@Override
	public List<Utiliza> obtenerTodosUsos() {
		return cr.findAll();
	}

}
