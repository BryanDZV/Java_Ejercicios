package cuatroEnRaya;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import cuatroEnRaya.Circulo;
import cuatroEnRaya.Punto;
import cuatroEnRaya.Rectangulo;
import utilidades.StdDraw;

public class CuatroEnRaya {
	static Circulo[][] tablero; // Matriz de 6 filas y 7 columnas que contendrá las fichas
	static Rectangulo recTablero; // Rectángulo azul que representa el tablero que contiene las fichas
	static final double TAM_CASILLA = 25; // Tomamos cuadrículas de 25x25 como referencia para la posición de cada ficha
	static int turno = 1; // Jugador 1 ó 2. Comienza el 1.
	static String advertencia = null;

	public static void main(String[] args) {
		tablero = new Circulo[6][7];
		Punto esquinaSupIzq = new Punto(-88, 70, Color.BLUE);
		// Vértice superior izquierdo del tablero
		recTablero = new Rectangulo(esquinaSupIzq, new Punto(esquinaSupIzq.getX() + tablero[0].length * TAM_CASILLA,
				esquinaSupIzq.getY() - tablero.length * TAM_CASILLA));

		// Establecemos margen de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);

		boolean finPartida = false;
		while (!finPartida) {
		
			// Función que dibuja el tablero según su contenido
			dibujarTablero();

			StdDraw.show();

			// Esperamos para que el usuario pueda ver lo dibujado
			StdDraw.pause(10);
			// Borramos todo y se dibuja de nuevo en la siguiente iteración
			StdDraw.clear();
			
			

		}
	}

	private static void dibujarTablero() {
	    // Dibujar el rectángulo que representa el tablero
	    recTablero.dibujar();

	    // Dibujar las casillas de la matriz
	    for (int fila = 0; fila < tablero.length; fila++) {
	        for (int columna = 0; columna < tablero[0].length; columna++) {
	            double x = recTablero.getSupIzq().getX() - (columna + 1) * TAM_CASILLA;
	            double y = recTablero.getInfDer().getY() + (fila + 1) * TAM_CASILLA;
	            if (tablero[fila][columna] != null) {
	                // Dibujar la ficha (circulo) si existe
	                tablero[fila][columna].dibujar(x, y);
	            } else {
	                // Si no hay ficha, dibujar una casilla vacía (puedes dibujar un círculo vacío o simplemente dejarla vacía)
	                StdDraw.setPenColor(Color.WHITE);  // Color de fondo
	                StdDraw.filledCircle(x, y, TAM_CASILLA / 2); // Casilla vacía
	            }
	        }
	    }
	}


}
