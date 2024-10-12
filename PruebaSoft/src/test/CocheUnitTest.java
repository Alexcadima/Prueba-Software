package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import paquete.Coche;

class CocheUnitTest {
	private Coche coche;

	@BeforeEach
	void setUp() throws Exception {
		coche = new Coche("Toyota", "Corolla");
	}

	@Test
	void testAcelerar() {
		coche.acelerar(20);
        	assertEquals(20, coche.getVelocidad());
	}

	@Test
	void testFrenar() {
		coche.acelerar(50);
	        coche.frenar(20);
	        assertEquals(30, coche.getVelocidad());
	}

	@Test
	void testEstaDetenido() {
		coche.acelerar(10);
        	assertFalse(coche.estaDetenido());
	}
	
	@Test
	public void testEncenderMotorConCombustible() {
	        coche.encenderMotor();
	        assertTrue(coche.isMotorEncendido());
	}
	
	@Test
	public void testRevisarNivelCombustibleConCombustible() {
		coche.setNivelCombustible(0);
        	assertEquals(50, coche.revisarNivelCombustible());
	}
}
