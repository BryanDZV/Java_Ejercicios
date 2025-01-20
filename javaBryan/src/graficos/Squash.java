package graficos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objetos.Circulo;
import objetos.Punto;
import objetos.Raqueta;
import utilidades.Func;
import utilidades.StdAudio;
import utilidades.StdDraw;

public class Squash {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		
		Random r=new Random();
		
		Raqueta raq=new Raqueta(0,-95,20);
		
		while(true){
			StdDraw.clear();
			
			if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
				raq.moverDerecha();
			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
				raq.moverIzquierda();
			
			raq.dibujar();
			
			StdDraw.show();
			StdDraw.pause(50);
		}

	}

}