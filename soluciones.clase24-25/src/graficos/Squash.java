package graficos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import objetos.Circulo;
import objetos.Punto;
import objetos.Raqueta;
import utilidades.Func;
import utilidades.StdAudio;
import utilidades.StdDraw;

public class Squash {
	static List<Punto> bolas=crearBolas(5);
	static Raqueta raq=new Raqueta(0,-95,40);
	static Punto bolaEnJuego=null;
	static Long tiempoNuevaBola=System.currentTimeMillis()+5000;//dentro de 3 segundos

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		
		while(true){
			StdDraw.clear();
			//=======================================
			if (tiempoNuevaBola!=null) {
				long ahora=System.currentTimeMillis();
				long segundosHastaNuevaBola=(tiempoNuevaBola-ahora)/1000;
				StdDraw.setPenColor(Color.BLUE);
				StdDraw.text(0,0, "Nueva bola en "+(segundosHastaNuevaBola+1)+" segundos");
				if (ahora>=tiempoNuevaBola) {
					bolaEnJuego=bolas.get(0);
					tiempoNuevaBola=null;
				}
			}
			
			StdDraw.textLeft(-95, 95, "Bolas restantes: "+bolas.size());
			
			if (bolaEnJuego!=null) {
				if (controlarRebote()) {
					bolaEnJuego=null;//Bola perdida
					bolas.remove(0);//Borramos primera bola de la lista
					if (bolas.size()>0)//Aún quedan bolas
						tiempoNuevaBola=System.currentTimeMillis()+5000;
				}
				else {
					bolaEnJuego.mover();
					bolaEnJuego.dibujar();
				}
			}
			
			if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
				raq.moverDerecha(100);
			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
				raq.moverIzquierda(-100);
			
			raq.dibujar();
			
			//=======================================
			StdDraw.show();
			StdDraw.pause(50);
		}

	}

	private static List<Punto> crearBolas(int numeroPelotas) {
		Color [] colores= {Color.ORANGE,Color.GREEN,Color.RED,Color.CYAN};
		List<Punto> bolas=new ArrayList<Punto>();
		Random r=new Random(); //Pare crear posiciones y movimientos aleatorios de cada bola
		
		for (int i = 0; i < numeroPelotas; i++) {
			Punto p=new Punto(0, 95, colores[i%colores.length]);
			if (r.nextBoolean())
				p.setMovX(r.nextDouble(2,5));//Hacia la derecha
			else
				p.setMovX(-r.nextDouble(2,5));//Hacia la izquierda
			p.setMovY(-r.nextDouble(2,5));//Hacia la abajo
			
			bolas.add(p);
		}
		
		
		return bolas;
	}

	private static boolean controlarRebote() {
		//Devuelve true si la bola se pierde por abajo
		//false en caso contrario
		boolean bolaPerdida=false;
		//Detectar límites de la ventana
		if (Math.abs(bolaEnJuego.getX()) >= 100) { //izq. o drecha
			StdAudio.playInBackground("soniquete.wav");
			bolaEnJuego.setMovX(-bolaEnJuego.getMovX());
		}
		if (bolaEnJuego.getY() >= 100) { //arriba 
			bolaEnJuego.setMovY(-bolaEnJuego.getMovY());
		}
		
		if (Math.abs(bolaEnJuego.getY()-raq.getExtIzq().getY())<4) {//Pelota a la altura de la raqueta
			if (bolaEnJuego.getX()>=raq.getExtIzq().getX()&&bolaEnJuego.getX()<=raq.getExtIzq().getX()+raq.getLargo())
				//toca raqueta 
				bolaEnJuego.setMovY(-bolaEnJuego.getMovY());
			else
				//NO toca raqueta 
				bolaPerdida=true;
		}
			
		return bolaPerdida;	
			
			
	}

}