package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio13_areaPeriTria {

	public static void main(String[] args) {
		/*
		 * Escriba un programa en Java para imprimir el área y el perímetro de un
		 * rectángulo. Datos de prueba: Ancho = 5,5 Alto = 8,5
		 */
System.out.println("ingresa una base");
		double b=Entrada.real();
		System.out.println("ingresa una altura");
		double h=Entrada.real();
		double areaT=(b*h)/2;
		
		/*hipotenusa cuadrado=base*base + altura*altura*/
		double perimetroT=Math.sqrt(b*b+h*h);
		
		
		System.out.println("area:"+areaT+"\n"+"perimetro:"+perimetroT);
		
		
		
	}

}
