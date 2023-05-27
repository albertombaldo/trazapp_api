package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Produccion implements Serializable{

	@Id
	private Long lote_produccion;
	@ManyToOne
	@JoinColumn(name = "producto_final", referencedColumnName = "id_producto_final")
	private ProductoFinal producto_final;
	private Date fecha_produccion;
	private Date fecha_caducidad;
	private Long unidades;
	private Long stock;
}
