package algoritmos;

import funciones.Funciones;
import utilidades.Entrada;

public class Triangulo {

	public static void main(String[] args) {
		double base;
		double altura;

		int op = Entrada.entero();

		do {
			switch (op) {
			case 1:
				System.out.println("introduce base");
				base = Entrada.real();
				System.out.println("introduce altura");
				altura = Entrada.real();
				double area = Funciones.areaTriangulo(base, altura);
				System.out.println(area);
				break;
			case 2:
				System.out.println("sin opciones");
				break;
			default:
				System.out.println("opcion incorrecta");
				break;
			}
		} while (op != 1);

	}

}
