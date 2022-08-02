package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteTO;

public interface IPacienteRepository {

	public void insertar(Paciente paciente);

	public void actualizar(Paciente paciente);

	public Paciente buscarPorId(Integer id);

	public void eliminar(Integer id);

	public Paciente buscarPorCedulaPaciente(String cedula);

	public List<PacienteTO> buscarPorFechaGenero(LocalDateTime fechaNacimiento, String genero);

}
