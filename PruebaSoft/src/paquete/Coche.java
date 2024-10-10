package paquete;

public class Coche {
	private String marca;
    private String modelo;
    private double velocidad;
    private boolean motorEncendido;
    private double nivelCombustible;

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;
        this.motorEncendido=false;
        this.nivelCombustible=50;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void acelerar(double incremento) {
        if (incremento > 0) {
            this.velocidad += incremento;
        }
    }

    public void frenar(double decremento) {
        if (decremento > 0 && this.velocidad >= decremento) {
            this.velocidad -= decremento;
        }
    }

    public boolean estaDetenido() {
        return this.velocidad == 0;
    }

	public double getNivelCombustible() {
		return nivelCombustible;
	}

	public void setNivelCombustible(double nivelCombustible) {
		this.nivelCombustible = nivelCombustible;
	}

	public boolean isMotorEncendido() {
		return motorEncendido;
	}

	public void setMotorEncendido(boolean motorEncendido) {
		this.motorEncendido = motorEncendido;
	}
	
	public void encenderMotor() {
        if (nivelCombustible > 0) {
            motorEncendido = true;
            System.out.println("El motor ha sido encendido.");
        } else {
            System.out.println("No puedes encender el motor. No hay combustible.");
        }
    }

	public String revisarNivelCombustible() {
        if (nivelCombustible > 0) {
            return "El nivel de combustible es: " + nivelCombustible + " litros.";
        } else {
            return "El tanque está vacío.";
        }
    }

	public void apagarMotor() {
		if(motorEncendido!=false) {
			this.motorEncendido=true;
		}
		
	}

}
