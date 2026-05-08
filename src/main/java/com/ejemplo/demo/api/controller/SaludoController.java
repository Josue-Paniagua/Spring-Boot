package com.ejemplo.demo.api.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;


import com.ejemplo.demo.api.generated.WorkshopApi;
import com.ejemplo.demo.domain.service.SaludoService;


import java.util.Map;

@RestController
public class SaludoController implements WorkshopApi {

@Override
	public ResponseEntity getWorkshopHealth() {
        return ResponseEntity.ok(Map.of(
                "estado", "ok",
                "mensaje", "Workshop Spring Boot activo"
        ));
    }

    /*
    ===========================================
    PASO 2: DESCOMENTA este bloque y prueba GET
    ===========================================

    1) Descomenta imports:
       - com.ejemplo.demo.api.dto.SaludoResponse
       - com.ejemplo.demo.domain.service.SaludoService
       - org.springframework.web.bind.annotation.RequestParam

    2) Descomenta el campo y constructor:
    */

    private final SaludoService saludoService;

    public SaludoController(SaludoService saludoService) {
        this.saludoService = saludoService;
    }
    

//    3) Descomenta este endpoint:
//    


    @Override
    public ResponseEntity saludarPorGet(String nombre) {
        String nombreFinal = nombre != null ? nombre : "Mundo";
        return ResponseEntity.ok(saludoService.crearSaludo(nombreFinal));
    }
    

    /*
    ============================================
    PASO 3: DESCOMENTA este bloque y prueba POST
    ============================================

    1) Descomenta imports:
       - com.ejemplo.demo.api.dto.SaludoRequest
       - jakarta.validation.Validdddd
       - org.springframework.web.bind.annotation.PostMapping
       - org.springframework.web.bind.annotation.RequestBody

    2) Descomenta este endpoint:
*/    
    
    @Override
    public ResponseEntity saludarPorPost(com.ejemplo.demo.api.generated.model.SaludoRequest saludoRequest) {
        return ResponseEntity.ok(saludoService.crearSaludo(saludoRequest.getNombre()));
    }
}
