package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.repository.modelo.PacienteTO;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public Paciente buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}

	@Override
	public Paciente buscarPorCedulaPaciente(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> myTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Paciente p WHERE p.cedula = :datoCedula", Paciente.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<PacienteTO> buscarPorFechaGenero(LocalDateTime fechaNacimiento, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<PacienteTO> myTypedQuery = this.entityManager
				.createQuery("SELECT NEW com.uce.edu.demo.repository.modelo.PacienteTO(p.cedula,p.nombre,p.fechaNacimiento,p.genero) FROM Paciente p WHERE p.fechaNacimiento >=:datoFechaNacimiento AND p.genero =:datoGenero",
				PacienteTO.class);
		myTypedQuery.setParameter("datoFechaNacimiento", fechaNacimiento);
		myTypedQuery.setParameter("datoGenero", genero);
		List<PacienteTO> listPaciente = myTypedQuery.getResultList();
		for(PacienteTO pacienteTO : listPaciente) {
			System.out.println(pacienteTO.toString());
		}
		return listPaciente;
	}

}
