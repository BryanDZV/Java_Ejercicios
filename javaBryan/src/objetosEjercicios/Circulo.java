package objetosEjercicios;

public class Circulo {
	private Punto centro;
	private double radio;

	public Punto getCentro() {
		return centro;
				}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1-siempre existe un constructor por defecto que coge los atributos
		 * 
		 * 
		 */

		// private double radio;
		// private Punto centro;

	}

	public void setCentro(Punto centro) {
		this.centro = centro;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		if (radio <= 0)
			throw new RuntimeException("Un círculo debe tener radio positivo");

		this.radio = radio;
	}

}