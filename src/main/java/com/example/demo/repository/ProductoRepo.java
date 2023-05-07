package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Producto;

@Repository
public interface ProductoRepo extends JpaRepository<Producto, Long>{

	@Query(nativeQuery = true, value="select * from producto where id_producto in (select id_producto from utiliza where id_receta = :idReceta)")
	public List<Producto> productosQueConsumeUnaReceta(@Param("idReceta")Long idReceta);
	
	@Query(nativeQuery = true, value="select * from producto where nombre like %:nombre%")
	public List<Producto> getProductosPorNombre(@Param("nombre")String nombre);

	@Query(nativeQuery = true, value="select * from producto where nombre = :nombre")
	public Producto getProductoPorNombre(@Param("nombre")String nombre);
	
	@Query(nativeQuery = true, value="select * from producto where tipo = :tipo")
	public List<Producto> getProductoPorTipo(@Param("tipo")String tipo);
	
}
