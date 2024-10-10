package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import paquete.Coche;
import paquete.CuentaBancaria;
import paquete.Empleado;
import paquete.Persona;
import paquete.Producto;
import paquete.Tienda;

class PersonaUnitTest {
	
	private Persona persona;
	private CuentaBancaria cuentaMock;
    private Coche cocheMock;
    private Tienda tiendaMock;
    private Producto productoMock;

	@BeforeEach
	void setUp() throws Exception {
		cuentaMock = Mockito.mock(CuentaBancaria.class);
		cocheMock = Mockito.mock(Coche.class);
		tiendaMock = Mockito.mock(Tienda.class);
		persona = new Persona("Juan",30,cuentaMock,cocheMock);
		
	}

	@Test
	void testEsMayorDeEdad() {
		persona.setEdad(20);
		assertEquals(true, persona.esMayorDeEdad());
	}

	@Test
	void testSaludar() {
		assertEquals("Hola, mi nombre es Juan", persona.saludar());
	}

	@Test
	void testComprarEnTienda() {
		productoMock = Mockito.mock(Producto.class);
		Mockito.when(persona.getCuentaBancaria().getSaldo()).thenReturn(998.5);
		persona.comprarEnTienda(tiendaMock, productoMock);
		assertEquals(998.5, persona.getCuentaBancaria().getSaldo());
	}
	
	@Test
    public void testConducirCoche() {
        assertEquals("Estoy conduciendo mi coche Toyota Corolla", persona.conducirCoche());
    }
	
	@Test
    public void testDepositarDinero() {
        persona.depositarDinero(500.0);
        assertEquals(1500.0, persona.getCuentaBancaria().getSaldo());

        persona.depositarDinero(-100.0);
        assertEquals(1500.0, persona.getCuentaBancaria().getSaldo());
    }

}
