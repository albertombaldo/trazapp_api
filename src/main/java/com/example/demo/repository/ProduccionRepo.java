package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Produccion;

@Repository
public interface ProduccionRepo extends JpaRepository<Produccion, Long>{

	@Query(nativeQuery = true, value="select * from produccion where fecha_produccion = :fecha")
	public List<Produccion> produccionesDeUnaFecha(@Param("fecha") Date fecha);
	
	@Query(nativeQuery = true, value="select * from produccion where producto_final = :idProd")
	public List<Produccion> produccionesDeUnProducto(@Param("idProd") Long idProd);
	
}
