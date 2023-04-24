package com.example.demo.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepo;
import com.example.demo.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService{

	@Autowired
	ClienteRepo cr;
	
	@Override
	public Cliente getCliente(Long id) {
		return cr.findById(id).orElse(null);
	}

	@Override
	public List<Cliente> getAllClientes() {
		return cr.findAll();
	}

	@Override
	public void deleteCliente(Long id) {
		cr.deleteById(id);
	}

	@Override
	public Cliente saveOrUpdateCliente(Cliente c) {
		return cr.save(c);
	}

	@Override
	public List<Cliente> getClientesPorNombre(String nombre) {
		return cr.getClientePorNombre(nombre);
	}

}
