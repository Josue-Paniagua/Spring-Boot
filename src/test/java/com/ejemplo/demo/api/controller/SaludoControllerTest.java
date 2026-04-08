package com.ejemplo.demo.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ejemplo.demo.domain.service.SaludoService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SaludoService.class)
@WebMvcTest(SaludoController.class)
class SaludoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Debe responder health del workshop")
    void debeResponderHealthDelWorkshop() throws Exception {
        mockMvc.perform(get("/api/v1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estado").value("ok"));
    }

    /*
    PASO 6 (EJERCICIO):
    Cuando habilites los endpoints de /api/v1/saludos, crea estas pruebas:

    1) GET /api/v1/saludos?nombre=Ana -> 200 y mensaje correcto
    2) POST /api/v1/saludos con {"nombre":""} -> 400 y codigo VALIDATION_ERROR

    */
    @Test
    @DisplayName(  "Debe responder el saludo con nombre Ana")
    void getApi() throws Exception{
    	mockMvc.perform(get("/api/v1/saludos?nombre=Ana"))
    	.andExpect(status().isOk())
    	.andExpect(jsonPath("$.mensaje").value("Hola, Estudiante Ana. Bienvenido a Spring Boot 3!"));
    }
    @Test
    @DisplayName("Debe de dar erro 400")
    void postApi() throws Exception{
    	mockMvc.perform(post("/api/v1/saludos")
    	.contentType(MediaType.APPLICATION_JSON)
    	.content("{\"nombre\":\"\"}"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.codigo").value("VALIDATION_ERROR"));
    }
}

	