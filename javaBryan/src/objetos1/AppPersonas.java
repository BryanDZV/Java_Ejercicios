package objetos1;

import java.util.Iterator;
import java.util.Random;

public class AppPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// INSTANCIAR llamas a la clase y asisgnas variable=referencia(h)
		Personas h;
		// a la variable le asignas=CREAR OBJETO con (new clase llamada)envio parametros bryan zepeda....mismo orden de constructor
	
		h = new Personas("bryan", "zepeda", "masculino", 10, true);

		// imprimir con to string (source en la clase)
		System.out.println(h);
	

		// ARRAY de  objetos PUEBLO1
		//LOS OBJETOS TIENE Q CUMPLIR LOS PARAMETROS DEL CONSTRUCTOR
		Personas[] pueblo1 = {
				new Personas("luquitas", "choto", "femenino", 9, true),
				new Personas("pato", "choto", "femenino", 9, true),
				new Personas("loco", "choto", "femenino", 9, true) };

		// los array se crecorrecn con for
		pueblo1[0]=null;//se elilmina
		for (int i = 0; i < pueblo1.length; i++) {
			// hh[i]=new Personas("luquitas","choto","femenino",9,true);
			System.out.println("SOY BUCLE FOR pueblo 1 " + pueblo1[i]);
		}
		//ARRAY de objetos PUEBLO2
			
			Personas [] pueblo2= new Personas[4];
			System.out.println(".-----------------------------------.");
			for (int j = 0; j < pueblo2.length; j++) {
				pueblo2[j]=new Personas("hola","apellido","femenido",j,true);
				System.out.println("soy bucle for pueblo 2 "+pueblo2[j]);
				
			}
			

		

	}

}
