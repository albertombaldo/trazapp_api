package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="envio", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_producto_final", "id_cliente", "albaran", "lote"})})
@NoArgsConstructor
@AllArgsConstructor
public class Envio implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_envio;
	@ManyToOne
    @JoinColumn(name = "id_producto_final", referencedColumnName = "id_producto_final")	
	private ProductoFinal producto;
	@ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")	
	private Cliente cliente;
	private Date fechaEnvio;
	private Float cantidad;
	private String lote;
	private String albaran;
}
