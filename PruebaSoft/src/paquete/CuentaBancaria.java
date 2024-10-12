package paquete;

public class CuentaBancaria {
	private String numeroCuenta;
    private double saldo;

    public CuentaBancaria() {
    	
    }
    
    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double s) {
    	this.saldo = s;
    }

    public boolean depositar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            return true;
        }
        return false;
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            this.saldo -= cantidad;
            return true;
        }
        return false;
    }

    public boolean tieneFondos(double cantidad) {
        return saldo >= cantidad;
    }

    public void transferir(CuentaBancaria cuentaDestino, double cantidad) {
        if (retirar(cantidad)) {
            cuentaDestino.depositar(cantidad);
        }
    }

}
