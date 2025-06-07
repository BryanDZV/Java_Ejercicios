package colorinesObjetos;

import java.awt.event.KeyEvent;
import java.util.Random;

import utilidades.StdDraw;

public class VentanitasDos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// sistema para dibujar
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		// trayectoria aleatoria
		Random r = new Random();
//CIRCULO 
		double x = 0;
		double dx = r.nextDouble(-4, 4);
		double y = 0;
		double dy = r.nextDouble(-4, 4);
		// CIRCULO 2
		double x2 = 0;
		double dx2 = r.nextDouble(-4, 4);
		double y2 = 0;
		double dy2 = r.nextDouble(-4, 4);
		// CIRCULO 3
		double x3 = 0;
		double dx3 = r.nextDouble(-4, 4);
		double y3 = 0;
		double dy3 = r.nextDouble(-4, 4);

		// CIRCULO 4
		double x4 = 0;
		double dx4 = r.nextDouble(-4, 4);
		double y4 = 0;
		double dy4 = r.nextDouble(-4, 4);

		for (;;) {
			// detectar si el raton esta pulsado
			StdDraw.clear();

			// circulo
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledCircle(x, y, 10);

			x = x + dx;
			y = y + dy;

			// limites en x
			if (x >= 100 || x <= -100) {
				dx = -dx;

			}
			// limites en y
			if (y >= 100 || y <= -100) {
				dy = -dy;

			}

			// circulo2
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledCircle(x2, y2, 40);

			x2 = x2 + dx2;
			y2 = y2 + dy2;

			// limites en x2
			if (x2 >= 100 || x2 <= -100) {
				dx2 = -dx2;

			}
			// limites en y2
			if (y2 >= 100 || y2 <= -100) {
				dy2 = -dy2;

			}

			// circulo3
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.filledCircle(x3, y3, 30);

			x3 = x3 + dx3;
			y3 = y3 + dy3;

			// limites en x2
			if (x3 >= 100 || x3 <= -100) {
				dx3 = -dx3;

			}
			// limites en y2
			if (y3 >= 100 || y3 <= -100) {
				dy3 = -dy3;

			}

			// circulo 4
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledCircle(x4, y4, 20);

			x4 = x4 + dx4;
			y4 = y4 + dy4;

			// limites en x2
			if (x4 >= 100 || x4 <= -100) {
				dx4 = -dx4;

			}
			// limites en y2
			if (y4 >= 100 || y4 <= -100) {
				dy4 = -dy4;

			}

			// Mostrar el dibujo
			StdDraw.show();
			StdDraw.pause(30);

		}

	}

}
