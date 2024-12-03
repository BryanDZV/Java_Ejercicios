package objetos;

import java.util.Iterator;
import java.util.Random;

public class AppPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//instanciar llamas a la  clase y asisgnas variable=referencia(h)
		Personas h;
		//a la variable le asignas=crear un objeto con (new clase llamada)
		//envio parametros bryan zepeda....mismo orden de constructor
		h=new Personas("bryan","zepeda","masculino",10,true);
		
		//imprimir con to string (source en la clase)
		System.out.println(h);
		
		//array de 10 objetos
		Personas [] hh=new Personas[10];
		
		//hh[0]= new Personas ("david","lucas","masculino",13,true);
		//hh[1]= new Personas("luquitas","choto","femenino",9,true);
		
		for (int i = 0; i < hh.length; i++) {
			hh[i]=new Personas("luquitas","choto","femenino",9,true);
			
			
		}
		
		
		//los array se crecorrecn con for
		
		for (Personas personas : hh) {
			System.out.println(personas.toString());
			
		}
		

	}

}
