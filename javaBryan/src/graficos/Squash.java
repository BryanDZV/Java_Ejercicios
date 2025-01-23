package graficos;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objetos.Circulo;
import objetos.Punto;
import objetos.Raqueta;
import utilidades.Func;
import utilidades.StdAudio;
import utilidades.StdDraw;

public class Squash {

	public static void main(String[] args) {
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		List<Punto> pelotas = crearPelotas(5);
		Raqueta raq = new Raqueta(0, -95, 20);
		Punto pelotaEnJuego = null;
		pelotaEnJuego = pelotas.get(0);
		while (true) {
			StdDraw.clear();

			if (pelotaEnJuego != null) {
				pelotaEnJuego.mover();
				pelotaEnJuego.dibujar();
			}

			if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT))
				raq.moverDerecha();
			if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT))
				raq.moverIzquierda();

			raq.dibujar();

			StdDraw.show();
			StdDraw.pause(50);
		}

	}

	private static List<Punto> crearPelotas(int numeroPelotas) {
		Color[] colores = { Color.BLUE, Color.GREEN, Color.RED };
		List<Punto> bolas = new ArrayList<Punto>();
		Random r = new Random(); // Pare crear posiciones y movimientos aleatorios de cada bola

		for (int i = 0; i < numeroPelotas; i++) {
			Punto p = new Punto(0, 95, colores[i % colores.length]);
			if (r.nextBoolean())
				p.setMovX(r.nextDouble(2, 5));// Hacia la derecha
			else
				p.setMovX(-r.nextDouble(2, 5));// Hacia la izquierda
			p.setMovY(-r.nextDouble(2, 5));// Hacia la abajo

			bolas.add(p);
		}
		
		

		return bolas;
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
