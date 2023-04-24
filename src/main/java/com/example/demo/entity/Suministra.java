package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Suministra implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_suministro;
	@Temporal(TemporalType.DATE)
	private Date fecha_recepcion;
	@Temporal(TemporalType.DATE)
	private Date fecha_caducidad;
	@ManyToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")	
	private Proveedor proveedor;
	@ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")	
	private Producto producto;
	private String albaran;
	private float cantidad_recepcionada;
	private float cantidad_stock;
	private String lote_producto;
}
