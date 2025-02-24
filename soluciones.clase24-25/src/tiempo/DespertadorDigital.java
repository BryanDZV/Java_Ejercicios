package tiempo;


import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import utilidades.Entrada;
import utilidades.StdAudio;
import utilidades.StdDraw;

public class DespertadorDigital {

	public static void main(String[] args) {
		boolean bien;
		int horaAlarma=0;;
		do {
			horaAlarma=Entrada.entero("Hora alarma (00..23):","Hora incorrecta");
			bien = horaAlarma>=0 && horaAlarma<=23;
			if (!bien)
				System.out.println("La hora debe estar entre 0 y 23");
		} while (!bien);
		int minutoAlarma=0;
		do {
			minutoAlarma=Entrada.entero("Minuto alarma (00..59):","Minuto incorrect0");
			bien = minutoAlarma>=0 && minutoAlarma<=59;
			if (!bien)
				System.out.println("El minuto debe estar entre 0 y 59");
		} while (!bien);
		
		int segsAlarma=horaAlarma*3600+minutoAlarma*60;
		
		GregorianCalendar ahora=new GregorianCalendar();
		int ahoraHora=ahora.get(Calendar.HOUR_OF_DAY);
		int ahoraMinuto=ahora.get(Calendar.MINUTE);
		int ahoraSegundo=ahora.get(Calendar.SECOND);
		
		int segsAhora=ahoraHora*3600+ahoraMinuto*60+ahoraSegundo;
		
		int segundosEsperaHastaAlarma;
		if (segsAhora<segsAlarma) //Alarma posterior
			segundosEsperaHastaAlarma=segsAlarma-segsAhora;
		else { //Alarma anterior
			int segundosEnUnDia=24*3600;
			segundosEsperaHastaAlarma=segundosEnUnDia-segsAhora+segsAlarma;
		}
			
		
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		Font f=new Font("Arial", 0, 35);
		
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		StdDraw.setFont(f);
		StdDraw.enableDoubleBuffering(); 
		while (segundosEsperaHastaAlarma>=0) {
			// Borramos escenario
			StdDraw.clear();
			// Mostramos hora y día
			Date d=new Date();
			StdDraw.text(0, 45,String.format("Alarma programada: %02d:%02d",horaAlarma,minutoAlarma));
			int h=segundosEsperaHastaAlarma/3600;
			int m=(segundosEsperaHastaAlarma%3600)/60;
			int s=segundosEsperaHastaAlarma%60;
			StdDraw.text(0, 20, String.format("Tiempo restante: %02d:%02d:%02d",h,m,s));
			StdDraw.text(0, -5, sdf.format(d));
			
			StdDraw.show();
			segundosEsperaHastaAlarma--;
			// Pausa
			StdDraw.pause(1000);
		}
		StdAudio.playInBackground("gallo.wav");
	}
}
