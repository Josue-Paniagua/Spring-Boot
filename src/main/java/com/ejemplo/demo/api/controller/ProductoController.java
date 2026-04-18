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

import com.ejemplo.demo.domain.entity.Producto;
import com.ejemplo.demo.domain.service.ProductoService;

@RestController
@RequestMapping("/api/v1/productos")

public class ProductoController {
	private final ProductoService productoService;
	
	public ProductoController (ProductoService productoService) {
		this.productoService = productoService;
		
	}
	
	@GetMapping
	public ResponseEntity<List<Producto>> findAll(){
		return ResponseEntity.ok(productoService.findAll());
	}
	@GetMapping ("/{id}")
	public ResponseEntity<Producto> findById(@PathVariable Long id){
		return ResponseEntity.ok(productoService.findById(id));
	}
	@PostMapping
	public ResponseEntity<Producto> create (@RequestBody Producto producto){
		return ResponseEntity.status(201).body(productoService.create(producto));
	}
	@PutMapping ("/{id}")
	public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto){
		return ResponseEntity.ok(productoService.update(id, producto));
		
	}
	@DeleteMapping ("/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		productoService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
