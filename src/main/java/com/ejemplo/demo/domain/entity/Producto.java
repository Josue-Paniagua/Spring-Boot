package com.ejemplo.demo.domain.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;

@Entity 
@Table (name = "productos")

public class Producto {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (nullable = false)
	private String nombre;
	
	@DecimalMin("0.0")
	@Column (nullable = false )
	private double  precio;
	@Column (name= "creado_en", updatable = false)
	private Instant creadoEn;
	@Column (name= "actualizado_en")
	private Instant actualizadoEn;
	@PrePersist 
	void antedDeInsertar() {
		creadoEn = Instant.now();
		actualizadoEn = Instant.now();
		}
	
		
		@PreUpdate
		void antesDeActualizar()
		{
			actualizadoEn = Instant.now();
		}		
	

	@ManyToOne 
	private Categoria categoria;	

public Long getId() {
	return id;
}

public String getNombre() {
	return nombre;
}
public void setId(Long id) {
	this.id = id;
	
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double  precio) {
	this.precio = precio;
}
public Categoria getCategoria() {
	return categoria;
}
public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}

}