package objetosEjercicios;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objetosEjercicios.Punto;
import utilidades.Func;
import utilidades.StdDraw;

public class PuntosEnMovimiento {

	// ********************************
	// Modificad lo que consideréis para:
	// 1) Que el punto rojo no desaparezca y rebote al llegar a los límites de la
	// ventana
	// 2) Una vez conseguido lo anterior, haced que haya 20 puntos con colores y
	// movimientos aleatorios
	// rebotando por la ventana. Cambiar el punto p(rojo) por un array de 20 puntos:
	// Punto [] a=new Punto[20];

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		/*
		 * aqui creo uno Random r=new Random(); Color colorAleat=new
		 * Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)); Punto p=new
		 * Punto(0,0,colorAleat); p.setMovX(r.nextDouble(-6,6));
		 * p.setMovY(r.nextDouble(-6,6));
		 */

		// array lista
		// aqui creo la lista

		List<Punto> puntos = new ArrayList<Punto>();
		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			Color colorAleat = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
			// usando referencia
			Punto p = new Punto(0, 0, colorAleat);
			p.setMovX(r.nextDouble(-6, 6));
			p.setMovY(r.nextDouble(-6, 6));
		}

		while (true) {
			StdDraw.clear();

			// aqui controlo ya la lista
			for (int i = 0; i < puntos.size(); i++) {
				controlarRebote(puntos.get(i));

				puntos.get(i).mover(); // Se desplaza el punto según movX y MovY
				puntos.get(i).dibujar();

			}

			/*
			 * 
			 * aqui igual solo uno controlarRebote(p);
			 * 
			 * p.mover(); //Se desplaza el punto según movX y MovY p.dibujar();
			 * 
			 * 
			 */

			// Creamos puntos cuando el ratón está pulsado
			if (StdDraw.isMousePressed()) {
				Color colorAleat = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
				Punto p = new Punto(0, 0, colorAleat);
				p.setMovX(r.nextDouble(-6, 6));
				p.setMovY(r.nextDouble(-6, 6));
				puntos.add(p);
			}

			StdDraw.show();
			StdDraw.pause(50);
		}

	}

	private static void controlarRebote(Punto pun) {
		// Detectar límites de la ventana
		if (Math.abs(pun.getX()) >= 100) { // izq. o drecha
			pun.setMovX(-pun.getMovX());
		}
		if (Math.abs(pun.getY()) >= 100) { // arriba o derecha
			pun.setMovY(-pun.getMovY());
		}

	}
}