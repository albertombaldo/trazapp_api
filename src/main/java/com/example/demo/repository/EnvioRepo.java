package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Envio;

@Repository
public interface EnvioRepo extends JpaRepository<Envio, Long>{

	@Query(nativeQuery = true, value="select * from envio where id_cliente = :idCliente")
	public List<Envio> getEnviosPorCliente(@Param("idCliente")Long idCliente);
	
	@Query(nativeQuery = true, value="select * from envio where lote = :lote")
	public List<Envio> getEnviosPorProducto(@Param("lote")String lote);

	@Query(nativeQuery = true, value="select * from envio where albaran = :albaran")
	public List<Envio> getEnviosPorAlbaran(@Param("albaran")String albaran);
	
}
