package graficos;

import java.awt.event.KeyEvent;
import java.util.Random;

import utilidades.StdDraw;

public class DibujosBasicos {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		
		Random r=new Random();

		for (;;) {
			StdDraw.setPenRadius(0.005);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.text(0, 80, "Pulse el ratón para salir");
			StdDraw.text(0, 70, "Pulse tecla C para dibujar cuadrados");
			//Detectar si el ratón está pulsado
			if (StdDraw.isMousePressed())
				System.exit(0);
			
			//Detectar si una tecla (C) está pulsada
			if (StdDraw.isKeyPressed(KeyEvent.VK_C)) {
				StdDraw.setPenColor(StdDraw.ORANGE);
				StdDraw.filledSquare(r.nextInt(-100,101), r.nextInt(-100,101), 2.5);
				StdDraw.setPenColor(StdDraw.BLUE);
				StdDraw.filledSquare(r.nextInt(-100,101), r.nextInt(-100,101), 3);
			}
			

			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledCircle(0, 0, 15);

			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(-100, 100, 100, -100);
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.line(100, 100, -100, -100);

			// círculos rojos en cada esquina
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledCircle(-100, 100, 10);
			StdDraw.filledCircle(-100, -100, 10);
			StdDraw.filledCircle(100, 100, 10);
			StdDraw.filledCircle(100, -100, 10);
			
			StdDraw.pause(100);
		}

	}

}
