package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Utiliza;

import java.util.List;

@Repository
public interface UtilizaRepo extends JpaRepository<Utiliza, Long>{
    @Query(nativeQuery = true, value="select * from utiliza where id_receta = :idReceta")
    public List<Utiliza> usosDeUnaReceta(@Param("idReceta")Long idReceta);
}
