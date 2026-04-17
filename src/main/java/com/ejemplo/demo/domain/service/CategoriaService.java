package com.ejemplo.demo.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.domain.entity.Categoria;
import com.ejemplo.demo.domain.repository.CategoriaRepository;

@Service

public class CategoriaService {
	private final CategoriaRepository repository ;
	
	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}
	public Categoria  create(Categoria categoria) {
		return repository.save(categoria);
	}
		public List<Categoria> findAll(){
			return repository.findAll();
			
		}
		public Categoria findById(Long id) {
			return repository.findById(id).orElse(null);
			
			
		}


	public Categoria update(Long id, Categoria categoria) {
Categoria existente = findById(id);
if(existente ==null) {
	throw new RuntimeException("La categoria no fue encontrada");
}
		return repository.save(categoria);		
	}
	
	
	public void  delete(Long id) {
		Categoria existe= findById(id);
		if(existe == null) {
		throw new RuntimeException("La categoria no fue encontrada");
		}
		 repository.deleteById(id);

	}
}
