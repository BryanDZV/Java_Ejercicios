package objetosEjercicios;

import java.awt.Color;

import utilidades.StdDraw;

public class Punto {
	private double x;
	private double y;
	private Color color;

	// GETTER Y SETTER
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	/* METODOS */
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

//CONSTRUCTOR 1
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
		this.color = Color.BLACK;
	}

//CONSTRUCTOR 2
	public Punto(double x, double y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

//TO STRING
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + ", color=" + color + "]";
	}

	public static void main(String[] args) {

		Punto p = new Punto(3, 7, Color.GREEN);
		Punto p2 = new Punto(5, 1);

		double x;
		double y;
		Color color;

		/*
		 * public static void main (String[] args) {
		 * 
		 * Punto p=new Punto();
		 * 
		 * 
		 * 
		 * }
		 */

		System.out.println(p);
		System.out.println(p2);
	}

	/* METODOS */
//DIBUJAR
	public void dibujar() {
		StdDraw.setPenRadius(0.02);
		StdDraw.setPenColor(color);
		StdDraw.point(x, y);
	}

//DSITANCIA
	public double distancia(Punto otro) {

		return Math.sqrt(Math.pow(x - otro.x, 2) + Math.pow(y - otro.y, 2));// SQRT raiz cuadrada
	}

//DISTANCIA MEDIA
	public Punto puntoMedio(Punto otro) {
		// TODO Auto-generated method stub

		Punto m = new Punto((x + otro.x) / 2, (y + otro.y) / 2);

		return m;
	}
}