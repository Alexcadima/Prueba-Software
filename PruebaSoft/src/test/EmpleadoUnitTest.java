package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import paquete.Coche;
import paquete.CuentaBancaria;
import paquete.Empleado;
import paquete.Persona;

class EmpleadoUnitTest {
	private Empleado empleado;
	private Persona personamock;
	private CuentaBancaria cuentaMock;
    private Coche cocheMock;

	@BeforeEach
	void setUp() throws Exception {
		personamock = Mockito.mock(Persona.class);
		cuentaMock = Mockito.mock(CuentaBancaria.class);
		cocheMock = Mockito.mock(Coche.class);
		empleado = new Empleado(personamock.getNombre(), personamock.getEdad(), cuentaMock, cocheMock, true, 2.0, LocalDate.of(2000, 3, 1), "Limpieza");
	}

	@Test
	void testCalcularSueldo() {
		Mockito.when(personamock.getEdad()).thenReturn(31);
		assertEquals(4.0, empleado.calcularSueldo());
	}
	
	@Test
	void testCalcularSueldoEdadMenor() {
		Mockito.when(personamock.getEdad()).thenReturn(19);
		empleado.setContrato(false);
		assertEquals(4.0, empleado.calcularSueldo());
	}
	
	@Test
	void testCalcularSueldoNoBlanco() {
		Mockito.when(personamock.getEdad()).thenReturn(39);
		empleado.setContrato(false);
		assertEquals(4.0, empleado.calcularSueldo());
	}

	@Test
	void testDiasTrabajados() {
		assertEquals(1, empleado.diasTrabajados(LocalDate.of(2000, 3, 2)));
	}
	
	@Test
	void testDiasTrabajadosFallo() {
		assertEquals(10, empleado.diasTrabajados(LocalDate.of(2000, 3, 2)));
	}

}
