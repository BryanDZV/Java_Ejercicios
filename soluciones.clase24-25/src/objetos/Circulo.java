package objetos;

import java.awt.Color;

import utilidades.StdDraw;

public class Circulo {
	private Punto centro;
	private double radio;
	
	public Circulo(Punto p, double radio) {
		centro=p;
		setRadio(radio);
	}
	public Circulo(double xCentro, double yCentro, double radio) {
		Punto p=new Punto(xCentro, yCentro);
		centro=p;
		setRadio(radio);
	}
	public Punto getCentro() {
		return centro;
	}
	public void setCentro(Punto centro) {
		this.centro = centro;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		if (radio<=0)
			throw new RuntimeException("Un círculo debe tener radio positivo");
		this.radio = radio;
	}
	
	public String toString() {
		return "Circulo [centro=" + centro + ", radio=" + radio + "]";
	}
	
	public void dibujar() {
		dibujar(true); //Dibujar sin parámetros dibuja un círculo macizo
		
	}
	
	public void dibujar(boolean relleno) {
		StdDraw.setPenColor(centro.getColor());
		if (relleno)
			StdDraw.filledCircle(centro.getX(), centro.getY(), radio);
		else { //SOLO CONTORNO
			StdDraw.setPenRadius(0.005);
			StdDraw.circle(centro.getX(), centro.getY(), radio);
		}
		
	}
	public static void main(String[] args) {
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		Punto p=new Punto(0, 0);
		Circulo c=new Circulo(p,10);
		//La doy color asignandolo a su punto central
		c.getCentro().setColor(Color.GREEN);
		System.out.println(c);
		c.dibujar(false);
		
		Circulo c2=new Circulo(25,40,15);
		c2.dibujar(false);
	}
	public boolean seSuperpone(Circulo c) {
		// true si el círculo(this) se superpone con otro círculo c.
		// Se superponen si la distancia entre sus centros es menor que la suma de sus radios.
		return this.centro.distancia(c.getCentro()) < this.radio+c.getRadio();
	}
	
	public boolean contiene(Punto p) {
		return centro.distancia(p) < radio;
	}
	
}
