package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="consume", uniqueConstraints = { @UniqueConstraint(columnNames = {"lote_produccion", "id_suministro"})})
@NoArgsConstructor
@AllArgsConstructor
public class Consume implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id_consumo;
	@ManyToOne
	@JoinColumn(name = "lote_produccion", referencedColumnName = "lote_produccion")
	private Produccion produccion;
	@ManyToOne
	@JoinColumn(name = "id_suministro", referencedColumnName = "id_suministro")
	private Suministra suministro;
	private float cantidad;
}
