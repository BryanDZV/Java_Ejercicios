package utilidades;

import java.util.Iterator;
import java.util.Random;

public class Func {
	
	public static char [] convertirStringArrayChar(String t) {
		char [] a=new char[t.length()];
		
		for (int i = 0; i < a.length; i++) {
			a[i]=t.charAt(i);
		}
		
		return a;
	}
	
	public static String convertirArrayCharString(char [] a) {
		String t="";
		
		for (int i = 0; i < a.length; i++) {
			t = t+a[i];
		}
		
		return t;
	}
	
	public static String nombreMes(int mes, String idioma) {
		if (mes < 1 || mes > 12)
			throw new RuntimeException("El mes debe estar entre 1 y 12: " + mes);

		String nombre = "";
		String[] esp = { "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre" };
		String[] ing = { "january", "february", "march", "april", "may", "june", "july", "august", "september",	"october", "november", "december" };
		String[] fra = { "janvier", "fevrier", "mars", "avril", "may", "juin", "juliet", "aout", "septembre", "octobre", "novembre", "decembre" };
		switch (idioma) {
		case "es":
			nombre = esp[mes-1];
			break;
		case "en":
			nombre = ing[mes-1];
			break;
		case "fr":
			nombre = fra[mes-1];
			break;
		default:
			throw new RuntimeException("Idioma no admitido: " + idioma);
		}

		return nombre;
	}

	public static boolean esBisiesto(int anio) {
		if (anio <= 0)
			throw new RuntimeException("El año debe ser positivo: " + anio);

		return (anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0;
	}

	public static double areaTriangulo(double b, double a) {
		if (b <= 0)
			throw new RuntimeException("La base de triángulo del triángulo debe ser mayor que 0: " + b);
		if (a <= 0)
			throw new RuntimeException("La altura de triángulo del triángulo debe ser mayor que 0: " + a);

		return b * a / 2;
	}

	public static String mayusculas(String texto) {
		if (texto == null)
			throw new RuntimeException("El texto a convertir no puede ser null");

		String t = texto.toUpperCase();

		return t;
	}

	public static double volumenEsfera(double radio) {
		if (radio <= 0)
			throw new RuntimeException("El radio de la esfera debe ser mayor que 0: " + radio);

		return 4 * Math.PI * Math.pow(radio, 3) / 3;
	}

	public static boolean esPar(int n) {

		return n % 2 == 0;
	}

	public static boolean esPrimo(int n) {
		if (n <= 1)
			throw new RuntimeException("Sólo se admiten números mayores que 1");

		int divisor = 2;
		while (divisor <= n - 1) {
			if (n % divisor == 0) {
				// El número no es primo
				return false;
			}
			divisor++;
		}

		return true;
	}

	public static double[] ecuacionSegundoGrado(double a, double b, double c) {
		if (a == 0)
			throw new RuntimeException("El coeficiente a no puede ser 0");

		double[] sol;
		double disc = b * b - 4 * a * c;
		if (disc < 0)// No hay solucion
			sol = new double[0];
		else {
			if (disc == 0) {// 1 solución
				sol = new double[1];
				sol[0] = -b / (2 * a);
			} else {// 2 soluciones
				sol = new double[2];
				sol[0] = (-b + Math.sqrt(disc)) / (2 * a);
				sol[1] = (-b - Math.sqrt(disc)) / (2 * a);
			}
		}

		return sol;
	}

	public static double[] multiplicarArrays(double[] a1, double[] a2) {
		if (a1.length != a2.length)
			throw new RuntimeException("Los arrays deben tener la misma longitud");

		// Creo array resultado con la misma longitud
		double[] mult = new double[a1.length];

		for (int i = 0; i < mult.length; i++) {
			mult[i] = a1[i] * a2[i];
		}

		return mult;
	}
	
	public static void mostrarArray(char[] a) {
		System.out.print("{");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i != a.length - 1) // No escribo la , tras el último elemento
				System.out.print(", ");
		}
		System.out.println("}");
	}

	public static void mostrarArray(double[] a) {
		System.out.print("{");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i != a.length - 1) // No escribo la , tras el último elemento
				System.out.print(", ");
		}
		System.out.println("}");
	}

	public static int tirarDado() {
		Random r = new Random();
		int n = r.nextInt(1, 7);// 1..6
		return n;
	}

	public static String tirarMoneda() {
		Random r = new Random();
		int n = r.nextInt(1, 3);// 1 ó 2
		if (n == 1)
			return "cara";
		else
			return "cruz";
	}

	public static int diasMes(int mes, int anio) {
		if (mes < 1 || mes > 12)
			throw new RuntimeException("El mes debe estar entre 1 y 12: " + mes);
		if (anio <= 0)
			throw new RuntimeException("El año debe ser positivo: " + anio);

		int dias = 0;

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
			if (esBisiesto(anio))
				dias = 29;
			else
				dias = 28;
			break;
		}
		return dias;
	}

	public static String sustituirCaracter(String texto, char origen, char destino) {
		String nuevo="";
		
		for (int i = 0; i < texto.length(); i++) {
			char c=texto.charAt(i);
			if (c==origen)
				nuevo = nuevo+destino;
			else
				nuevo = nuevo+c;
		}
		return nuevo;
	}

	public static String quitarTildes(String t) {
		String sinTildes = "";
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			switch (c) {
			case 'Á':
				c = 'A';
				break;
			case 'á':
				c = 'a';
				break;
			case 'É':
				c = 'E';
				break;
			case 'é':
				c = 'e';
				break;
			case 'Í':
				c = 'I';
				break;
			case 'í':
				c = 'i';
				break;
			case 'Ó':
				c = 'O';
				break;
			case 'ó':
				c = 'o';
				break;
			case 'Ú':
			case 'Ü':
				c = 'U';
				break;
			case 'ú':
			case 'ü':
				c = 'u';
				break;
			}
			sinTildes = sinTildes + c;
		}
		return sinTildes;
	}
	
	public static String invertir(String t) {
		String inverso="";
		//Recorremos de izquierda a derecha añadiendo por el principio
		for (int i= 0; i < t.length(); i++) {
			inverso= t.charAt(i)+inverso;
		}
		return inverso;
	}

	
	public static boolean esPalindromo(String texto) {
		String normalizado=quitarTildes(texto);
		normalizado=normalizado.toUpperCase();
		normalizado=normalizado.
		
		//Recorremos de derecha a izquierda añadiendo por el final
//		for (int i= t.length()-1; i >= 0; i--) {
//			inverso= inverso+t.charAt(i);
//		}
		replace(" ", "");
		
		return normalizado.equals(invertir(normalizado));
	}

	public static int[] estadisticaLetras(String t) {
		// Quitamos tildes
		t=quitarTildes(t);
		// A mayusculas
		t=t.toUpperCase();
		
		int [] est=new int [27]; //Un contador para cada letra del alfabeto
		//Extraemos caracteres del String
		for (int i = 0; i < t.length(); i++) {
			char c=t.charAt(i);
			if (Character.isLetter(c)) {
				int pos;
				if (c=='Ñ')
				   pos=26;
				else
				   pos=c-'A';//Obtenemos el lugar del array don contabilizar el caracter c (distancia desde la A)
				est[pos]++;
			}
		}
		
		
		return est;
	}
	
	
}
