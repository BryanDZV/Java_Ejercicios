package ej2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import utilidades.StdDraw;

public class Ej2 {

	public static void main(String[] args) {
		//Obtenemos resolución de nuestra pantalla (en píxeles)
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double anchoPantalla = screenSize.getWidth();
		double altoPantalla = screenSize.getHeight();
		
		//Tamaño de la ventana de StdDraw (píxeles)
		int anchoVentana=(int)(anchoPantalla/2);
		int altoVentana=(int)(altoPantalla/2);
		StdDraw.setCanvasSize(anchoVentana,altoVentana);
		
		// Rectángulo de la ventana y escala de las coordenadas (0,0) en el centro de la ventana
		Rectangulo lienzo=new Rectangulo(new Punto(-anchoVentana/2,altoVentana/2),new Punto(anchoVentana/2,-altoVentana/2));
		StdDraw.setXscale(lienzo.getSupIzq().getX(), lienzo.getInfDer().getX());
		StdDraw.setYscale(lienzo.getInfDer().getY(),lienzo.getSupIzq().getY());
		
		
		//Crea una nube (ArrayList) de círculos completos dentro del lienzo
		List<Circulo> nube = generarNubeCirculos(5, true, lienzo);
		
		//Crea objeto cuadrado que debe moverse con el ratón
		Cuadrado c=new Cuadrado(new Punto(-25,25), 50);
		
		
		StdDraw.enableDoubleBuffering(); // Lo que dibujemos se mostrará al hacer show()
		while (true) {
			// Borramos escenario
			StdDraw.clear();
			// Dibujamos objetos e información en el escenario
			pintarEjes(lienzo);
			StdDraw.textLeft(lienzo.getSupIzq().getX()+5, lienzo.getSupIzq().getY()-15, "Círculos restantes: "+nube.size());
			for (int i = 0; i < nube.size(); i++) {
				nube.get(i).dibujar();
			}
			c.dibujar();
			//c.mover();
			
			// Movimiento y control de rebote para cada círculo en ArrayList
			for (int i = 0; i < nube.size(); i++) {
				nube.get(i).mover();
				controlarRebote(nube.get(i),lienzo);
			}
			// Mostramos todo lo dibujado
			StdDraw.show();
			// Pausa
			StdDraw.pause(50);
		}
		
	}

	private static ArrayList<Circulo> generarNubeCirculos(int cuantos, boolean colorAleatorio, Rectangulo lienzo) {
		Random r = new Random();
		ArrayList<Circulo> n = new ArrayList<Circulo>();
		// Crea círculos con centro aleatorio dentro del lienzo
		// y movimiento aleatorio:-5..5 en dx y en dy
		for (int i = 0; i < cuantos; i++) {
			Punto centro=null;
			Circulo circulo=null;
			do {
				double x = generarAleatorio(lienzo.getSupIzq().getX(), lienzo.getInfDer().getX());
				double y=generarAleatorio(lienzo.getInfDer().getY(),lienzo.getSupIzq().getY());
				centro = new Punto(x,y); // centro de posición aleatoria dentro del lienzo
				double radio=(r.nextInt(3) + 1)*10+40; 
				circulo=new Circulo(centro, radio);
			} while (!circulo.dentroRectangulo(lienzo)); //Generamos nuevo círculo si el que hemos creado no está completamente dentro del lienzo
			
			//Generamos movimiento aleatorio y lo asignamos al objeto círculo
			double movX = generarAleatorio(2, 10);
			if (r.nextInt(2) == 0)
				movX = -movX;
			double movY = generarAleatorio(2, 10);
			if (r.nextInt(2) == 0)
				movY = -movY;
			circulo.movimiento(movX, movY);
			
			if (colorAleatorio) {
				int color = r.nextInt(6);// 0..5
				Color c = null;
				switch (color) {
				case 0:
					c = Color.red;
					break;
				case 1:
					c = Color.blue;
					break;
				case 2:
					c = Color.green;
					break;
				case 3:
					c = Color.yellow;
					break;
				case 4:
					c = Color.cyan;
					break;
				case 5:
					c = Color.orange;
					break;
				}
				circulo.setColor(c);
			}
			
			// Añadimos Punto al ArrayList
			n.add(circulo);
		}
		return n;
	}

	private static double generarAleatorio(double min, double max) {
		double d=Math.random()*(max-min)+min;
		return d;
	}

	private static void controlarRebote(Circulo circulo, Rectangulo lienzo) {
		//Rebote derecha o izquierda
		if (circulo.getCentro().getX()+circulo.getRadio() > lienzo.getInfDer().getX()
		 || circulo.getCentro().getX()-circulo.getRadio() < lienzo.getSupIzq().getX())
			circulo.movimiento(-circulo.getCentro().getMovX(), circulo.getCentro().getMovY());
		//Rebote arriba o abajo
		if (circulo.getCentro().getY()+circulo.getRadio() > lienzo.getSupIzq().getY()
		 || circulo.getCentro().getY()-circulo.getRadio() < lienzo.getInfDer().getY())
			circulo.movimiento(circulo.getCentro().getMovX(), -circulo.getCentro().getMovY());
	}

	private static void pintarEjes(Rectangulo r) {
		// Ejes
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(0.003);
		StdDraw.line(r.centroInf().getX(),r.centroInf().getY(), r.centroSup().getX(), r.centroSup().getY());
		StdDraw.text(r.centroSup().getX()+10, r.centroSup().getY()-10, "y");
		StdDraw.line(r.centroIzq().getX(),r.centroIzq().getY(), r.centroDer().getX(), r.centroDer().getY());
		StdDraw.text(r.centroDer().getX()-10, r.centroDer().getY()+10, "x");
	}

}
