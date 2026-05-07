package com.ejemplo.demo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.api.generated.ProductosApi;
import com.ejemplo.demo.domain.entity.Producto;
import com.ejemplo.demo.domain.service.ProductoService;

@RestController

public class ProductoController implements ProductosApi{
	private final ProductoService productoService;
	
	public ProductoController (ProductoService productoService) {
		this.productoService = productoService;
		
	}
	
	@Override
	public ResponseEntity listarProductos() {
	    return ResponseEntity.ok(productoService.findAll());
	}

	@Override
	public ResponseEntity obtenerProducto(Long id) {
	    return ResponseEntity.ok(productoService.findById(id));
	}

	@Override
	public ResponseEntity crearProducto(com.ejemplo.demo.api.generated.model.ProductoRequest productoRequest) {
	    Producto producto = new Producto();
	    producto.setNombre(productoRequest.getNombre());
	    producto.setPrecio(productoRequest.getPrecio().doubleValue());
	    return ResponseEntity.status(201).body(productoService.create(producto));
	}

	@Override
	public ResponseEntity actualizarProducto(Long id, com.ejemplo.demo.api.generated.model.ProductoRequest productoRequest) {
	    Producto producto = new Producto();
	    producto.setNombre(productoRequest.getNombre());
	    producto.setPrecio(productoRequest.getPrecio().doubleValue());
	    return ResponseEntity.ok(productoService.update(id, producto));
	}

	@Override
	public ResponseEntity<Void> eliminarProducto(Long id) {
	    productoService.delete(id);
	    return ResponseEntity.noContent().build();
	}
}
