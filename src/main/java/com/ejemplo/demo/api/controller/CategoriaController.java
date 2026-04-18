package com.ejemplo.demo.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.domain.entity.Categoria;
import com.ejemplo.demo.domain.service.CategoriaService;


@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {
	private final CategoriaService categoriaService;

	public CategoriaController (CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	@GetMapping
	 public ResponseEntity<List<Categoria>> findAll()
	 {
		return ResponseEntity.ok(categoriaService.findAll());
		
	 }	
	@GetMapping ("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		return ResponseEntity.ok(categoriaService.findById(id));
	}
@PostMapping
public ResponseEntity<Categoria> create (@RequestBody Categoria categoria){
	return ResponseEntity.status(201).body(categoriaService.create(categoria));
}
@PutMapping ("/{id}")
public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
	return ResponseEntity.ok(categoriaService.update(id, categoria));
	
}
@DeleteMapping ("/{id}")
public ResponseEntity delete(@PathVariable Long id) {
	categoriaService.delete(id);
	return ResponseEntity.noContent().build();
	
}
}
