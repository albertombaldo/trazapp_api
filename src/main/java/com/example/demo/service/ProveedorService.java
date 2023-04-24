package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Proveedor;

public interface ProveedorService {

	public Proveedor getProveedor(Long idProveedor);
	public List<Proveedor> getProveedorPorNombre(String nombreProveedor);
	public List<Proveedor> getAllProveedor();
	public void deleteProveedor(Long idProveedor);
	public Proveedor saveOrUpdateProveedor(Proveedor p);
}
