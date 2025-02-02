package main;

import java.awt.Color;

import personajes.Circulos;
import personajes.Puntos;
import utilidades.StdDraw;

public class RepresentarCirculos {

	public static void main(String[] args) {
		
		
		
		/*REPRESETAR CIRCULO*/
		//OBJETOS
		Puntos p1 = new Puntos(32,12,Color.PINK);
		
		Circulos c1=new Circulos(p1,12.2);
		//LIENZOS
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		
		
		/*PINTAMOS*/
		
		while (true) {
			StdDraw.clear();
			StdDraw.setPenColor(Color.ORANGE);
		
		
			
		c1.dibujarC(false);
			
			
			
			
			
			StdDraw.show();
			StdDraw.pause(50);
			
		}

	}

}
