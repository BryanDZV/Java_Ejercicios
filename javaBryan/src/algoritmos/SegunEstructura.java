package algoritmos;

import utilidades.Entrada;

public class SegunEstructura {

	public static void main(String[] args) {
		
		//caso con numeros
//		int a=1;
//		System.out.println("Introduzca Número");
//		
//		a=Entrada.entero();///captura de dato del teclado para comparar con los casos
//		switch (a) {
//		case 1:
//			System.out.println("Hola");
//			//break;
//		case 3:
//		case 12:
//		case 14:
//			
//			System.out.println("adios");
//			break;//salir del bucle
//		case 5:
//			System.out.println("perro");
//			break;
//		default:
//			System.out.println("Desconocido");
//			break;
//		}
		
		
		String pal;
		System.out.println("palabra");
		pal=Entrada.cadena().toUpperCase();
		
		
		switch (pal) {
		case "HELLO":
			
			System.out.println("hola");
			
			
			break;
			
		case "BYE":
			System.out.println("Adiós");
			
			break;
		
		case "Dog":
			System.out.println("Perro");
			
			break;

		default:
			
			System.out.println("Desconocido");
			break;
		}
		
		

	}
	
	

}
