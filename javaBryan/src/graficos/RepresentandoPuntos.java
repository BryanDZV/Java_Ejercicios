package graficos;

import objetos.Carta;
import objetos.Palo;
import utilidades.StdDraw;

public class RepresentandoPuntos {

	public static void main(String[] args) {
		/*pintar*/
		
		/*Establecer Sistema de coordenadas*/
		StdDraw.setXscale(-100,100);
		StdDraw.setYscale(-100,100);
		StdDraw.enableDoubleBuffering();
		
		//cogo cartas de palo
		
		Carta c=new Carta(Palo.OROS,12);
		
		/*bucle para pintar*/
		for (;;) {
			StdDraw.clear();
			
			//StdDraw.picture(0, 0, "imagenesBaraja/b10.png", 50, 100);//donde,ruta,tamaño
			/*Ejercicios de Transforcion
			 * obtener la carta desdsde rutas a trozos*/
			c.dibujar(0,0,50,100);
			
			/*representar cartas trabajo*/
			StdDraw.show();
			StdDraw.pause(100);
			
		}
	}

}
