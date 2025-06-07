package numerosPrimos;

import utilidades.Entrada;
import utilidades.Func;

public class NumerosPrimosEnUnIntervalo {

	public static void main(String[] args) {
		System.out.println("== Números primos en un intervalo ==");
		boolean correcto;
		int min, max;
		do {
			System.out.print("Mínimo ? ");
			min=Entrada.entero();
			correcto=min>1;
			if (!correcto)
				System.out.println("El mínimo debe ser mayor que 1");
		} while (!correcto);
		
		do {
			System.out.print("Máximo ? ");
			max=Entrada.entero();
			correcto = max > min;
			if (!correcto)
				System.out.println("El máxino debe ser mayor que el mínimo");
		} while (!correcto);
		
		int n=min; //Número que queremos comprobar si es primo
		while (n <= max){
			if (Func.esPrimo(n)) {
				System.out.print(n+" ");
			}
			n++; //Próximo número a comprobar
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
