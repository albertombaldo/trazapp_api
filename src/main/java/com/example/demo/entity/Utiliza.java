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
@Table(name="utiliza", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_receta", "id_producto"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utiliza implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_uso;
	
	@ManyToOne
    @JoinColumn(name = "id_receta", referencedColumnName = "id_receta")	
	private Receta receta;
	
	@ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")	
	private Producto producto;

	private float cantidad_mp;
}
