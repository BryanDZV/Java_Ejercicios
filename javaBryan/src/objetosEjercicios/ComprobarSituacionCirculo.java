package objetosEjercicios;

import java.awt.Color;

import utilidades.StdDraw;

public class ComprobarSituacionCirculo {

	public static void main(String[] args) {

		/* patron para reperesentar animacion */
		// Establecer sistema de coordenadas
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.enableDoubleBuffering();

		Punto p = new Punto(-50, 60, Color.RED);
		Circulo c = new Circulo(50, 40, 34);
		c.getCentro().setColor(Color.GREEN);
		Circulo lazo=new Circulo(0,0,50);
		lazo.getCentro().setColor(Color.BLUE);

		/* bucle infinito */
		while (true) {
			StdDraw.clear();
			
			lazo.getCentro().setX(StdDraw.mouseX());
			lazo.getCentro().setY(StdDraw.mouseY());

			StdDraw.setPenColor(Color.BLACK);
			if (lazo.seSuperpone(c)) {
				StdDraw.textLeft(-98, 95, "Circulos Superpuestos");
			}else
					{StdDraw.textLeft(-98, 95, "Circulos NO Superpuestos");
					}
				
			if (lazo.contiene(p)) {
				StdDraw.textLeft(-98, 80, "Circulos contiene a punto");
			}else
					{StdDraw.textLeft(-98, 80, "Circulos NO contiene a punto");
					}
			
			p.dibujar();
			c.dibujar();
			lazo.dibujar(false);
			
			
			

			StdDraw.show();
			StdDraw.pause(50);
		}

	}
	/* hasta aqui patron animacion */
}
