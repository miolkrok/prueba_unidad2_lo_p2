package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Doctor;
import com.uce.edu.demo.repository.modelo.Paciente;
import com.uce.edu.demo.service.IGestorCitaMedicaService;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaU2PaP2LoApplication implements CommandLineRunner{

	private static final Logger LOG=Logger.getLogger(PruebaU2PaP2LoApplication.class);
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IGestorCitaMedicaService gestorCitaMedicaService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaU2PaP2LoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//FUNCIONALIDAD 1
		//////////////insercion de Doctor 1 ////////////////
		Doctor doc1 = new Doctor();
		doc1.setCedula("1718496944");
		doc1.setNombre("Luis");
		doc1.setApellido("Ortiz");
		doc1.setFechaNacimiento(LocalDateTime.of(1997, 5, 19, 12, 00));
		doc1.setNumeroConsultorio("A25");
		doc1.setTitulo("Neurologia");
		doc1.setSalario(new BigDecimal(4000));
		this.doctorService.insertar(doc1);
		
		//////////////insercion de Doctor 2 ////////////////
		Doctor doc2 = new Doctor();
		doc2.setCedula("1796506255");
		doc2.setNombre("Michelle");
		doc2.setApellido("Rescalbo");
		doc2.setFechaNacimiento(LocalDateTime.of(1985, 8, 22, 11, 00));
		doc2.setNumeroConsultorio("A24");
		doc2.setTitulo("Cardiologia");
		doc2.setSalario(new BigDecimal(4500));
		this.doctorService.insertar(doc2);
		
		//FUNCIONALIDAD 2
		/////////////insercion de paciente 1 ////////////////
		Paciente paci1 = new Paciente();
		paci1.setCedula("1794851651");
		paci1.setNombre("Gabriel");
		paci1.setApellido("Mestanza");
		paci1.setFechaNacimiento(LocalDateTime.of(1999, 11, 13, 07, 00));
		paci1.setCodigoIess("231530");
		paci1.setEstatura("1.75 metros");
		paci1.setPeso("70 kg");
		paci1.setGenero("M");
		this.pacienteService.insertar(paci1);
		
		
		/////////////insercion de paciente 2 ////////////////
		Paciente paci2 = new Paciente();
		paci2.setCedula("1758152117");
		paci2.setNombre("Katherine");
		paci2.setApellido("Rodriguez");
		paci2.setFechaNacimiento(LocalDateTime.of(1970, 11, 13, 07, 00));
		paci2.setCodigoIess("84512320");
		paci2.setEstatura("1.60 metros");
		paci2.setPeso("55 kg");
		paci2.setGenero("F");
		this.pacienteService.insertar(paci2);
		/////FUNCIONALIDAD 3
		this.gestorCitaMedicaService.agendamientoCita("T002", LocalDateTime.now(), new BigDecimal(40), "Centro Medico Familiar Colon", "1796506255", "1758152117");
		/////FUNCIONALIDAD 4
		this.gestorCitaMedicaService.actualizacionCita("T002", "Hipertension", "Cardiografia", LocalDateTime.of(2022, 8, 10, 11, 00));
		/////FUNCIONALIDAD 5
		this.gestorCitaMedicaService.reporteCitas(LocalDateTime.of(2021, 10, 11, 4, 00), new BigDecimal(20));
		
	}

}
