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
	static List<Punto> pelotas=crearPelotas(5);
	static Raqueta raq=new Raqueta(0,-95,40);
	static Punto pelotaEnJuego=null;

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		

		pelotaEnJuego=pelotas.get(0);
		while(true){
			StdDraw.clear();
			
			if (pelotaEnJuego!=null) {
				if (controlarRebote()) {
					pelotaEnJuego=null;//Bola perdida
					pelotas.remove(0);//Borramos primera bola de la lista
					if (pelotas.size()>0)//Aún quedan bolas
						pelotaEnJuego=pelotas.get(0);
				}
				else {
					pelotaEnJuego.mover();
					pelotaEnJuego.dibujar();
				}
			}
			
			if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
				raq.moverDerecha(100);
			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
				raq.moverIzquierda(-100);
			
			raq.dibujar();
			
			StdDraw.show();
			StdDraw.pause(50);
		}

	}

	private static List<Punto> crearPelotas(int numeroPelotas) {
		Color [] colores= {Color.BLUE,Color.GREEN,Color.RED};
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
		if (Math.abs(pelotaEnJuego.getX()) >= 100) { //izq. o drecha
			StdAudio.playInBackground("soniquete.wav");
			pelotaEnJuego.setMovX(-pelotaEnJuego.getMovX());
		}
		if (pelotaEnJuego.getY() >= 100) { //arriba 
			pelotaEnJuego.setMovY(-pelotaEnJuego.getMovY());
		}
		
		if (Math.abs(pelotaEnJuego.getY()-raq.getExtIzq().getY())<4) {//Pelota a la altura de la raqueta
			if (pelotaEnJuego.getX()>=raq.getExtIzq().getX()&&pelotaEnJuego.getX()<=raq.getExtIzq().getX()+raq.getLargo())
				//toca raqueta 
				pelotaEnJuego.setMovY(-pelotaEnJuego.getMovY());
			else
				//NO toca raqueta 
				bolaPerdida=true;
		}
			
		return bolaPerdida;	
			
			
	}

}