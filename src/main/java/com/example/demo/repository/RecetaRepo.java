package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Receta;

@Repository
public interface RecetaRepo extends JpaRepository<Receta,Long>{

	@Query(nativeQuery = true, value="select * from receta where id_receta in (select id_receta from consume where id_producto = :idMateriaPrima)")
	public List<Receta> recetasQueConsumenUnaMP(@Param("idMateriaPrima") Long idMateriaPrima);
	
	@Query(nativeQuery = true, value="select * from receta where nombre like %:nombre%")
	public List<Receta> getRecetasPorNombre(@Param("nombre") String nombre);
}
