package com.example.demo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ProductoFinal;
import com.example.demo.repository.ProductoFinalRepo;
import com.example.demo.service.ProductoFinalService;

@Service
public class ProductoFinalServiceImp implements ProductoFinalService{

	@Autowired
	ProductoFinalRepo pfr;
	
	@Override
	public ProductoFinal getProductoFinal(Long id) {
		return pfr.findById(id).orElse(null);
	}

	@Override
	public ProductoFinal getProductoFinalPorNombre(String nombre) {
		return pfr.getProductoFinalPorNombre(nombre);
	}

	@Override
	public List<ProductoFinal> getProductosFinalesPorNombre(String nombre) {
		return pfr.getProductosFinalesPorNombre(nombre);
	}

	@Override
	public List<ProductoFinal> getAllProductoFinal() {
		return pfr.findAll();
	}

	@Override
	public void deleteProductoFinal(Long id) {
		pfr.deleteById(id);
	}

	@Override
	public ProductoFinal saveOrUpdateProductoFinal(ProductoFinal pf) {
		return pfr.save(pf);
	}

	
}
