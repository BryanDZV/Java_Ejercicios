package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio11_areaPeriCirculo {

	public static void main(String[] args) {
		/*
		 * Escriba un programa Java para imprimir el área y el perímetro de un círculo.
		 * Datos de prueba: Radio = 7,5
		 */
		
		System.out.println("introduce un radio");
		double radio=Entrada.real();
		double areaC=Math.PI*Math.pow(radio,2);
		double perimetroC=2*Math.PI*radio;
		
		
		
		System.out.println("area:"+areaC+"\n"+perimetroC);
	}

}
