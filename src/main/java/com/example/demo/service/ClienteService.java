package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cliente;

public interface ClienteService {

	public Cliente getCliente(Long id);
	public List<Cliente> getAllClientes();
	public List<Cliente> getClientesPorNombre(String nombre);
	public void deleteCliente(Long id);
	public Cliente saveOrUpdateCliente(Cliente c);
}
