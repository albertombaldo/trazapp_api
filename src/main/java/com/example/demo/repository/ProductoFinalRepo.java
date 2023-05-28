package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductoFinal;

import java.util.List;

@Repository
public interface ProductoFinalRepo extends JpaRepository<ProductoFinal, Long>{
    @Query(nativeQuery = true, value="select * from producto_final where nombre = :nombre")
    public ProductoFinal getProductoFinalPorNombre(@Param("nombre")String nombre);

    @Query(nativeQuery = true, value="select * from producto_final where like = '%:nombre%'")
    public List<ProductoFinal> getProductosFinalesPorNombre(@Param("nombre")String nombre);
}
