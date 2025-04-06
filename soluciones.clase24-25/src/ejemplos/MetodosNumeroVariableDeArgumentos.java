package ejemplos;

public class MetodosNumeroVariableDeArgumentos {
	// Etse método admite de 0 a n parámetros
	static int sumar(int... nums) {
		int total = 0;

		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}

		return total;
	}

	static int numeroCaracteres(String... palabras) {
		int totalCaracteres = 0;
		for (int i = 0; i < palabras.length; i++) {
			totalCaracteres += palabras[i].length();
		}

		return totalCaracteres;

	}

	static String concatenarPalabras(String separador, String... palabras) {
		String resultado = "-";
		for (int i = 0; i < palabras.length; i++) {
			resultado += palabras[i]+separador;
			if (i==palabras.length -1) {
				resultado+=palabras[i]+separador;
			}
		}

		return resultado;
	}

	static String repetirCadena(String cadena, int veces) {
		String resultado = "";
		return resultado;
	}

	public static void main(String[] args) {
		System.out.println(sumar(5, 30));
		System.out.println(numeroCaracteres("hola", "no", "tordo", "abuela"));
		System.out.println(concatenarPalabras("-", "no", "tordo", "abuela"));
	}

}
