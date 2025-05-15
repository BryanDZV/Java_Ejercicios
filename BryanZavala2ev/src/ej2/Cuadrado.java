package ej2;

import java.awt.Color;

import ej2.Circulo;
import utilidades.StdDraw;

/**
 *Consideramos cuadrados horizontales.
 *Definimos un cuadrado mediante el vértice superior izquierdo y la longitud de su lado.
 *
 */
class Cuadrado {
	private Punto supIzq;
	private double lado;
	private Punto mX;
	private Punto mY;
	
	public Cuadrado(Punto supIzq, double lado) {
		this.supIzq = supIzq;
		this.lado = lado;
		
	}

	public Punto getSupIzq() {
		return supIzq;
	}

	public void setSupIzq(Punto supIzq) {
		//this.supIzq = supIzq;
		this.supIzq = mX;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [supIzq=" + supIzq + ", lado=" + lado + "]";
	}

	public void dibujar() {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledSquare(supIzq.getX()+lado/2, supIzq.getY()-lado/2, lado/2);
	}

	public Punto supDer() {
		return new Punto(supIzq.getX()+lado,supIzq.getY());
	}
	
	public Punto infDer() {
		return new Punto(supIzq.getX()+lado,supIzq.getY()-lado);
	}
	
	public Punto infIzq() {
		return new Punto(supIzq.getX(),supIzq.getY()-lado);
	}

	public boolean dentroDe(Circulo circ) {
		//Modificar este método según se indica en el enunciado
		return false;
	}
	//mover raton
	public void mover(double x,double y) {
		
		
		
		
		
	}
	
}
