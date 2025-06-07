package conceptosBasicosEjercicios;

public class Ejercicio39_54 {

	public static void main(String[] args) {
		// Verificación del mismo dígito más a la derecha

//Escriba un programa Java que acepte tres números enteros 
//del usuario y devuelva verdadero si dos o más de ellos
//(números enteros) tienen el mismo dígito en el extremo derecho.
//Los números enteros no son negativos.

		System.out.println("intrduzca 3 numeros, para devovler verdadero si dos o más de ellos\r\n"

				+ "//(números enteros) tienen el mismo dígito en el extremo derecho. Los números enteros no son negativos");

		int numA = 25;
		int numB = 74;
		int numC = 12;

		if (FuncionesConceptos.extremosDigitos(numA, numB, numC)) {
			System.out.println("un numero tiene extremos derechos iguales ");
		} else {
			System.out.println("no cumple la condicion");

		}

	}

}
