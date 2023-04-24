package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Proveedor;

@Repository
public interface ProveedorRepo extends JpaRepository<Proveedor, Long>{

	@Query(nativeQuery = true, value="select * from proveedor where nombre like %:nombreProveedor%")
	public List<Proveedor> getProveedorPorNombre(@Param("nombreProveedor") String nombreProveedor);
}
