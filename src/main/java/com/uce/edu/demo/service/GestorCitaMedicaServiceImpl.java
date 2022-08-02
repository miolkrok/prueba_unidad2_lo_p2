package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICitaMedicaRepository;
import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IPacienteRepository;
import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.CitaMedicaTO;
import com.uce.edu.demo.repository.modelo.PacienteTO;

@Service
public class GestorCitaMedicaServiceImpl implements IGestorCitaMedicaService {

	@Autowired
	private IPacienteRepository pacienteRepository;

	@Autowired
	private IDoctorRepository doctorRepository;

	@Autowired
	private ICitaMedicaRepository citaMedicaRepository;

	@Override
	public void agendamientoCita(String numeroTurno, LocalDateTime fechaCita, BigDecimal costoCita, String lugarCita,
			String cedulaDoc, String cedulaPaci) {
		// TODO Auto-generated method stub
		CitaMedica cime = new CitaMedica();
		cime.setNumero(numeroTurno);
		cime.setFechaCita(fechaCita);
		cime.setCostoCita(costoCita);
		cime.setLugarCita(lugarCita);
		cime.setDoctor(this.doctorRepository.buscarPorCedulaDoctor(cedulaDoc));
		cime.setPaciente(this.pacienteRepository.buscarPorCedulaPaciente(cedulaPaci));
		this.citaMedicaRepository.insertar(cime);
	}

	@Override
	public void actualizacionCita(String numeroTurno, String diagnostico, String receta, LocalDateTime fechaControl) {
		// TODO Auto-generated method stub
		CitaMedica actcime = this.citaMedicaRepository.buscarPorNumero(numeroTurno);
		actcime.setDiagnostico(diagnostico);
		actcime.setReceta(receta);
		actcime.setFechaControl(fechaControl);
		this.citaMedicaRepository.actualizar(actcime);
	}

	@Override
	public List<CitaMedicaTO> reporteCitas(LocalDateTime fechaCita, BigDecimal costoCita) {
		// TODO Auto-generated method stub
		return this.citaMedicaRepository.reporteCitas(fechaCita, costoCita);
	}

	@Override
	public List<PacienteTO> buscarPorFechaGenero(LocalDateTime fechaNacimiento, String genero) {
		// TODO Auto-generated method stub
		return this.pacienteRepository.buscarPorFechaGenero(fechaNacimiento, genero);
	}

}
