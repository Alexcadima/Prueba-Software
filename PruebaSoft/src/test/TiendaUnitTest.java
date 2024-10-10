package test;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import paquete.Empleado;
import paquete.Producto;
import paquete.Tienda;

class TiendaUnitTest {
	private Tienda tienda;
	private Empleado empleadomock;
	private	Producto productomock;

	@BeforeEach
	void setUp() throws Exception {
		empleadomock = Mockito.mock(Empleado.class);
		productomock = Mockito.mock(Producto.class);
		tienda = new Tienda("Super");
	}

	@Test
	void testAgregarProducto() {
		tienda.agregarProducto(productomock);
		assertTrue(tienda.getProductos().contains(productomock));
	}
	
	@Test
	void testAgregarEmleado() {
		tienda.agregarEmpleado(empleadomock);
		assertTrue(tienda.getEmpleado().contains(empleadomock));
	}
	
	@Test
    public void testCantidadTotalProductos() {
        Producto producto2 = Mockito.mock(Producto.class);
        tienda.agregarProducto(productomock);
        tienda.agregarProducto(producto2);

        assertEquals(2, tienda.CantidadTotalProductos());
    }
	 

	@Test
	void testEliminarProducto() {
	    tienda.agregarProducto(productomock);
		Mockito.when(productomock.getNombre()).thenReturn("leche");
		assertEquals("leche", productomock.getNombre());
		assertTrue(tienda.eliminarProducto(productomock));
        
	}

	@Test
	void testTieneProducto() {
		tienda.agregarProducto(productomock);
		Mockito.when(productomock.getNombre()).thenReturn("Caldo");
        assertEquals("Caldo",productomock.getNombre());
	}


	@Test
	void testObtenerPrecio() {
		tienda.agregarProducto(productomock);
		Mockito.when(empleadomock.getNombre()).thenReturn("Caldo");
		Mockito.when(tienda.obtenerPrecio("Caldo")).thenReturn(220.0);
		assertEquals(220.0, tienda.obtenerPrecio("Caldo"));
	}
	
	@Test
	void testSueldoTotalSectores() {
		
		
		tienda.agregarEmpleado(empleadomock);
		empleadomock.setSectorDeTrabajo("Repositor");
		Mockito.when(empleadomock.getSectorDeTrabajo()).thenReturn("Repositor");
		/*Empleado empleado2 = Mockito.mock(Empleado.class);
		empleado2.setSectorDeTrabajo("Repositor");
		Empleado empleado3 = Mockito.mock(Empleado.class);
		empleado3.setSectorDeTrabajo("Repositor");
		tienda.agregarEmpleado(empleado3);*/
		assertEquals(1, tienda.EmpleadosPorSector("Repositor"));
		
	
	}

}



