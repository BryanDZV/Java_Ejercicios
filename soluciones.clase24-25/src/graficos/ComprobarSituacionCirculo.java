package graficos;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import objetos.Circulo;
import objetos.Punto;
import utilidades.StdDraw;

public class ComprobarSituacionCirculo {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		
		Punto p=new Punto(30,60,Color.RED);
		Circulo c=new Circulo(50, 40,15);
		c.getCentro().setColor(Color.GREEN);
		//Se moverá con el ratón
		Circulo lazo=new Circulo(0,0,20);
		lazo.getCentro().setColor(Color.BLUE);
		
		while(true){
			StdDraw.clear();
			
			//cambiamos coordenadas del centro del círculo lazo
			lazo.getCentro().setX(StdDraw.mouseX());
			lazo.getCentro().setY(StdDraw.mouseY());
			
			StdDraw.setPenColor(Color.BLACK);
			if (lazo.seSuperpone(c))
				StdDraw.textLeft(-98, 95, "Círculos superpuestos: SÍ");
			else
				StdDraw.textLeft(-98, 95, "Círculos superpuestos: NO");
			if (lazo.contiene(p))
				StdDraw.textLeft(-98, 85, "Punto dentro: SÍ");
			else
				StdDraw.textLeft(-98, 85, "Punto dentro: NO");
			
			
			p.dibujar();
			c.dibujar();
			lazo.dibujar(false);
			
			
			StdDraw.show();
			StdDraw.pause(50);
		}

	}

}
