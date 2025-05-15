package funciones;

import java.util.Random;

import utilidades.Entrada;

public class Funciones {

	public static void main(String[] args) {
		double base;
		double altura;

		int op = Entrada.entero();

		do {
			switch (op) {
			case 1:
				System.out.println("introduce base");
				base = Entrada.real();
				System.out.println("introduce altura");
				altura = Entrada.real();
				double area = areaTriangulo(base, altura);
				System.out.println(area);
				break;
			case 2:
				System.out.println("sin opciones");
				break;
			default:
				System.out.println("opcion incorrecta");
				break;
			}
		} while (op != 1);
	}

	//// FUNCION AREA
	public static double areaTriangulo(double a, double b) {
		if (b <= 0)
			throw new RuntimeException("La base no puede ser negativa o nula: " + b);
		if (a <= 0)
			throw new RuntimeException("La altura no puede ser negativa o nula: " + a);

		return (b * a) / 2;
	}

	/// FUNCION MAYUSCULAS
	public static String mayusculas(String texto) {
		if (texto == null)
			throw new RuntimeException("El texto no puede ser null");
		return texto.toUpperCase();
	}

	//// FUNCION VOLUMEN
	public static double volumenCirculo(double radio) {
		if (radio <= 0)
			throw new RuntimeException("El radio no puede ser negativo o nulo: " + radio);
		return (4 * Math.PI * Math.pow(radio, 3)) / 3;
	}

	//// FUNCION BOOLEAN ES PAR
	public static boolean esPar(int n) {
		if (n <= 1)
			throw new RuntimeException("Solo se admiten valores mayores o iguales que uno: " + n);
		return n % 2 == 0;
	}

	// FUNCION ECUACION DE SEGUNDO GRADO
	public static double[] ecuacionSegundoGrado(double a, double b, double c) {
		if (a == 0)
			throw new RuntimeException("El coeficiente a no puede ser 0");
		double disc = b * b - 4 * a * c;
		if (disc < 0)
			return new double[0];
		if (disc == 0)
			return new double[] { -b / (2 * a) };
		double sqrtDisc = Math.sqrt(disc);
		return new double[] { (-b + sqrtDisc) / (2 * a), (-b - sqrtDisc) / (2 * a) };
	}

	/// FUNCION MULTIPLICAR ARRAYS
	public static double[] multiplicarArrays(double[] a1, double[] a2) {
		if (a1.length != a2.length)
			throw new RuntimeException("Los arrays deben tener la misma longitud");
		double[] multi = new double[a1.length];
		for (int i = 0; i < multi.length; i++) {
			multi[i] = a1[i] * a2[i];
		}
		return multi;
	}

	// FUNCION MOSTRAR ARRAY
	public static void mostrarArray(double[] a) {
		System.out.print("{");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + (i != a.length - 1 ? ", " : ""));
		}
		System.out.println("}");
	}

	// FUNCION BISIESTO
	public static boolean esBisiesto(int anio) {
		if (anio <= 0)
			throw new RuntimeException("El año debe ser positivo: " + anio);
		return (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
	}

	// FUNCION ES PRIMO
	public static boolean esPrimo(int n) {
		if (n <= 1)
			throw new RuntimeException("Sólo se admiten números mayores que 1");
		for (int divisor = 2; divisor <= Math.sqrt(n); divisor++) {
			if (n % divisor == 0)
				return false;
		}
		return true;
	}

	// FUNCION DIAS MES
	public static int diasMes(int mes, int anio) {
		if (mes < 1 || mes > 12)
			throw new RuntimeException("El mes debe estar entre 1 y 12: " + mes);
		if (anio <= 0)
			throw new RuntimeException("El año debe ser positivo: " + anio);
		int dias;
		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dias = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		case 2:
			dias = esBisiesto(anio) ? 29 : 28;
			break;
		default:
			dias = 0;
		}
		return dias;
	}

	// FUNCION ALEATORIA RANDOM
	public static int tirarMoneda() {
		Random r = new Random();
		return r.nextInt(2); // Retorna 0 (cara) o 1 (cruz)
	}

	public static int tirarDado() {
		Random r = new Random();
		return r.nextInt(6) + 1; // Retorna un número de 1 a 6
	}

	// FUNCION NOMBRE DEL MES
	public static String nombreMes(int mes, String idioma) {
		if (mes < 1 || mes > 12)
			throw new RuntimeException("El mes debe estar entre 1 y 12: " + mes);
		String[] esp = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre",
				"octubre", "noviembre", "diciembre" };
		String[] ing = { "january", "february", "march", "april", "may", "june", "july", "august", "september",
				"october", "november", "december" };
		String[] fr = { "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre",
				"novembre", "décembre" };
		switch (idioma) {
		case "es":
			return esp[mes - 1];
		case "ing":
			return ing[mes - 1];
		case "fr":
			return fr[mes - 1];
		default:
			throw new RuntimeException("Idioma no soportado: " + idioma);
		}
	}

	// FUNCION CONVERTIR CHAR EN STRING
	public static String sustituirCaracter(String texto, char origen, char destino) {
		if (texto == null)
			throw new RuntimeException("El texto no puede ser null");
		return texto.replace(origen, destino);
	}

	// FUNCION ESTADISTICA LETRAS

	public static String estadisticasLetras(String parametro) {

		int[] conteoLetras = new int[27];

		char [] abecedario = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q',
				'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		for (int i = 0; i < parametro.length(); i++) {
			char letra = parametro.charAt(i);
			for (int j = 0; j < abecedario.length; j++) {

				if (letra == abecedario[j]) {
					conteoLetras[j]++;
				}
			}
		}

		// Resultado con el conteo de cada letra en string
		String resultado = "";
		for (int j = 0; j < abecedario.length; j++) {
			if (conteoLetras[j] > 0) {
				resultado =resultado + abecedario[j] + "dddd " + conteoLetras[j] + "\n";
			}
		}
		return resultado;
	}
}
