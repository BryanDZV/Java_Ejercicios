package cuatroEnRaya.copy;

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
	static final double TAM_CASILLA = 10; // Tomamos cuadrículas de 10x10 como referencia para la posición de cada ficha
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

				StdDraw.enableDoubleBuffering();
				boolean recienPulsado = false;
				boolean finPartida = false;
				while (!finPartida) {
					// Función que dibuja el tablero según su contenido
					dibujarTablero();

					// Informamos de a quien le toca tirar
					StdDraw.setPenColor(Color.BLACK);
					StdDraw.text(0, 90, "Ahora tira el jugador " + turno);

					// Detectamos la columna que corresponde a la posición del ratón. null si no
					// está sobre ninguna
					Integer colRaton = detectarColumnaRaton();
					resaltarColumna(colRaton);
					System.out.println(colRaton);

					StdDraw.show();
					// Esperamos para que el usuario pueda ver lo dibujado
					StdDraw.pause(10);
					// Borramos todo y se dibuja de nuevo en la siguiente iteración
					StdDraw.clear();
				}
			}
	
	private static void resaltarColumna(Integer colRaton) {
		// TODO Auto-generated method stub
		
		
		
	}

	private static Integer detectarColumnaRaton() {
		// 0..6

		
		double xRaton = StdDraw.mouseX();
		double yRaton = StdDraw.mouseY();
		
		if (yRaton < recTablero.getInfDer().getY() || yRaton > recTablero.getSupIzq().getY()) {
	
			return null; // Ratón fuera del tablero en el eje Y
		}


		double xInicioTablero = recTablero.getSupIzq().getX();
		double xFinTablero = recTablero.getInfDer().getX();

		if (xRaton < xInicioTablero || xRaton > xFinTablero) {
			return null; //raton fuera del eje x
		}

	
		int columna =  (int) ((xRaton - xInicioTablero) / TAM_CASILLA);
		//sSystem.out.println(columna);

		return columna; // Retorna la columna detectada (0 a 6)
		
		

	}
	
	
	
	
	
	
	

	private static void dibujarTablero() {
	    // Dibujar el rectángulo que representa el tablero
	    recTablero.dibujar();

	    // Dibujar las casillas de la matriz
	    for (int fila = 0; fila < tablero.length; fila++) {
	        for (int columna = 0; columna < tablero[0].length; columna++) {
	            // Calcular la posición de cada casilla (centro de la casilla)
	            double x = recTablero.getSupIzq().getX() + (columna * TAM_CASILLA) + TAM_CASILLA / 2;
	            double y = recTablero.getSupIzq().getY() - (fila * TAM_CASILLA) - TAM_CASILLA / 2;

	    
	             
	                StdDraw.setPenColor(Color.WHITE);  // Color de fondo
	                StdDraw.filledCircle(x, y, TAM_CASILLA / 2); // Casilla vacía (círculo vacío)
	            
	        }
	    }
	}




}
