package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio5_operaciones {

	public static void main(String[] args) {
		/* Escriba un programa Java para imprimir la suma (suma),
		 *  multiplicación, resta, división y resto de dos números.*/ 

		
		System.out.println("ingresa 2 numero");
		
		int a=Entrada.entero();
		int b=Entrada.entero();
		
		System.out.println("suma\n"+(a+b)+"\n"+"la resta\n"+(a-b)+"\n"+"la multiplicacion\n"+(a*b)+"\n"+"la division\n"+(a/b)+"\n"+"Modulo%\n"+(a%b));
		
	}

}
