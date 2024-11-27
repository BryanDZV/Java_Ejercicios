package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicios34_50 {

	public static void main(String[] args) {
		
		System.out.println("Escribe 2 numero para saber los divisibles que hay entre ellos");
		int num1=Entrada.entero();
		int num2=Entrada.entero();
		
		System.out.println("los divisibles que hay son:\n"+FuncionesConceptos.divisibleMultiple(num1, num2));
	}

	

}
