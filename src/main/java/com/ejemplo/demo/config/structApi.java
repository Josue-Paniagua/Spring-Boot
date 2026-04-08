package com.ejemplo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class structApi {
@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
		.info(new Info()
				.title("Mi primer spring boot")
				.version("1.0")
				.description("MI primer API con spring boot")
				.contact(new Contact()
				.name("Josue Paniagua")
				.email("jpaniaguao@miumg.edu.gt")));
	}
	
}
 