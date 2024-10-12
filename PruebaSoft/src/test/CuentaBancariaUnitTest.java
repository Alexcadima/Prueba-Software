package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import paquete.CuentaBancaria;

class CuentaBancariaUnitTest {
	private CuentaBancaria cuenta;
	

	@BeforeEach
	void setUp() throws Exception {
		cuenta = new CuentaBancaria("12345", 1000.0);
	}

	@Test
	void testDepositar() {
		cuenta.depositar(500);
		assertEquals(1500.0, cuenta.getSaldo());
	}

	@Test
	void testRetirar() {
		cuenta.retirar(200.0);
		assertEquals(800.0, cuenta.getSaldo());
	}

	@Test
	public void testRetirarFondosSuficientes() {
        cuenta.retirar(200.0);
        assertEquals(800.0, cuenta.getSaldo());
    }
	
	@Test
	public void testRetirarFondosInsuficientes() {
        cuenta.retirar(100.0);
        assertEquals(01000.0, cuenta.getSaldo());
    }

	@Test
	void testTransferir() {
		cuenta.transferir(new CuentaBancaria("54321", 500.0), 300.0);
		assertEquals(700.0, cuenta.getSaldo());
	}

}
