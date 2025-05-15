package graficos;

import java.util.List;
import java.util.Random;

import objetos.Carta;
import objetos.Palo;
import utilidades.StdDraw;

public class RepresentandoCartas {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		/* auxiliar para mover la carta en eje x */
		int margenIzquierdo = -90;

		/* auxiliar para mover la carte en eje y */

		int margenSuperior = 50;

		List<Carta> baraja = Carta.crearBarajaEspaniola();

		Carta c = new Carta(Palo.OROS, 12);
		Carta c2 = new Carta(Palo.BASTOS, 7);

		for (;;) {
			StdDraw.clear();
			// c.dibujar(0,0,25,50);
			// c2.dibujar(75, 75, 12, 20);

			/* recorreer la baraja tambien puedo con el for each */
			for (int i = 0; i < baraja.size(); i++) {
				int fila = 0;
				switch (baraja.get(i).getPalo()) {
				case OROS:
					fila = 0;
					break;
				case COPAS:
					fila = 1;
					break;
				case ESPADAS:
					fila = 2;
					break;
				case BASTOS:
					fila = 3;
					break;
				}
				baraja.get(i).dibujar(margenIzquierdo + (i % 10) * 20, margenSuperior - fila * 35, 20, 30);
			}

			StdDraw.show();
			StdDraw.pause(100);
		}

	}
}