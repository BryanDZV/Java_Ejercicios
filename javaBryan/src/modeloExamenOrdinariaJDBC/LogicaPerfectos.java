package modeloExamenOrdinariaJDBC;

import utilidades.Entrada;

public class LogicaPerfectos {

	public static void main(String[] args) {
		System.out.println("introduce 2 numero");
		int num1 = Entrada.entero();
		int num2 = 0;
		if (num1 < 1) {
			System.out.println("el numero debe ser mayor que 1");

		} else {
			System.out.println("siguiente numero");
			num2 = Entrada.entero();
			validarRango(num1, num2);
			System.out.println("rango ok");
			esPerfecto(num1, num2);
		}

	}

	private static void esPerfecto(int num1, int num2) {
		int total=0;
		for (int i = num1; i <= num2; i++) {

			int sumaDivisores = 0;

			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sumaDivisores += j;
				}

			}

			if (sumaDivisores == i) {
				System.out.println(i + " es perfecto");
				total++;;
			}

		}
		System.out.println("total de perfectos: " + total);

	}

	private static boolean validarRango(int num1, int num2) {
		boolean valido = true;
		if (num2 < num1) {
			valido = false;
		}
		return valido;
	}

}
