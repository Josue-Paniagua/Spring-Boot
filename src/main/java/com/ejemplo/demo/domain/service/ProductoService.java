package com.ejemplo.demo.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.domain.entity.Producto;
import com.ejemplo.demo.domain.repository.ProductoRepository;

@Service 
public class ProductoService {
	private final ProductoRepository repository;
	public ProductoService (ProductoRepository repository) {
		this.repository = repository;
	}
	public Producto  create (Producto producto) {
		return repository.save(producto);		
	}

		public List<Producto> findAll(){
			return repository.findAll();
		}
		
		public Producto findById(Long id) {
			return repository.findById(id).orElse(null);
		}
		public Producto update (Long id, Producto producto ) {
			Producto existe = findById(id);
			if (existe == null)
			{
				throw new RuntimeException("El prpducto no fue encontrado");
				
			}			
			return repository.save(producto);
			
		}
		public void delete (Long id ) {
			Producto existe = findById(id);
			if( existe == null) {
				throw new RuntimeException("EL producto no fue encontrado "); 
			}
			repository.deleteById(id);
			
		}
}
