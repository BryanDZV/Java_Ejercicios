package colorinesObjetos;

import java.awt.event.KeyEvent;

import utilidades.StdDraw;

public class Ventanitas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (;;) {
			// detectar si el raton esta pulsado

			if (StdDraw.isMousePressed()) {
				System.out.println("se esta pulsando y saliendo");
				//System.exit(0);

			}
			
			//detectar si una tecla esta pulsada
			
			
			if (StdDraw.isKeyPressed(KeyEvent.VK_C)) {
				System.out.println("se esta presionando la tecla");
				/// CUADRADO
				StdDraw.setPenColor(StdDraw.YELLOW);
				//StdDraw.filledSquare(r.nextInt(-100,101), r.nextInt(-100,100), 2.5);
				//StdDraw.square(-50, -50, 50);
				
			} 
			
			
			
			
			
			
			
			
			//
			StdDraw.setXscale(-100, 100);
			StdDraw.setYscale(-100, 100);

			//// GROSOR LINEA
			StdDraw.setPenRadius(0.05);
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.point(0.1, 0.1);

			//// LINEA
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.line(-100, -100, 100, 100);

			/// LINEA
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.line(100, -100, -100, 100);
			/// CIRCULO
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledCircle(0, 0, 10);
			/// RECTANGULO
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.rectangle(100, 100, 200, 200);
			StdDraw.rectangle(-100, -100, 200, 200);

			// PUNTO
			StdDraw.setPenRadius(0.10);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(-100, -100);
			/// PUNTO
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(100, 100);
			// PUNTO
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(-100, +100);
			/// PUNTO
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(+100, -100);
			// TEXTO
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.textRight(50, 0, "mundo");
			// TEXTO
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.textLeft(-50, 0, "hola");

			StdDraw.pause(300);
			// System.exit(0);
		}

	}

}
