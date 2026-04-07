package com.ejemplo.demo.domain.service;

import com.ejemplo.demo.api.dto.SaludoResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class SaludoService {

    public SaludoResponse crearSaludo(String nombre) {
        String nombreNormalizado = normalizarNombre(nombre);
        String mensaje = "Hola, %s. Bienvenido a Spring Boot 3!".formatted(nombreNormalizado);
        return new SaludoResponse(mensaje, Instant.now());
    }

    /*
    PASO 4 (EJERCICIO):
    - Modifica esta logica para personalizar el formato del nombre.
    - Ideas:
      1) Primera letra mayuscula y resto minuscula.
      2) Rechazar nombres con numeros.
      3) Agregar prefijo "Estudiante".
    */
    String normalizarNombre(String nombre) {
    	if(nombre == null) {
    		return "Mundo";
    }
    	nombre = nombre.trim();
    	if(nombre.isEmpty()) {
    		throw new IllegalArgumentException("EL nombre no puede ir vacio");
    	}
    	if (!nombre.matches("[a-zA-Z ]+")) {
    		throw new IllegalArgumentException( "El nombre solo debe contener letras no numeros");
    	}
    	
    	String parte1 = String.valueOf(nombre.charAt(0)).toUpperCase();
    	String parte2 = nombre.substring(1).toLowerCase();
    	
    	return "Estudiante "+ parte1 + parte2;
}}
