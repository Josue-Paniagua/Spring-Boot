package com.ejemplo.demo.api.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ejemplo.demo.domain.service.PrestamoService;

@Import (PrestamoService.class)
@WebMvcTest(SimulacionController.class)

public class SimuladorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("debe simular ")
	void casoExito() throws Exception{
		mockMvc.perform(post("/api/v1/simulaciones/prestamo")
		.contentType(MediaType.APPLICATION_JSON)
    	.content("{\"monto\":10000,\"tasaAnual\":24,\"meses\":12}"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.cuotaMensual").value(945.5959662295144));
		
	}
	
	  @Test
	    @DisplayName("Debe de dar erro 400")
	    void casoInvalido() throws Exception{
	    	mockMvc.perform(post("/api/v1/simulaciones/prestamo")
	    	.contentType(MediaType.APPLICATION_JSON)
	    	.content("{\"monto\":-121,\"tasaAnual\":24,\"meses\":24}"))
	        .andExpect(status().isBadRequest())
	        .andExpect(jsonPath("$.codigo").value("VALIDATION_ERROR"));
	    }
}
