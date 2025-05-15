package ej2;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class Main {

	public static void main(String[] args) {
		List<Tramos>l=new ArrayList<Tramos>();
		
		boolean salir=false;
		int cnt=0;
		do {
			
			System.out.println("introduce los puntos de kilometro/fin para terminar");
			String dato=Entrada.cadena();
			String dato1=Entrada.cadena();
			
			if (dato=="fin") {
				salir=true;
				
			}else {
				int pk=Integer.parseInt(dato);
				int pk1=Integer.parseInt(dato);
				//l.add(new Tramos(, cnt));
			}
			
		} while (!salir);
		
	
	}

}
