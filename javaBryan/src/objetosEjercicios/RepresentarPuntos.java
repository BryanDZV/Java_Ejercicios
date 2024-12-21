package objetosEjercicios;

import java.awt.Color;

import utilidades.StdDraw;

public class RepresentarPuntos {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
//puntos 
		Punto p = new Punto(50, 50, Color.GREEN);
		Punto p2 = new Punto(0, 0);

		double dist = p.distancia(p2);

		while (true) {
			StdDraw.clear();
			// distancia
			StdDraw.text(0, 90, "Distancia: " + dist);
			// distancia media
			/*
			 * StdDraw.text((p.getX()+p2.getX())/2, (p.getY()+p2.getY())/2, "Distancia: " +
			 * dist);
			 */
			// distancia media 2 metodo

			Punto medio = p.puntoMedio(p2);

			StdDraw.text(medio.getX(), medio.getY(), "Distancia: " + dist);

			// linea
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.setPenRadius(0.01);
			StdDraw.line(p.getX(), p.getY(), p2.getX(), p2.getY());

			// puntos
			p.dibujar();
			p2.dibujar();
			p.setX(StdDraw.mouseX());
			p.setY(StdDraw.mouseY());
			
			//cuadrante
			
			if (p.getX()<0 && p.getY()>0) {
				System.out.println("hola");
				p.setColor(Color.RED);
				
				
			}
			if (p.getX()<0 && p.getY()<0) {
				System.out.println("adios");
				p.setColor(Color.GREEN);
				
			}
			if (p.getX()>0 && p.getY()>0) {
				System.out.println("mundo");
				p.setColor(Color.YELLOW);
				
			}
			if (p.getX()>0 && p.getY()<0) {
				System.out.println("humano");
				p.setColor(Color.ORANGE);
				
			}
			

			StdDraw.show();
			StdDraw.pause(80);

		}

	}

}