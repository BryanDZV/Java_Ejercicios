package algoritmos;

import funciones.Funciones;
import utilidades.Entrada;

public class ListaPrimos {

	public static void main(String[] args) {
		// validacion
		
		boolean correcto;
		int cuantos;
		do {
			System.out.println("Cuantos numeros quieres");
			cuantos=Entrada.entero();
			correcto=cuantos>0;
			if (!correcto) {
				System.out.println("introduzca un numero mayor que 0");
				
			}
		} while (!correcto);
		
		
		//empieza codigo
		
		int cntPrimos=0;//numero de primos detectados
		//int n=2;//numero que queremos comprobar si es primo
		int n=Entrada.entero()
;		while(cntPrimos<cuantos) {
			if (Funciones.esPar(n)) {
				System.out.println(n+"hola ");
				cntPrimos++;
			if(cntPrimos%10==0){System.out.println(" ");}//cada 10 primos saltamos de liena
			
				
			}
			
		}
		n++;//proximo numeros a comprobar
		

	}

}
