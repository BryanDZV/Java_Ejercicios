package graficos;

import java.awt.event.KeyEvent;
import java.util.Random;

import utilidades.StdDraw;

public class Animacion {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		
		Random r=new Random();
		
		double x=0;
		double dx=r.nextDouble(-4, 4);
		double y=0;
		double dy=r.nextDouble(-4, 4);
		double x2=0;
		double dx2=r.nextDouble(-4, 4);
		double y2=0;
		double dy2=r.nextDouble(-4, 4);

		for (;;) {
			StdDraw.clear();
			
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.filledCircle(x, y, 10);
			x=x+dx;
			y=y+dy;
			
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledCircle(x2, y2, 10);
			x2=x2+dx2;
			y2=y2+dy2;
			//comprobamos posición x esté dentro de ventana (derecha o izquierda)
			if (x>=100 || x<=-100)
				dx=-dx;
			//comprobamos posición y esté dentro de ventana (arriba o abajo)
			if (y>=100 || y<=-100)
				dy=-dy;
			
			//comprobamos posición x esté dentro de ventana (derecha o izquierda)
			if (x2>=100 || x2<=-100)
				dx2=-dx2;
			//comprobamos posición y esté dentro de ventana (arriba o abajo)
			if (y2>=100 || y2<=-100)
				dy2=-dy2;
			
			StdDraw.show();
			StdDraw.pause(20);
			
		}

	}

}
