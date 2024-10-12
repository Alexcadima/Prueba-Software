package testIntegracion;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import paquete.Coche;
import paquete.CuentaBancaria;
import paquete.Empleado;
import paquete.Producto;
import paquete.Tienda;

class IntegracionUnitTest {
	
	private CuentaBancaria cuentaBancaria;
    private Coche coche;
    private Empleado empleado;
    private Tienda tienda;
    private Producto leche;
    private Producto pan;

    @BeforeEach
    void setUp() {
        cuentaBancaria = new CuentaBancaria("12345678", 100.0); // Saldo inicial de 100.0
        coche = new Coche("Toyota", "Corolla");
        empleado = new Empleado("Juan", 28, cuentaBancaria, coche, true, 1200, LocalDate.of(2020, 1, 1), "Ventas");
        tienda = new Tienda("Supermercado ABC");
        leche = new Producto("Leche", 30.0); // Precio de 30.0
        pan = new Producto("Pan", 60.0); // Precio de 60.0
    }

    @Test
    void testCompraConTransferenciaEntreEmpleados() {
        CuentaBancaria cuentaOtroEmpleado = new CuentaBancaria("87654321", 30.0);
        Empleado otroEmpleado = new Empleado("Pedro", 35, cuentaOtroEmpleado, coche, false, 1500, LocalDate.of(2018, 6, 1), "Almacén");
        tienda.agregarProducto(pan);
        otroEmpleado.comprarEnTienda(tienda, pan);
        assertEquals(30.0, cuentaOtroEmpleado.getSaldo());
        empleado.getCuentaBancaria().transferir(cuentaOtroEmpleado, 30.0);
        assertEquals(60.0, cuentaOtroEmpleado.getSaldo());
        assertEquals(70.0, cuentaBancaria.getSaldo());
    }

    @Test
    void testEmpleadoAgregaYCompraProducto() {
        tienda.agregarEmpleado(empleado);
        Producto cereal = new Producto("Cereal", 25.0);
        tienda.agregarProducto(cereal);
        empleado.comprarEnTienda(tienda, cereal);
        assertFalse(tienda.tieneProducto("Cereal"));
        assertEquals(75.0, cuentaBancaria.getSaldo());
    }

    @Test
    void testEmpleadoConducirYCargarCombustible() {
        assertEquals("Estoy conduciendo mi coche Toyota Corolla", empleado.conducirCoche());
        empleado.getCoche().setNivelCombustible(0);
        empleado.getCoche().encenderMotor();
        assertFalse(empleado.getCoche().isMotorEncendido());
    }

    @Test
    void testEmpleadoDepositoYSuInteraccionConTienda() {
        empleado.depositarDinero(200.0);
        assertEquals(300.0, cuentaBancaria.getSaldo());
        tienda.agregarProducto(leche);
        empleado.comprarEnTienda(tienda, leche);
        assertEquals(270.0, cuentaBancaria.getSaldo());
        assertFalse(tienda.tieneProducto("Leche"));
    }

    @Test
    void testEmpleadoCompraProductoInexistente() {
        tienda.agregarEmpleado(empleado);
        tienda.agregarProducto(pan);
        assertFalse(tienda.tieneProducto("Jugo"));
        empleado.comprarEnTienda(tienda, leche);
        assertTrue(tienda.tieneProducto("Pan"));
        assertEquals(100.0, cuentaBancaria.getSaldo());
    }

    @Test
    void testEmpleadoCompraProductoSaldoInsuficienteYDeposito() {
        cuentaBancaria.retirar(80.0); // Quedan 20
        tienda.agregarProducto(pan);
        empleado.comprarEnTienda(tienda, pan);
        assertTrue(tienda.tieneProducto("Pan"));
        assertEquals(20.0, cuentaBancaria.getSaldo());
        empleado.depositarDinero(100.0);
        assertEquals(120.0, cuentaBancaria.getSaldo());
    }

    @Test
    void testEmpleadoCompraDosProductos() {
        Producto jugo = new Producto("Jugo", 10.0);
        tienda.agregarProducto(leche);
        tienda.agregarProducto(jugo);
        empleado.comprarEnTienda(tienda, leche);
        empleado.comprarEnTienda(tienda, jugo);
        assertFalse(tienda.tieneProducto("Leche"));
        assertFalse(tienda.tieneProducto("Jugo"));
        assertEquals(60.0, cuentaBancaria.getSaldo());
    }

    @Test
    void testEmpleadoCompraProductoYDiasTrabajados() {
        tienda.agregarProducto(leche);
        empleado.comprarEnTienda(tienda, leche);
        int diasTrabajados = empleado.diasTrabajados(LocalDate.now());
        assertTrue(diasTrabajados >= 0);
    }

    @Test
    void testEmpleadoCompraUnProductoYRevisaSuSaldo() {
        empleado.setContrato(false);
        tienda.agregarProducto(leche);
        empleado.comprarEnTienda(tienda, leche);
        assertEquals(70.0, cuentaBancaria.getSaldo());
        assertTrue(tienda.tieneProducto("Leche"));
    }

    @Test
    void testEmpleadoRetiraFondoInsuficienteYCocheSinCombustible() {
        cuentaBancaria.retirar(150.0); // Queda -50, pero no permite retirar
        assertEquals(100.0, cuentaBancaria.getSaldo());
        empleado.getCoche().setNivelCombustible(0);
        assertEquals("El tanque está vacío.", empleado.getCoche().revisarNivelCombustible());
    }

}
