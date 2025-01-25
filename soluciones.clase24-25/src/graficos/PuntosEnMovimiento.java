package graficos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

import objetos.Punto;
import utilidades.Func;
import utilidades.StdDraw;

public class PuntosEnMovimiento {

	//********************************
	// Modificad lo que consideréis para:
	// 1) Que el punto rojo no desaparezca y rebote al llegar a los límites de la ventana
	// 2) Una vez conseguido lo anterior, haced que haya 20 puntos con colores y movimientos aleatorios
	//    rebotando por la ventana. Cambiar el punto p(rojo) por un array de 20 puntos:
	//    Punto [] a=new Punto[20];
	

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		
		Random r=new Random();
		
		Punto [] puntos=new Punto[20];
		for (int i = 0; i < puntos.length; i++) {
			Color colorAleat=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
			puntos[i]=new Punto(0,0,colorAleat);
			puntos[i].setMovX(r.nextDouble(-6,6));
			puntos[i].setMovY(r.nextDouble(-6,6));
		}
		
		
		while(true){
			StdDraw.clear();
			
			for (int i = 0; i < puntos.length; i++) {
				controlarRebote(puntos[i]);
				puntos[i].mover(); //Se desplaza el punto según movX y MovY
				puntos[i].dibujar();
			}
			
			
			StdDraw.show();
			StdDraw.pause(50);
		}

	}

	private static void controlarRebote(Punto pun) {
		//Detectar límites de la ventana
		if (Math.abs(pun.getX()) >= 100) { //izq. o drecha
			pun.setMovX(-pun.getMovX());
		}
		if (Math.abs(pun.getY()) >= 100) { //arriba o derecha
			pun.setMovY(-pun.getMovY());
		}
		
	}
}