package cuatroEnRaya;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Iterator;

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
    		Integer colRaton=detectarColumnaRaton();
    		if (colRaton!=null) {
    			//Dibujamos rectángulo en la columna que corresponde a la posición del ratón
    			resaltarColumna(colRaton);
    			if (clickRaton()) {
    				introducirFicha(turno, colRaton);
	    			//Cambio de jugador
					if (turno==1)
						turno=2;
					else
						turno=1;
    			}
    		}
    		
            StdDraw.show();
        	//Esperamos para que el usuario pueda ver lo dibujado
        	StdDraw.pause(10);
        	//Borramos todo y se dibuja de nuevo en la siguiente iteración
        	StdDraw.clear();
        }
	}
	
	private static void introducirFicha(int turno2, Integer colRaton) {
		//crer una ficha
		//new Circulo c=(new Punto(0,0,TAM_CASILLA));
		
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
