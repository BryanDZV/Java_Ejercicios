package conceptosBasicosEjercicios;

public class Ejercicio15_variablesIntercambio {

	public static void main(String[] args) {
		/* Escribe un programa en Java para intercambiar dos variables. */
		int a = 3;
		int b = 2;
		int cambio;
		System.out.println("orginales" + a + "---" + b);

		cambio = a;
		a = b;
		b=cambio;

		System.out.println("cambiadas"+a + "---" + b);
	}

}
