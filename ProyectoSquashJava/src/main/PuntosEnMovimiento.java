package main;

import java.awt.Color;
import java.util.Random;

import personajes.Puntos;
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

		Puntos[] puntos = new Puntos[5];
		
		
//BUCLE PARA CREAR BOLAS
		for (int i = 0; i < puntos.length; i++) {
			// hago que mi color sea diferente en cada nuevo rgb (r,r,r)
			 
			Color colorAleatorio = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
			puntos[i] = new Puntos(0, 0, colorAleatorio);
			// le voy asignando nuevas posiciones(para eso creo nuevos tributos y nueva
			//funcion en punto)
			puntos[i].setMovX(r.nextDouble(-6, 6));// (-6,6)entre que rango ase aleatoriosincluido e excluido
			puntos[i].setMovY(r.nextDouble(-6, 6));

		}

		/*
		 * BUCLE para REPRESENTAR ifinitamente  porque stdDraw
		 *  va por fotogramas y el que realmente creA el movimiento
		 */

		while (true) {
			StdDraw.clear();
			// BUCLE PARA RECORRER EL ARRAY PUNTOS
			for (int i = 0; i < puntos.length; i++) {
				// llamo a mi metodo que dibuja y mover Y REBOTA para cada punto
				controlarRebote(puntos[i]);//CREO UN NUEVO METODO PARA REBOTE AQUI 
				puntos[i].mover();
				puntos[i].dibujar();

			}

			

			StdDraw.show();
			StdDraw.pause(50);
		}

	}
	
	//metodo privado de rebote
	private static void controlarRebote(Puntos p) {
		//Detectar límites de la ventana
		if (Math.abs(p.getX()) >= 100) { //izq. o drecha
			p.setMovX(-p.getMovX());
		}
		if (Math.abs(p.getY()) >= 100) { //arriba o derecha
			p.setMovY(-p.getMovY());
		}
		
	}

}
