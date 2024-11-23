package algoritmos;

import utilidades.Entrada;

public class TablaMultiplicar {

	public static void main(String[] args) {

		int n, i;
		boolean correcto;

		do {

			System.out.println("Tabla del numero [1...100]");
			n = Entrada.entero();
			correcto = n > 1 && n <= 100;
			if (!correcto) {
				System.out.println(" no es correcto intentalo de nuevo");

			}
		} while (!correcto);

		for (i = 1; i <= 10; i++) {

			System.out.println(n + " x " + i + "=" + n * i);

		}

	}

}


//todo BUCLE FOR ES UN BUCLE MIENTRAS
