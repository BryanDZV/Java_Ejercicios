package ej2;

import java.awt.Color;
import utilidades.StdDraw;

/**
 *Consideramos rectángulos horizontales.
 *Definimos un rectángulo mediante el vértice superior izquierdo y el inferior derecho.
 *
 */
class Rectangulo {
	private Punto supIzq;
	private Punto infDer;
	
	public Rectangulo(Punto supIzq, Punto infDer) {
		this.supIzq = supIzq;
		this.infDer = infDer;
	}

	public Punto getSupIzq() {
		return supIzq;
	}

	public Punto getInfDer() {
		return infDer;
	}

	@Override
	public String toString() {
		return "Rectangulo [supIzq=" + supIzq + ", infDer=" + infDer + "]";
	}

	public Punto centroIzq() { //Devuelve punto en el centro del lado izquierdo
		return new Punto(supIzq.getX(), supIzq.getY()-altura()/2);
	}
	
	public Punto centroDer() { //Devuelve punto en el centro del lado derecho
		return new Punto(infDer.getX(), infDer.getY()+altura()/2);
	}
	
	public Punto centroSup() { //Devuelve punto en el centro del lado superior
		return new Punto(supIzq.getX()+base()/2, supIzq.getY());
	}
	
	public Punto centroInf() { //Devuelve punto en el centro del lado inferior
		return new Punto(infDer.getX()-base()/2, infDer.getY());
	}

	public double base() {
		return infDer.getX()-supIzq.getX();
	}
	
	public double altura() {
		return supIzq.getY()-infDer.getY();
	}
	
}
