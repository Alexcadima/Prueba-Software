package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import paquete.Coche;
import paquete.CuentaBancaria;
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
		tiendaMock.agregarProducto(productoMock);
		Mockito.when(productoMock.getPrecio()).thenReturn(1200.0);
		Mockito.when(persona.getCuentaBancaria().getSaldo()).thenReturn(1300.0);
		Mockito.when(productoMock.getNombre()).thenReturn("Caldo");
		assertTrue(persona.comprarEnTienda(tiendaMock, productoMock));
	}
	
	@Test
	void testComprarEnTiendaFondoInsuficiente() {
		productoMock = Mockito.mock(Producto.class);
		tiendaMock.agregarProducto(productoMock);
		Mockito.when(productoMock.getPrecio()).thenReturn(1200.0);
		Mockito.when(persona.getCuentaBancaria().getSaldo()).thenReturn(100.0);
		Mockito.when(productoMock.getNombre()).thenReturn("Caldo");
		assertTrue(persona.comprarEnTienda(tiendaMock, productoMock));
	}
	
	@Test
    public void testConducirCoche() {
		Mockito.when(persona.getCoche().getMarca()).thenReturn("Toyota");
		Mockito.when(persona.getCoche().getModelo()).thenReturn("Corolla");
        assertEquals("Estoy conduciendo mi coche Toyota Corolla", persona.conducirCoche());
    }
	
	@Test
    public void testDepositarDinero() {
		
		
		//Mockito.when(persona.getCuentaBancaria().getSaldo()).thenReturn(1000.0);
		//persona.getCuentaBancaria().setSueldo(1000.0);
		
		//cuentaMock.setSueldo(1000.0);
		//cuentaMock.depositar(500.0);
		//persona.depositarDinero(500.0);
        assertTrue(persona.depositarDinero(500.0));
        //assertEquals(1500.0, persona.getCuentaBancaria().getSaldo());

        //persona.depositarDinero(-100.0);
        //assertEquals(1500.0, persona.getCuentaBancaria().getSaldo());
    }

}
