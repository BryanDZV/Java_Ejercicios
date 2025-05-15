package ej2;

import java.awt.Color;
import java.util.Random;

import utilidades.StdDraw;

class Circulo {
	private Punto centro;
	private double radio; 
	private Color color;
	
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
		this.radio = radio;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Circulo(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
		color=Color.BLACK;
	}
	@Override
	public String toString() {
		return "Circulo [centro=" + centro + ", radio=" + radio + ", color=" + color + "]";
	}
	
	public void dibujar() {
		dibujar(color);
	}
	
	public void dibujar(Color color) {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(centro.getX(), centro.getY(), radio);
	}
	public void movimiento(double dX, double dY) {
		centro.setMovX(dX);
		centro.setMovY(dY);
	}
	
	public void mover() {
		centro.mover();
	}
	public boolean dentroRectangulo(Rectangulo r) {
		// true si el círculo está rodeado por el rectángulo
		return centro.getX()+radio < r.getInfDer().getX() && centro.getX()-radio > r.getSupIzq().getX()
				&& centro.getY()+radio < r.getSupIzq().getY() && centro.getY()-radio > r.getInfDer().getY();
	}
}
