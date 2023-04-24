package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Consume;

public interface ConsumeService {

	public Consume getConsumo(Long id);
	public List<Consume> obtenerTodosConsumos();
	public List<Consume> obtenerConsumosLoteProd(String loteProd);
	public Consume saveOrUpdateConsumo(Consume c);
	public void deleteConsumo(Long idConsumo);

}
