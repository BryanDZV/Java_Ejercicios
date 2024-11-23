package algoritmos;

import utilidades.Entrada;

public class Primera {

	public static void main(String[] args) {
		
		int a;//entero
		double r;//real
		String t;//texto
		char letra;//
		
		a=1;
		r=89.15;
		t="pepito";
		letra='k';
		System.out.println( "Hola Mundo" + " "+ "primer texto");
		System.out.println( "Adiós");
		
		int n;//entero
		
		System.out.println("Comienza practica java ");
		System.out.println("Leyendo Entero");
		
		
		//leer n
		n=Entrada.entero();
		System.out.print("introduzca un número:");
		System.out.println("El numero introducido es:"+n);
		
		//leer double
		r=Entrada.real();
		System.out.println("El numero introducido es:"+r);
		
		//leer String
		t=Entrada.cadena();
		System.out.print("introduzca un texto:");
		System.out.println("El numero introducido es:"+t);
	
		
		
		
	
		
}}
