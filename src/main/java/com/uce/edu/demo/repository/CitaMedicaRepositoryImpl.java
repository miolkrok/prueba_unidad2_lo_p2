package com.uce.edu.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.CitaMedica;
import com.uce.edu.demo.repository.modelo.CitaMedicaTO;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository {

	private static final Logger LOG = Logger.getLogger(CitaMedicaRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public void actualizar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica buscarPorNumero(String numeroTurno) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> myQuery = this.entityManager
				.createQuery("SELECT c FROM CitaMedica c WHERE c.numero =: datoNumero", CitaMedica.class);
		myQuery.setParameter("datoNumero", numeroTurno);

		return myQuery.getSingleResult();
	}

	@Override
	public List<CitaMedicaTO> reporteCitas(LocalDateTime fechaCita, BigDecimal costoCita) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedicaTO> myTypedQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.repository.modelo.CitaMedicaTO(c.numero,c.fechaCita,c.costoCita,c.fechaControl) FROM CitaMedica c WHERE c.fechaCita >:datoFechaCita AND c.costoCita >:datoCostoCita",
				CitaMedicaTO.class);
		myTypedQuery.setParameter("datoFechaCita", fechaCita);
		myTypedQuery.setParameter("datoCostoCita", costoCita);
		List<CitaMedicaTO> reporte = myTypedQuery.getResultList();
		for (CitaMedicaTO citaMedicaTO : reporte) {
			LOG.info(citaMedicaTO.toString());
		}
		return reporte;
	}

}
