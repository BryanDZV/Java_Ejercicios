package conceptosBasicosEjercicios;

import utilidades.Entrada;

public class Ejercicio37_52 {

	public static void main(String[] args) {
		// La suma es igual al tercer entero

//**Escriba un programa Java para calcular la suma de dos números enteros 
//**y devolver verdadero si la suma es igual a un tercer número entero.
		
		System.out.println("intrduzca 3 numeros");
		
		
		int numA=Entrada.entero();
		int numB=Entrada.entero();
		int numC=Entrada.entero();
		
		if (!Character.isDigit(numA)) {
		System.out.println("solo numero");
			
		}
		
		
		if (FuncionesConceptos.tercerEntero(numA,numB,numC)) {
			System.out.println("la suma de "+numA+" y "+numB+ " es igual");
			
		} else {
			System.out.println("la suma de "+numA+" y "+numB+ "no es igual");
		}
		
		
	
	}//fin main

	

}
