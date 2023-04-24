package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Consume;

@Repository
public interface ConsumeRepo extends JpaRepository<Consume, Long>{

	@Query(nativeQuery=true, value="select * from consume where lote_produccion = :loteProd")
	public List<Consume> obtenerConsumosLoteProd(@Param("loteProd") String loteProd);
}
