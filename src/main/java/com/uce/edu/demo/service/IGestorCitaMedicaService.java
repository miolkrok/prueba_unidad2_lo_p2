package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.CitaMedicaTO;
import com.uce.edu.demo.repository.modelo.PacienteTO;

public interface IGestorCitaMedicaService {

	public void agendamientoCita(String numeroTurno, LocalDateTime fechaCita, BigDecimal costoCita, String lugarCita,
			String cedulaDoc, String cedulaPaci);

	public void actualizacionCita(String numeroTurno, String diagnostico, String receta, LocalDateTime fechaControl);

	public List<CitaMedicaTO> reporteCitas(LocalDateTime fechaCita, BigDecimal costoCita);

	public List<PacienteTO> buscarPorFechaGenero(LocalDateTime fechaNacimiento, String genero);
}
