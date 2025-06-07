package ejemplos;

import utilidades.Entrada;
import utilidades.Func;

public class ResolucionEcuacionesSegundoGrado {

	public static void main(String[] args) {
		double a, b, c;

		System.out.println("=== ax2 + bx + c = 0 ===");
		System.out.print("Coeficiente a ? ");
		a = Entrada.real();
		System.out.print("Coeficiente b ? ");
		b = Entrada.real();
		System.out.print("Coeficiente c ? ");
		c = Entrada.real();

		System.out.println("Ecuación a resolver: " + a + "x2 + " + b + "x + " + c + " = 0");

		double[] soluciones = Func.ecuacionSegundoGrado(a, b, c);
		switch (soluciones.length) {
		case 0:
			System.out.println("La ecuación no tiene solución.");
			break;
		case 1:
			System.out.println("La ecuación tiene una solución: "+ soluciones[0]);
			break;
		case 2:
			System.out.println("La ecuación tiene dos soluciones: "+ soluciones[0]+ " y "+ soluciones[1]);
			break;
		}
	}

}
