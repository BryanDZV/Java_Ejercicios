package graficos;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import objetos.Carta;
import objetos.Palo;
import utilidades.StdDraw;

public class RepresentandoCartas {

	private static boolean recienPulsado;

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();
		
		int margenIzquierdo=-90;
		int margenSuperior=75;
		
		String mensajeAlUsuario="Pulse ratón para extraer cartas...";
		List<Carta> baraja=Carta.crearBarajaEspaniola();
		List <Carta> mano=null;
		
		
		for (;;) {
			StdDraw.clear();
			
			
			StdDraw.text(0, -90, mensajeAlUsuario);
			
			for (int i = 0; i < baraja.size(); i++) {
				int fila=0;
				switch(baraja.get(i).getPalo()) {
				case OROS:
					fila=0;
					break;
				case COPAS:
					fila=1;
					break;
				case ESPADAS:
					fila=2;
					break;
				case BASTOS:
					fila=3;
					break;
				}
				//Convierto numero de la carte en un valor del 0 al 9
				int numero0a9=baraja.get(i).getNumero()-1;
				if (numero0a9>6)
					numero0a9=numero0a9-2;
				baraja.get(i).dibujar(margenIzquierdo+numero0a9*20, margenSuperior-fila*35, 20, 30);
			}
			
			if (clickRaton()) {
				try {
					mano=Carta.extraerMano(baraja, 7);
					mano.sort(null); //Ordenamos las cartas servidas
					System.out.println(mano);
				} catch (RuntimeException e) {
					mensajeAlUsuario="No hay cartas suficientes para extraer.";
					mano=null;
				}
			}
			
			if (mano!=null) {
				int margenIzq=-50;
				for(Carta c:mano) {
					c.dibujar(margenIzq, -65, 20, 30);
					margenIzq += 20;
				}
			}
			
			
			StdDraw.show();
			StdDraw.pause(50);
		}
		
		

	}
	
	private static boolean clickRaton() {
		if (StdDraw.isMousePressed()) {
			if (!recienPulsado) {
				recienPulsado = true;
				return true;
			}
		}else
			recienPulsado = false;
		return false;
	}
}
