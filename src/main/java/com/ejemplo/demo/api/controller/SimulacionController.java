package com.ejemplo.demo.api.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.demo.api.dto.PrestamoRequest;
import com.ejemplo.demo.api.dto.PrestamoResponse;
import com.ejemplo.demo.api.generated.SimulacionesApi;
import com.ejemplo.demo.domain.service.PrestamoService;

import jakarta.validation.Valid;


@RestController

public class SimulacionController implements SimulacionesApi {
	
	 private final PrestamoService prestamoService;
	 

	    public SimulacionController(PrestamoService prestamoService) {
	        this.prestamoService = prestamoService;}

	    @Override
	    public ResponseEntity simularPrestamo(com.ejemplo.demo.api.generated.model.PrestamoRequest prestamoRequest) {
	    	PrestamoRequest request = new PrestamoRequest(
	    			prestamoRequest.getMonto(),
	    			prestamoRequest.getTasaAnual(),
	    			prestamoRequest.getPlazoMeses());
	    			
		   return ResponseEntity.ok(prestamoService.calcular(request));
	   }
	  
}
	