package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Producto;

public interface ProductoService{

	public Producto getProducto(Long idProducto);
	public List<Producto> getProductosPorNombre(String nombre);
	public Producto getProductoPorNombre(String nombre);
	public List<Producto> getProductoPorTipo(String tipo);
	public List<Producto> getTodosProducto();
	public List<Producto> productosQueConsumeUnaReceta(Long idReceta);
	public Producto saveOrUpdateProducto(Producto p);
	public void deleteProducto(Long idProducto);
}
