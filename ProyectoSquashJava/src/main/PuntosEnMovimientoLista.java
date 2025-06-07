package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import personajes.Puntos;
import utilidades.StdDraw;

public class PuntosEnMovimientoLista {

	public static void main(String[] args) {
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		Random r = new Random();
		/* crear Lista de puntos */
		List<Puntos> punta = new ArrayList<Puntos>();

		int puntosIniciales = 1;
		int puntosMax = 10;

		for (int i = 0; i < puntosIniciales; i++) {
			/* creo aleatorios pra ello me creo metodo */
			Puntos puntoAleatorio = crearPuntoAleatorios(r.nextDouble(-99, 99), r.nextDouble(-99, 99));
			/* punto Fijo */
			Puntos p = new Puntos(12, 78, Color.BLACK);
			punta.add(p);
			punta.add(puntoAleatorio);
		}
		/* fin crear puntos */

		/* Representar Puntos */

		while (true) {
			StdDraw.clear();
			/* mensaje para interactuar */

			StdDraw.setPenColor();
			StdDraw.text(0, 90, "puntos :" + punta.size());
			StdDraw.text(0, 80, "pulsa el mouse para crear");

			for (int i = 0; i < punta.size(); i++) {
				// obtengo los puntos y dibujo
				punta.get(i).dibujar();
				punta.get(i).mover();

				/* rebote para cada punto */
				controlarRebote(punta.get(i));

			}

			/* puntos si se presiona el raton */
			if (StdDraw.isMousePressed()) {
				Puntos puntoAleatorio = crearPuntoAleatorios(StdDraw.mouseX(), StdDraw.mouseY());
				// Validar que el ratón esté dentro de los límites y que deje de crear si ya
				// llego al puntosMax.
				if (Math.abs(StdDraw.mouseX()) < 100 && Math.abs(StdDraw.mouseY()) < 100 && punta.size() <= puntosMax) {
					punta.add(puntoAleatorio);
				}
			}

			/* puntos por colision */

			List<Puntos> nuevos = new ArrayList<Puntos>();
			/*compraciones sin reduncias no importa el orden i+1*/
			/*combinaciones de numeros posibles sin repetidos i,j,k...*/
			for (int i = 0; i < punta.size(); i++) {
				for (int j = i + 1; j < punta.size(); j++) {
					if (punta.get(i).distancia(punta.get(j)) < 2) {
						/* creamos puntos en el punto medio de colision */
						/* 1medio */
						Puntos medio = punta.get(i).puntoMedio(punta.get(j));
						/* 2creo puntos en ese punto medio y añado a la lista nuevos */
						Puntos puntosMedios = crearPuntoAleatorios(medio.getX(), medio.getY());
						nuevos.add(puntosMedios);

					}
				}
				/* añado a la lista principal Punta */
				if (punta.size() + nuevos.size() <= puntosMax) {
					punta.addAll(nuevos);

				}

			}

			StdDraw.show();
			StdDraw.pause(70);
		}
		/* fin Representar Puntos */
	}/* FIN MAIN */

	/* METODOS */
	private static Puntos crearPuntoAleatorios(double x, double y) {
		/* intrucciones para cada punto aleatorio */
		Random r = new Random();
		Color colorAleatorio = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
		Puntos puntoAleatorio = new Puntos(x, y, colorAleatorio);// creo aleatorios en las x e y
		/* les doy movimientio */
		puntoAleatorio.setMovX(r.nextDouble(-6, 6));
		puntoAleatorio.setMovY(r.nextDouble(-6, 6));

		return puntoAleatorio;
	}

	private static void controlarRebote(Puntos puntoAleatorio) {
		/*
		 * detectar limites si pasa los limites invierto el movimiento mathABs ppara
		 * valor abosoluto ya q me da igual los signos
		 */
		if (Math.abs(puntoAleatorio.getX()) >= 100) {/* iz o dh */
			puntoAleatorio.setMovX(-puntoAleatorio.getMovX());
		}
		if (Math.abs(puntoAleatorio.getY()) >= 100) {/* arriba y abajo */
			puntoAleatorio.setMovY(-puntoAleatorio.getMovY());
		}
	}
}
