package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductoFinal;

public interface ProductoFinalService {

	public ProductoFinal getProductoFinal(Long id);
	public List<ProductoFinal> getAllProductoFinal();
	public void deleteProductoFinal(Long id);
	public ProductoFinal saveOrUpdateProductoFinal(ProductoFinal pf);
	
}
