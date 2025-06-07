package personajes;

import java.awt.Color;

import utilidades.StdDraw;

public class Circulos {
	/* atributos */

	private double radio;
	private Puntos centro;
	/* constructores */

	public Circulos(Puntos centro, double radio) {

		this.radio = radio;
		this.centro = centro;

	};

	/* metodos */
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public Puntos getCentro() {
		return centro;
	}

	public void setCentro(Puntos centro) {
		this.centro = centro;
	}

	/* metodo para dibujar el cirulo */
	public void dibujarC() {
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.setPenRadius(0.07);
		StdDraw.point(centro.getX(), centro.getY());
	}

	/* metodo para jugar con el rellenado */

	public void dibujarC(boolean rellenado) {

		if (rellenado) {
			dibujarC();
		} else {
			StdDraw.setPenColor(Color.GREEN);
			StdDraw.setPenRadius(0.005);
			StdDraw.circle(centro.getX(), centro.getY(), 8);
		}

	}
	
	
	

	public static void main(String[] args) {
		/* para pruebas */
		// LIENZOS
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		Puntos p1 = new Puntos(32, 12, Color.PINK);
		Circulos c1 = new Circulos(p1, 10);
		// colo punto central
		c1.getCentro().setColor(Color.GREEN);
		c1.dibujarC();

	}

}
