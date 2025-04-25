package graficos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objetos.Circulo;
import objetos.Punto;
import utilidades.Func;
import utilidades.StdAudio;
import utilidades.StdDraw;

public class CazadorDePuntos {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		
		Random r=new Random();
		
		int numeroPuntosIniciales=10;
		
		List<Punto> puntos=new ArrayList<Punto>();
		for (int i = 0; i < numeroPuntosIniciales; i++) {
			Punto p=crearPuntoAleatorio(r.nextDouble(-100, 100),r.nextDouble(-100, 100));
			puntos.add(p);
		}
		
		//Creamos lazo que se moverá con el ratón
		Circulo lazo=new Circulo(0,0,20);
		lazo.getCentro().setColor(Color.BLUE);
		
		long inicio=System.currentTimeMillis();
		Long tiempoTranscurrido=null;
		
		while(true){
			StdDraw.clear();
			
			//cambiamos coordenadas del centro del círculo lazo
			lazo.getCentro().setX(StdDraw.mouseX());
			lazo.getCentro().setY(StdDraw.mouseY());
			lazo.dibujar(false);
			
			StdDraw.setPenColor(Color.BLUE);
			StdDraw.text(0,95,"Puntos: "+puntos.size());
			
			//Eliminamos puntos dentro del lazo
			for (int i = 0; i < puntos.size(); i++) {
				if (lazo.contiene(puntos.get(i))) {
					puntos.remove(i);
				    StdAudio.playInBackground("soniquete.wav");
				}
			}
			
			if (puntos.size()==0) { //Informamos del tiempo transcurrido
				if (tiempoTranscurrido==null) {
					long fin=System.currentTimeMillis();
					tiempoTranscurrido=(fin-inicio)/1000;//En segundos
				}
				StdDraw.text(0,85,"Has tardado: "+tiempoTranscurrido+" segundos");
			}

			for (int i = 0; i < puntos.size(); i++) {
				controlarRebote(puntos.get(i));
				puntos.get(i).mover(); //Se desplaza el punto según movX y MovY
				puntos.get(i).dibujar();
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