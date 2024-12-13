package colorinesObjetos;

import java.awt.event.KeyEvent;

import utilidades.StdDraw;

public class VentanitasDos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// sistema para dibujar
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);

		StdDraw.enableDoubleBuffering();

		double x = -100;
		double y = 0;

		for (;;) {
			// detectar si el raton esta pulsado
			StdDraw.clear();

			// circulo
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledCircle(x, y, 10);

			x = x + 10;

			StdDraw.show();
			StdDraw.pause(100);
			// Mostrar el dibujo
		}

	}

}
