package com.ejemplo.demo.api.controller;



import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.api.generated.CategoriasApi;
import com.ejemplo.demo.api.generated.model.CategoriaRequest;
import com.ejemplo.demo.domain.entity.Categoria;
import com.ejemplo.demo.domain.service.CategoriaService;


@RestController
public class CategoriaController implements CategoriasApi{
	private final CategoriaService categoriaService;

	public CategoriaController (CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	 @Override
	    public ResponseEntity listarCategorias() {
	        return ResponseEntity.ok(categoriaService.findAll());
	    }

	    @Override
	    public ResponseEntity obtenerCategoria(Long id) {
	        return ResponseEntity.ok(categoriaService.findById(id));
	    }
	    @SuppressWarnings("unchecked")
	    @Override
	    public ResponseEntity crearCategoria(CategoriaRequest categoriaRequest) {
	        Categoria categoria = new Categoria();
	        categoria.setNombre(categoriaRequest.getNombre());
	        categoria.setDescripcion(categoriaRequest.getDescripcion());
	        return ResponseEntity.status(201).body(categoriaService.create(categoria));
	    }
	    @Override
	    
	    public ResponseEntity actualizarCategoria(Long id, CategoriaRequest categoriaRequest) {
	        Categoria categoria = new Categoria();
	        categoria.setNombre(categoriaRequest.getNombre());
	        categoria.setDescripcion(categoriaRequest.getDescripcion());
	        return ResponseEntity.ok(categoriaService.update(id, categoria));
	    }
	
	    @Override
	    public ResponseEntity<Void> eliminarCategoria(Long id) {
	        categoriaService.delete(id);
	        return ResponseEntity.noContent().build();
	    }
}
