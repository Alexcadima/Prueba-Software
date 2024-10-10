package paquete;

import java.time.LocalDate;
import java.time.Period;

public class Empleado extends Persona{
	
	private boolean enBlanco;
	private double sueldoBase;
	private LocalDate inicioTrabajo;
	private String sectorDeTrabajo;
	
	public Empleado() {
			
	}

	public Empleado(String nombre, int edad, CuentaBancaria cuentaBancaria, Coche coche, boolean contrato,
			double sueldoBase, LocalDate inicioTrabajo, String sector) {
		super(nombre, edad, cuentaBancaria, coche);
		this.enBlanco = contrato;
		this.sueldoBase = sueldoBase;
		this.inicioTrabajo=inicioTrabajo;
		this.sectorDeTrabajo=sector;
	}

	
	public boolean isContrato() {
		return enBlanco;
	}

	public void setContrato(boolean contrato) {
		this.enBlanco = contrato;
	}

	public LocalDate getInicioTrabajo() {
		return inicioTrabajo;
	}

	public void setInicioTrabajo(LocalDate inicioTrabajo) {
		this.inicioTrabajo = inicioTrabajo;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	public String getSectorDeTrabajo() {
		return sectorDeTrabajo;
	}

	public void setSectorDeTrabajo(String sectorDeTrabajo) {
		this.sectorDeTrabajo = sectorDeTrabajo;
	}

	
	
	public double calcularSueldo() {
		double total=sueldoBase;
		if(enBlanco==true || getEdad()>=30) {
			total=sueldoBase*2;
		}
		if(enBlanco==false) {
			total=sueldoBase*1.5;
		}
		return total;
	}

	public int diasTrabajados(LocalDate fechaHasta) {
		Period periodo= Period.between(inicioTrabajo, fechaHasta);
		return periodo.getDays();
	}
	
	
	
	

	
}
