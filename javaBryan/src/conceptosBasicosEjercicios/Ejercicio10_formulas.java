package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio10_formulas {

	public static void main(String[] args) {
		/*
		 * Escriba un programa Java para calcular una fórmula específica. Fórmula
		 * específica: 4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11))
		 */

		
		double a=Entrada.real();
		double b=Entrada.real();
		double c=Entrada.real();
		double d=Entrada.real();
		double e=Entrada.real();
		double f=Entrada.real();
		double g=1.0;

		double r=a*(1-(g/b)+(g/c)-(g/d)+(g/e)-(g/f));
		System.out.println(r);
	}

}
