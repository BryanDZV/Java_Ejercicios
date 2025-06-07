package examen1;

import utilidades.Entrada;

public class Ejercicio1Real {

	public static void main(String[] args) {
		System.out.println("introduce un numero para saber si es Armstrong");
		int numero=Entrada.entero();
		
		
		System.out.println(esArmstriong(numero));
		

	}
	
	
	
	public static String esArmstriong(int parametro) {
		String cifra=""+parametro;
		int caracter=' ';
		String numAms="";
		
		if (parametro>0) {
			for (char i = 0; i < cifra.length(); i++) {
				 caracter=Character.valueOf(i);
				 numAms=numAms+(int) Math.pow(caracter, cifra.length());
				
			}
			
			if (parametro==Math.pow(caracter, cifra.length())) {
				
				cifra=cifra+"\n "+caracter;
			}
			
			
		}
		
		
		
		
		
		
		return cifra;
	}


	}


