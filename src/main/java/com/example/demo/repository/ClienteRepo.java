package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Long>{

	@Query(nativeQuery = true, value="select * from cliente where nombre like %:nombre%")
	public List<Cliente> getClientePorNombre(@Param("nombre")String nombre);
}
