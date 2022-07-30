package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Paciente;

public interface IPacienteRepository {

	public void insertar(Paciente paciente);
	public void actualizar(Paciente paciente);
	public Paciente buscarPorId(Integer id);
	public void eliminar(Integer id);
	public Paciente buscarPorCedulaPaciente(String cedula);

}
