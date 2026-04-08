package com.ejemplo.demo.domain.service;


import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.ejemplo.demo.api.dto.PrestamoRequest;
import com.ejemplo.demo.api.dto.PrestamoResponse;

@Service 
public class PrestamoService {


	

	public PrestamoResponse calcular (PrestamoRequest request) {
	
		double monto = request.monto().doubleValue();
		double tasaAnual = request.tasaAnual().doubleValue();
		int meses = request.meses();
		
		double r = tasaAnual/12/100;
		
		double factor = Math.pow(1 + r, meses);
		double cuota = monto * (r * factor)/ (factor -1);
		
		double totalPagar = cuota* meses;
		double interesTotal = totalPagar - monto;
		
		System.out.println("El monto total a pagar es de: " + totalPagar);
		System.out.println("/nCon un interes aumentado de: " + interesTotal);
		
	return new PrestamoResponse(
			BigDecimal.valueOf(cuota),
			BigDecimal.valueOf(interesTotal),
			BigDecimal.valueOf(totalPagar)
			
			); 
		
	}
}

