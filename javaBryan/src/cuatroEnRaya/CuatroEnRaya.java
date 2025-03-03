package cuatroEnRaya;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import cuatroEnRaya.copy.Circulo;
import utilidades.StdDraw;

public class CuatroEnRaya {
	static Circulo [][] tablero; //Matriz de 6 filas y 7 columnas que contendrá las fichas
	static Rectangulo recTablero; //Rectángulo azul que representa el tablero que contiene las fichas
	static final double TAM_CASILLA=25 ; //Tomamos cuadrículas de 25x25 como referencia para la posición de cada ficha
	static int turno=1; //Jugador 1 ó 2. Comienza el 1.
	static String advertencia=null;
	static boolean recienPulsado=false;
	
	

	public static void main(String[] args) {
		long inicio=System.currentTimeMillis();
		tablero=new Circulo[6][7];
		Punto esquinaSupIzq=new Punto(-88,70,Color.BLUE); //Vértice superior izquierdo del tablero
		recTablero=new Rectangulo(esquinaSupIzq,
			new Punto(esquinaSupIzq.getX()+tablero[0].length*TAM_CASILLA,
					esquinaSupIzq.getY()-tablero.length*TAM_CASILLA));
		
		//Establecemos margen de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		
		StdDraw.enableDoubleBuffering();
		boolean finPartida=false;
        while (!finPartida) {
        	//Función que dibuja el tablero según su contenido
    		dibujarTablero();
    		
    		//Informamos de a quien le toca tirar
    		StdDraw.setPenColor(Color.BLACK);
    	    StdDraw.text(0, 90, "Ahora tira el jugador "+turno);
    	    
    		
    		//Detectamos la columna que corresponde a la posición del ratón. null si no está sobre ninguna
    	    Integer colRaton = detectarColumnaRaton();
			if (colRaton != null) {
				// Dibujamos rectángulo en la columna que corresponde a la posición del ratón
				resaltarColumna(colRaton);
				if (clickRaton()) {
					introducirFicha(turno, colRaton);
					if (hayVictoria()) {
						finPartida = true;
					}
					// Cambio de jugador
					if (turno == 1)
						turno = 2;
					else
						turno = 1;
    			}
    		}
    		
            StdDraw.show();
        	//Esperamos para que el usuario pueda ver lo dibujado
        	StdDraw.pause(10);
        	//Borramos todo y se dibuja de nuevo en la siguiente iteración
        	StdDraw.clear();
        }
	}
	
	private static boolean hayVictoria() {
		// Devuelve true si hay 4 fichas iguales en cualquier dirección
		// false en caso contrario

		// Análisis horizontales
		for (int i = 0; i < tablero.length; i++) {
			int cnt = 0; // Por cada fila contamos cooincidencias de color entre fichas adyacentes
			for (int j = 1; j < tablero[0].length; j++) {
				// Comparamos cada ficha con la de su izquierda (j-1)
				if (tablero[i][j] != null && tablero[i][j - 1] != null) {
					if (tablero[i][j].getCentro().getColor().equals(tablero[i][j - 1].getCentro().getColor())) {
						cnt++;
						if (cnt == 3) // 3 coincidencias de color consecutivas
							return true;
					} else // Color diferente
						cnt = 0;
				} else // Alguna de las 2 fichas a comparar en null (hueco)
					cnt = 0;
			}
		}

		// Análisis verticales
		for (int j = 0; j < tablero[0].length; j++) {
			int cnt = 0;
			for (int i = 1; i < tablero.length; i++) {
				if (tablero[i][j] != null && tablero[i - 1][j] != null) {
					if (tablero[i][j].getCentro().getColor().equals(tablero[i - 1][j].getCentro().getColor())) {
						cnt++;
						if (cnt == 3)
							return true;
					} else {
						cnt = 0;
					}
				} else {
					cnt = 0;
				}
			}
		}

		// Análisis diagonales ↘ que nacen desde la parte superior (fila 0, todas las
		// columnas)
		for (int j = 0; j < tablero[0].length; j++) {
			int cnt = 0;
			for (int x = 0, y = j; x < tablero.length - 1 && y < tablero[0].length - 1; x++, y++) {
				if (tablero[x][y] != null && tablero[x + 1][y + 1] != null) {
					if (tablero[x][y].getCentro().getColor().equals(tablero[x + 1][y + 1].getCentro().getColor())) {
						cnt++;
						if (cnt == 3)
							return true;
					} else
						cnt = 0;
				} else
					cnt = 0;
			}
		}

		// Análisis diagonales ↘ que nacen de la parte izquierda del tablero (columna 0,
		// todas las filas)
		for (int i = 0; i < tablero.length; i++) {
			int cnt = 0;
			for (int x = i, y = 0; x < tablero.length - 1 && y < tablero[0].length - 1; x++, y++) {
				if (tablero[x][y] != null && tablero[x + 1][y + 1] != null) {
					if (tablero[x][y].getCentro().getColor().equals(tablero[x + 1][y + 1].getCentro().getColor())) {
						cnt++;
						if (cnt == 3)
							return true;
					} else
						cnt = 0;
				} else
					cnt = 0;
			}
		}

		// Análisis diagonales ↙ que nacen de la parte superior (fila 0, todas las
		// columnas)
		for (int j = tablero[0].length - 1; j >= 0; j--) {
			int cnt = 0;
			for (int x = 0, y = j; x < tablero.length - 1 && y > 0; x++, y--) {
				if (tablero[x][y] != null && tablero[x + 1][y - 1] != null) {
					if (tablero[x][y].getCentro().getColor().equals(tablero[x + 1][y - 1].getCentro().getColor())) {
						cnt++;
						if (cnt == 3)
							return true;
					} else
						cnt = 0;
				} else
					cnt = 0;
			}
		}

		// Análisis diagonales ↙ que nacen de la parte derecha del tablero (0, todas las
		// filas)
		for (int i = 0; i < tablero.length; i++) {
			int cnt = 0;
			for (int x = i, y = tablero[0].length - 1; x < tablero.length - 1 && y >= 0; x++, y--) {
				if (tablero[x][y] != null && tablero[x + 1][y - 1] != null) {
					if (tablero[x][y].getCentro().getColor().equals(tablero[x + 1][y - 1].getCentro().getColor())) {
						cnt++;
						if (cnt == 3)
							return true;
					} else
						cnt = 0;
				} else
					cnt = 0;
			}
		}

		return false;// false sino hay victoria de ninguno
	}

	
	private static void introducirFicha(int turno, Integer columna) {
		if (turno < 1 || turno > 2)
			throw new IllegalArgumentException("El jugador debe ser 1 ó 2");
		if (columna < 0 || columna > 6)
			throw new IllegalArgumentException("La columna debe estar entre 0 y 6");
		if (tablero[0][columna] != null) // La fila 0 es la fila de arriba en el tablero
			throw new RuntimeException("La columna " + columna + " está llena");

		// Creamos ficha amarilla o roja
		Circulo ficha = new Circulo(0, 0, TAM_CASILLA * 0.8 / 2);
		if (turno == 1)
			ficha.setColor(Color.YELLOW);
		else
			ficha.setColor(Color.RED);
		// Recorremos las filas de abajo hacia arriba, en el primer hueco(null)
		// colocamos la ficha
		for (int i = tablero.length - 1; i >= 0; i--) {
			if (tablero[i][columna] == null) {
				tablero[i][columna] = ficha;
				return;
			}
		}

	}


	private static boolean clickRaton() {
		if (StdDraw.isMousePressed()) {
			if (!recienPulsado) {
				recienPulsado = true;
				return true;
			}
		}else
			recienPulsado = false;
		return false;
	}


	private static void resaltarColumna(Integer colRaton) {
		Color colorResaltado=null;
		if (turno==1)
			colorResaltado=new Color(255,255,0); //Amarillo
		else
			colorResaltado=new Color(255,0,0); //Rojo
		// Construimos rectángulo que rodee la columna. Tendrá el ancho de una columna (TAM_CASILLA)
		Punto supIzq=new Punto(recTablero.getSupIzq().getX()+colRaton*TAM_CASILLA, recTablero.getSupIzq().getY(),colorResaltado);
		Punto infDer=new Punto(recTablero.getSupIzq().getX()+colRaton*TAM_CASILLA+TAM_CASILLA, recTablero.getInfDer().getY());
		Rectangulo resaltado=new Rectangulo(supIzq, infDer);
		resaltado.dibujar(false);
		
	}


	private static Integer detectarColumnaRaton() {
		double mouseX=StdDraw.mouseX();
		double mouseY=StdDraw.mouseY();

		if (mouseX <= recTablero.getSupIzq().getX() || mouseX >= recTablero.getInfDer().getX() ||
			mouseY <= recTablero.getInfDer().getY() || mouseY >= recTablero.getSupIzq().getY())
			return null; //Ratón fuera del tablero
		
		double distanciaBordeIzquierdo=(mouseX-recTablero.getSupIzq().getX())/TAM_CASILLA; //Produce un número entre 0.00 y 6.99
		return (int)distanciaBordeIzquierdo; //Convertimos a int para truncar decimales
		
	}


	private static void dibujarTablero() {
		recTablero.dibujar();
		Circulo hueco=new Circulo(0,0,TAM_CASILLA*0.8/2); //Círculo para dibujar los huecos
		hueco.setColor(Color.WHITE);
		Circulo c=null; //Referencia a un Circulo que se dibujará (hueco oficha amarilla/roja
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				//Transformamos la i(fila) y la j(columna) en coordenadas del centro de un círculo
				double x=recTablero.getSupIzq().getX()+j*TAM_CASILLA+TAM_CASILLA/2;
				double y=recTablero.getInfDer().getY()+(tablero.length-i)*TAM_CASILLA-TAM_CASILLA/2;
				if (tablero[i][j]==null)
					c=hueco;
				else
					c=tablero[i][j];
				c.getCentro().setX(x);
				c.getCentro().setY(y);
				c.dibujar();
			}
		}
		
	}


}
