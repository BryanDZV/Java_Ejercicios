package graficos;

import java.util.Random;

import objetos.Carta;
import objetos.Palo;
import utilidades.StdDraw;

public class RepresentandoCartas {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		
		Carta c=new Carta(Palo.OROS,12);
		Carta c2=new Carta(Palo.BASTOS,7);
	
		for (;;) {
			StdDraw.clear();
			c.dibujar(0,0,25,50);
			c2.dibujar(75, 75, 12, 20);
			
			StdDraw.show();
			StdDraw.pause(100);
		}

	}
}
