package tiempo;


import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import utilidades.StdDraw;

public class RelojDigitalEnVentana {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss,SSS");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
		SimpleDateFormat diaSemana=new SimpleDateFormat("EEEE");
		Font f=new Font("Arial", 0, 35);
		
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.setFont(f);
		StdDraw.enableDoubleBuffering(); 
		while (true) {
			// Borramos escenario
			StdDraw.clear();
			// Mostramos hora y día
			Date d=new Date();
			StdDraw.text(0, 45, diaSemana.format(d));
			StdDraw.text(0, 20, sdf2.format(d));
			StdDraw.text(0, -5, sdf.format(d));
			
			StdDraw.show();
			// Pausa
			StdDraw.pause(20);
		}
	}
}
