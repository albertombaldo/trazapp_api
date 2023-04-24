package com.example.demo.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Consume;
import com.example.demo.repository.ConsumeRepo;
import com.example.demo.service.ConsumeService;

@Service
@Transactional
public class ConsumeServiceImp implements ConsumeService{

	@Autowired
	private ConsumeRepo cr;
	
	@Override
	public Consume getConsumo(Long id) {
		return cr.findById(id).orElse(null);
	}

	@Override
	public List<Consume> obtenerTodosConsumos() {
		return cr.findAll();
	}

	@Override
	public List<Consume> obtenerConsumosLoteProd(String loteProd) {
		return cr.obtenerConsumosLoteProd(loteProd);
	}

	@Override
	public Consume saveOrUpdateConsumo(Consume c) {
		return cr.save(c);
	}

	@Override
	public void deleteConsumo(Long idConsumo) {
		cr.deleteById(idConsumo);
	}

}
