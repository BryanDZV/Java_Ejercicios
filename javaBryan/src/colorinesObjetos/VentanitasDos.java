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

		double x = 0;
		double dx = r.nextDouble(-4,4);
		double y = 0;
		double dy =r.nextDouble(-4,4);

		for (;;) {
			// detectar si el raton esta pulsado
			StdDraw.clear();

			// circulo
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledCircle(x, y, 10);

			x = x + dx;
			y = y + dy;
			
			//limites en x
			if (x>=100 || x<=-100) {
				dx=-dx;
				
			}
			//limites en y
			if (y>=100 || y<=-100) {
				dy=-dy;
				
			}

			StdDraw.show();
			StdDraw.pause(100);
			// Mostrar el dibujo
		}

	}

}
