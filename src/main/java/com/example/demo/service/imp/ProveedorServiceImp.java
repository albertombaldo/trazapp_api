package com.example.demo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Proveedor;
import com.example.demo.repository.ProveedorRepo;
import com.example.demo.service.ProveedorService;

@Service
public class ProveedorServiceImp implements ProveedorService{

	@Autowired
	ProveedorRepo pr;
	
	@Override
	public Proveedor getProveedor(Long idProveedor) {
		return pr.findById(idProveedor).orElse(null);
	}

	@Override
	public List<Proveedor> getAllProveedor() {
		return pr.findAll();
	}

	@Override
	public void deleteProveedor(Long idProveedor) {
		pr.deleteById(idProveedor);
	}

	@Override
	public Proveedor saveOrUpdateProveedor(Proveedor p) {
		return pr.save(p);
	}

	@Override
	public List<Proveedor> getProveedorPorNombre(String nombreProveedor) {
		return pr.getProveedorPorNombre(nombreProveedor);
	}

}
