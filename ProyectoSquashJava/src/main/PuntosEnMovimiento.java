package main;

import java.awt.Color;
import java.util.Random;

import objetos.Puntos;
import utilidades.StdDraw;

public class PuntosEnMovimiento {

	public static void main(String[] args) {
		/* metodos para representar puntos */

		// Configurar el lienzo
		// StdDraw.setCanvasSize(550, 500); // Tamaño de la ventana (opcional)
		StdDraw.setXscale(-100, 100); // Escala en el eje X
		StdDraw.setYscale(-100, 100); // Escala en el eje Y
		StdDraw.enableDoubleBuffering();
		Random r = new Random();// raido Random

		/* crear un objeto punto en cantidades */
		// guardar en array

		Puntos[] puntos = new Puntos[20];

		for (int i = 0; i < puntos.length; i++) {
			// hago que mi color sea diferente en
			// cada nuevo rgb (r,r,r)
			Color colorAleatorio = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
			puntos[i] = new Puntos(0, 0, colorAleatorio);
			// le voy asignando nuevas posiciones
			puntos[i].setMovX(r.nextDouble(-6, 6));// (-6,6)entre que rango ase aleatoriosincluido e excluido
			puntos[i].setMovY(r.nextDouble(-6, 6));

		}

		/*
		 * BUCLE para representar ifinitamente 
		 * porque stdDraw va por fotogramas
		 * 
		 * y el que realmente cre el movimiento
		 */

		while (true) {
			StdDraw.clear();
			// BUCLE PARA REPRESENTAR EL ARRAY PUNTOS
			for (int i = 0; i < puntos.length; i++) {
				puntos[i].mover();
				puntos[i].dibujar();

			}

			// llamo a mi metodo que dibuja para cada punto

			StdDraw.show();
			StdDraw.pause(300);
		}

	}

}
