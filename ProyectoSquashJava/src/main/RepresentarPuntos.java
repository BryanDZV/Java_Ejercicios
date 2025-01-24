package main;

import java.awt.Color;

import personajes.Puntos;
import utilidades.Func;
import utilidades.StdDraw;

public class RepresentarPuntos {

	public static void main(String[] args) {
		/* metodos para representar puntos */
		/* crear un objeto punto */
		Puntos p1 = new Puntos(90, -90);
		Puntos p = new Puntos(25, 50, Color.GREEN);
		// Configurar el lienzo
		// StdDraw.setCanvasSize(550, 500); // Tamaño de la ventana (opcional)
		StdDraw.setXscale(-100, 100);// Escala en el eje X
	
		StdDraw.setYscale(-100, 100); // Escala en el eje Y
		StdDraw.enableDoubleBuffering();

		/*
		 * BUCLE para representar ifinitamente porque stdDraw va por fotogramas
		 */

		while (true) {
			StdDraw.clear();
			// mover CON EL RATON
			p.setX(StdDraw.mouseX());
			p.setY(StdDraw.mouseY());
			// UNIRLOS CON LINEA
			StdDraw.setPenColor(Color.blue);
			StdDraw.setPenRadius(0.010);
			StdDraw.line(p1.getX(), p1.getY(), p.getX(), p.getY());
			// mostrar la distancia entre los puntos
			double dist=p.distancia(p1);//calculado con mi formula
			StdDraw.setPenColor(Color.pink);
		
			
			//punto medio
			Puntos medio=p.puntoMedio(p1);
			//pongo texto en el punto medio
			StdDraw.text(medio.getX(),medio.getY(),String.valueOf(Func.redondear(dist, 2)));
			
			//DIBUJAR CUADRANTES LINEAS
			
			StdDraw.setPenColor(StdDraw.BLACK);
			  StdDraw.line(-100, 0, 100, 0); // Línea horizontal en Y = 0
			StdDraw.setPenColor(StdDraw.BLUE);
		     StdDraw.line(0, -100, 0, 100); // Línea vertical en X = 0
		     
		    //CAMABIAR DE COLOR SEGUN CUADRANTES el punto p
		     if (p.getX()>0 && p.getY()>0) {
		    	 p.setColor(Color.yellow);
		 StdDraw.text(45, 45, "eres amarillo");
					
				}
		   

			// llamo a mi metodo que dibuja para cada punto
			p.dibujar();
			p1.dibujar();

			StdDraw.show();
			StdDraw.pause(50);
		}

	}
}
