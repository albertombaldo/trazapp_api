package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Suministra;

@Repository
public interface SuministraRepo extends JpaRepository<Suministra, Long>{

	@Query(nativeQuery = true, value="select * from suministra where albaran = :albaran")
	public List<Suministra> obtenerProductosAlbaran(@Param("albaran") String albaran);
	
	@Modifying
	@Query(nativeQuery = true, value="delete from suministra where albaran = :albaran")
	public void eliminarAlbaran(@Param("albaran") String albaran);
	
	@Modifying
	@Query(nativeQuery = true, value="delete from suministra where id_producto = :idProducto")
	public void eliminarProducto(@Param("idProducto") Long idProducto);
	
	@Modifying
	@Query(nativeQuery = true, value="update suministra set cantidad_stock = :cantidad where id_suministro = :suministro")
	public void modificarStock(@Param("suministro") Long suministro, @Param("cantidad") float cantidad);
}
