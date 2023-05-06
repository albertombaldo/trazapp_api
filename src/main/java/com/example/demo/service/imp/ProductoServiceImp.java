package com.example.demo.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepo;
import com.example.demo.repository.SuministraRepo;
import com.example.demo.service.ProductoService;

@Service
@Transactional
public class ProductoServiceImp implements ProductoService{

	@Autowired
	ProductoRepo pr;
	@Autowired
	SuministraRepo sr;
	
	@Override
	public Producto getProducto(Long idProducto) {
		return pr.findById(idProducto).orElse(null);
	}

	@Override
	public List<Producto> getTodosProducto() {
		return pr.findAll();
	}

	@Override
	public Producto saveOrUpdateProducto(Producto p) {
		return pr.save(p);
	}

	@Override
	public void deleteProducto(Long idProducto) {
		//SE eliminan todos las líneas de suministro del producto
		sr.eliminarProducto(idProducto);
		pr.deleteById(idProducto);
	}

	@Override
	public List<Producto> productosQueConsumeUnaReceta(Long idReceta) {
		return pr.productosQueConsumeUnaReceta(idReceta);
	}

	@Override
	public List<Producto> getProductosPorNombre(String nombre) {
		return pr.getProductosPorNombre(nombre);
	}

	@Override
	public Producto getProductoPorNombre(String nombre) {
		return pr.getProductoPorNombre(nombre);
	}

	@Override
	public List<Producto> getProductoPorTipo(String tipo) {
		return pr.getProductoPorTipo(tipo);
	}
}
