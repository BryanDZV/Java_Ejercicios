package aleatorios;

import funciones.Funciones;
import utilidades.Entrada;


public class EstadisticaLetras {

	public static void main(String[] args) {

		System.out.println("INTRODUZCA UNA PALABRA");
		String palabra = Entrada.cadena();
		String estadistica =Funciones.estadisticasLetras(palabra);
		System.out.println(estadistica);

	}

}
