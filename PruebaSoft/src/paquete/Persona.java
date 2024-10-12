package paquete;

public class Persona {
	private String nombre;
    private int edad;
    private CuentaBancaria cuentaBancaria;  // Relación con CuentaBancaria
    private Coche coche;  // Relación con Coche
    
    public Persona() {
    	
    }

    public Persona(String nombre, int edad, CuentaBancaria cuentaBancaria, Coche coche) {
        this.nombre = nombre;
        this.edad = edad;
        this.cuentaBancaria = cuentaBancaria;
        this.coche = coche;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public CuentaBancaria getCuentaBancaria() {
        return cuentaBancaria;
    }

    public Coche getCoche() {
        return coche;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public String saludar() {
        return "Hola, mi nombre es " + nombre;
    }

    public boolean comprarEnTienda(Tienda tienda, Producto producto) {
        double precio = producto.getPrecio();
        if (precio <= getCuentaBancaria().getSaldo()) {
            cuentaBancaria.retirar(precio);
            tienda.eliminarProducto(producto);
            System.out.println(nombre + " ha comprado " + producto + " por " + precio + " euros.");
            return true;
        } else {
            System.out.println(nombre + " no tiene suficiente dinero para comprar " + producto + ".");
            return false;
        }
    }
    
    public String conducirCoche() {
        return "Estoy conduciendo mi coche " + coche.getMarca() + " " + coche.getModelo();
    }
    
    public boolean depositarDinero(double monto) {
        if (monto > 0) {
            cuentaBancaria.depositar(monto);
            System.out.println("Se han depositado " + monto + " euros en tu cuenta.");
            return true;
        } else {
            System.out.println("El monto debe ser positivo.");
            return false;
        }
    }
}

