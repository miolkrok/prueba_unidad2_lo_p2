package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CitaMedicaTO {

	private String numero;
	private LocalDateTime fechaCita;
	private BigDecimal costoCita;
	private LocalDateTime fechaControl;
	
	public CitaMedicaTO() {
		// TODO Auto-generated constructor stub
	}

	public CitaMedicaTO(String numero, LocalDateTime fechaCita, BigDecimal costoCita, LocalDateTime fechaControl) {
		super();
		this.numero = numero;
		this.fechaCita = fechaCita;
		this.costoCita = costoCita;
		this.fechaControl = fechaControl;
	}

	//set y get
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getCostoCita() {
		return costoCita;
	}

	public void setCostoCita(BigDecimal costoCita) {
		this.costoCita = costoCita;
	}

	public LocalDateTime getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}

	@Override
	public String toString() {
		return "CitaMedicaTO [numero=" + numero + ", fechaCita=" + fechaCita + ", costoCita=" + costoCita
				+ ", fechaControl=" + fechaControl + "]";
	}
	
}
