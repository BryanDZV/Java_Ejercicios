package graficos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objetos.Punto;
import utilidades.Func;
import utilidades.StdDraw;

public class PuntosEnMovimientoLista {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		
		Random r=new Random();
		
		int numeroPuntosIniciales=5;
		int maximoPuntosEnVentana=400;
		
		List<Punto> puntos=new ArrayList<Punto>();
		for (int i = 0; i < numeroPuntosIniciales; i++) {
			Punto p=crearPuntoAleatorio(r.nextDouble(-100, 100),r.nextDouble(-100, 100));
			puntos.add(p);
		}
		
		
		while(true){
			StdDraw.clear();
			
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.text(0,95,"Puntos: "+puntos.size());
			StdDraw.text(0,85,"Pulse el ratón para crear puntos");

			for (int i = 0; i < puntos.size(); i++) {
				controlarRebote(puntos.get(i));
				puntos.get(i).mover(); //Se desplaza el punto según movX y MovY
				puntos.get(i).dibujar();
			}
			
			//Creamos puntos cuando el ratón está pulsado
			if (StdDraw.isMousePressed()) {
				Punto p=crearPuntoAleatorio(StdDraw.mouseX(),StdDraw.mouseY());
				puntos.add(p);
			}
			
			if (puntos.size() < maximoPuntosEnVentana) {
				//Comprobar si hay dos puntos cerca (los nuevos puntos los añadimos a una nueva lista)
				List<Punto> nuevos=new ArrayList<Punto>();
				for (int i = 0; i < puntos.size()-1; i++) {
					for (int otro = i+1; otro < puntos.size(); otro++) {
						if (puntos.get(i).distancia(puntos.get(otro)) < 2) {
							//Añadimos nuevo punto por colision de dos puntos
							Punto medio=puntos.get(i).puntoMedio(puntos.get(otro));
							nuevos.add(crearPuntoAleatorio(medio.getX(),medio.getY()));
						}
					}
				}
				//Añadimos los puntos que se han creado por colisión al resto de puntos
				if (puntos.size()+nuevos.size() <= maximoPuntosEnVentana)
					puntos.addAll(nuevos);
			}
			
			StdDraw.show();
			StdDraw.pause(50);
		}

	}

	private static Punto crearPuntoAleatorio(double x, double y) {
		Random r=new Random();
		Color colorAleat=new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256));
		Punto p=new Punto(x,y,colorAleat);
		p.setMovX(r.nextDouble(-6,6));
		p.setMovY(r.nextDouble(-6,6));
		
		return p;
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