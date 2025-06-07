package numerosPrimos;

import utilidades.Entrada;
import utilidades.Func;

public class ListaDePrimerosPrimos {

	public static void main(String[] args) {
		boolean correcto;
		int cuantos;
		do {
			System.out.print("Cuántos número primos quieres? ");
			cuantos=Entrada.entero();
			correcto=cuantos>0;
			if (!correcto)
				System.out.println("Introduzca un número mayor que 0");
		} while (!correcto);

		int cntPrimos=0; //Número de primos detectado
		int n=2; //Número que queremos comprobar si es primo
		while (cntPrimos < cuantos){
			if (Func.esPrimo(n)) {
				System.out.print(n+" ");
				cntPrimos++;
				if (cntPrimos%10==0) //Cada 10 número primos saltamos de línea
					System.out.println();
			}
			n++; //Próximo número a comprobar
		}
		
		
	}














}
