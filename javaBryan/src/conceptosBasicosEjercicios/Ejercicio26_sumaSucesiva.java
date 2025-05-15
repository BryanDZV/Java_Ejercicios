package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio26_sumaSucesiva {
	public static void main(String[] args) {
		System.out.println("introduzca un numero para sumarlo n+nn+nnn");
		int numero=Entrada.entero();
		int total=FuncionesConceptos.sumaSucesiva(numero);
		System.out.println("la suma total es "+total);
	}

	

}
