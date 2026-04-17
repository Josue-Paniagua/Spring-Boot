package com.ejemplo.demo.domain.entity;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Entity
@Table (name = "categorias")
public class Categoria {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable = false)
	private String nombre;
	@Column(length = 255)
	private String descripcion;
	@Column (name= "creado_en", updatable = false)
	private Instant creadoEn;
	@Column (name= "actualizado_en ")
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
	

	
	@OneToMany (mappedBy = "categoria")
	private List<Producto> productos = new ArrayList<>();
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
		
	}
	public List<Producto> getProductos(){
		return productos;
	}
	public void setProducto (List<Producto> productos) {
		this.productos = productos;

	}
	
	}

