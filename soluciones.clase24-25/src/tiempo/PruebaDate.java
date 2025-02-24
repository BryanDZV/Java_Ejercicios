package tiempo;

import java.text.SimpleDateFormat;
import java.util.Date;


import utilidades.Entrada;
import utilidades.StdDraw;

public class PruebaDate {

	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd' de 'MMMM' de 'yyyy HH:mm:ss");
		SimpleDateFormat soloHora=new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat soloDia=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat diaSemana=new SimpleDateFormat("u EEEE");
		System.out.println(sdf.format(d));
		System.out.println(sdf2.format(d));
		System.out.println(soloHora.format(d));
		System.out.println(soloDia.format(d));
		System.out.println(diaSemana.format(d));


	}

}
