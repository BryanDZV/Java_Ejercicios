package conceptosBasicosEjercicios;

public class Ejercicio53_68 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("introduce un frase de 3 caracteres minimo");
		// String frase = Entrada.cadena();
		String frase = "3.03";

		System.out.println(repetirTresUltimosCaracteres(frase));
	}

	public static String repetirTresUltimosCaracteres(String frase) {
		// TODO Auto-generated method stub
		/*
		 * ES UN STRING saber los 3 ultimos caracteres sacar esos 3 caracteres copiar x
		 * 4 esos caracteres unir ala frase original
		 */

		String tresUltimosCaracteres = frase.substring(frase.length() - 3);
		System.out.println(tresUltimosCaracteres);

		String resultado = frase + tresUltimosCaracteres + tresUltimosCaracteres + tresUltimosCaracteres;
		System.out.println(resultado);
		return null;
	}

}
