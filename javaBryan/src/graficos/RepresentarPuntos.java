package graficos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

import objetos.Punto;
import utilidades.Func;
import utilidades.StdDraw;

public class RepresentarPuntos {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		Punto p=new Punto(50,50,Color.GREEN);
		Punto p2=new Punto(0,0);
		
		
		
		
		while(true){
			StdDraw.clear();
			
			//Asignamos al punto p las coordenadas del ratón
			p.setX(StdDraw.mouseX());
			p.setY(StdDraw.mouseY());
			
			//Unimos los puntos con una línea azul
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.setPenRadius(0.005);
			StdDraw.line(p.getX(),p.getY(),p2.getX(),p2.getY());
			
			//Cambio de color según cuadrante
			if (p.getX()>0 && p.getY()>0)
				p.setColor(new Color(160,80,0));
			if (p.getX()<0 && p.getY()>0)
				p.setColor(Color.RED);
			if (p.getX()<0 && p.getY()<0)
				p.setColor(Color.MAGENTA);
			if (p.getX()>0 && p.getY()<0)
				p.setColor(Color.ORANGE);
			p.dibujar();
			p2.dibujar();
			
			//Mostramos la distancia entre los puntos, sutuándola en el punto medio
			double dist=p.distancia(p2);
			StdDraw.setPenColor(Color.BLACK);
			Punto medio=p.puntoMedio(p2);
			StdDraw.text(medio.getX(),medio.getY(),String.valueOf(Func.redondear(dist, 2)));
			
			
			StdDraw.show();
			StdDraw.pause(50);
			
			/*numeros ciclicos con resto
			 * 4%90
			 * los numeros estaran entre 4 y 89
			 * */
			
		}

	}

}
