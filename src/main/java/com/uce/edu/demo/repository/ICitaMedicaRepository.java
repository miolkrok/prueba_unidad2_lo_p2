package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.CitaMedicaTO;

public interface ICitaMedicaRepository {

	public void insertar(CitaMedica citaMedica);
	
	public void actualizar(CitaMedica citaMedica);
	
	public CitaMedica buscarPorNumero(String numeroTurno);
	
	public List<CitaMedicaTO> reporteCitas(LocalDateTime fechaCita, BigDecimal costoCita);
	
}
