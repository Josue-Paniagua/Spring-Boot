package com.ejemplo.demo.api.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.api.dto.PrestamoRequest;
import com.ejemplo.demo.api.dto.PrestamoResponse;
import com.ejemplo.demo.domain.service.PrestamoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/simulaciones")

public class SimulacionController {
	
	 private final PrestamoService prestamoService;
	 

	    public SimulacionController(PrestamoService prestamoService) {
	        this.prestamoService = prestamoService;}
	
	   @PostMapping("/prestamo")
	    public ResponseEntity<PrestamoResponse> simular(@Valid @RequestBody PrestamoRequest request) {
		   return ResponseEntity.ok(prestamoService.calcular(request));
	   }
	  
}
	