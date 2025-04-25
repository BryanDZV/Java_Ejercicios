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

public class SquashCirculos {
	static List<Circulo> bolas=crearBolas(5);
	static Raqueta raq=new Raqueta(0,-95,40);
	static Circulo bolaEnJuego=null;
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
					//Incrementamos dificultad subimos raqueta y la acortamos
					raq.getExtIzq().setY(raq.getExtIzq().getY()+25);
					raq.setLargo(raq.getLargo()*0.8);
					if (bolas.size()>0)//Aún quedan bolas
						tiempoNuevaBola=System.currentTimeMillis()+5000;
				}
				else {
					bolaEnJuego.getCentro().mover();
					bolaEnJuego.dibujar(false);
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

	private static List<Circulo> crearBolas(int numeroPelotas) {
		Color [] colores= {Color.BLUE,Color.GREEN,Color.RED};
		List<Circulo> bolas=new ArrayList<Circulo>();
		Random r=new Random(); //Pare crear posiciones y movimientos aleatorios de cada bola
		
		for (int i = 0; i < numeroPelotas; i++) {
			double radio=r.nextDouble(5,15);
			Circulo c=new Circulo(0,100-radio-5, radio);
			c.getCentro().setColor(colores[i%colores.length]);
			if (r.nextBoolean())
				c.getCentro().setMovX(r.nextDouble(2,5));//Hacia la derecha
			else
				c.getCentro().setMovX(-r.nextDouble(2,5));//Hacia la izquierda
			c.getCentro().setMovY(-r.nextDouble(2,5));//Hacia la abajo
			
			bolas.add(c);
		}
		
		
		return bolas;
	}

	private static boolean controlarRebote() {
		//Devuelve true si la bola se pierde por abajo
		//false en caso contrario
		boolean bolaPerdida=false;
		//Detectar límites de la ventana
		if (bolaEnJuego.getCentro().getX() + bolaEnJuego.getRadio() >= 100) { //dcha
			StdAudio.playInBackground("soniquete.wav");
			bolaEnJuego.getCentro().setMovX(-bolaEnJuego.getCentro().getMovX());
		}
		if (bolaEnJuego.getCentro().getX() - bolaEnJuego.getRadio() <= -100) { //izq
			StdAudio.playInBackground("soniquete.wav");
			bolaEnJuego.getCentro().setMovX(-bolaEnJuego.getCentro().getMovX());
		}
		if (bolaEnJuego.getCentro().getY() + bolaEnJuego.getRadio() >= 100) { //arriba
			StdAudio.playInBackground("soniquete.wav");
			bolaEnJuego.getCentro().setMovY(-bolaEnJuego.getCentro().getMovY());
		}
		
		if (Math.abs((bolaEnJuego.getCentro().getY())-bolaEnJuego.getRadio()-raq.getExtIzq().getY())<4) {//Pelota a la altura de la raqueta
			if (bolaEnJuego.getCentro().getX()>=raq.getExtIzq().getX()&&bolaEnJuego.getCentro().getX()<=raq.getExtIzq().getX()+raq.getLargo()) {
				//toca raqueta 
				StdAudio.playInBackground("soniquete.wav");
				bolaEnJuego.getCentro().setMovY(-bolaEnJuego.getCentro().getMovY());
			}
			else
				//NO toca raqueta 
				bolaPerdida=true;
		}
			
		return bolaPerdida;	
			
			
	}

}