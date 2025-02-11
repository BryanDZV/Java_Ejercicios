package utilidades;

import java.util.Iterator;
import java.util.Random;

public class Func {
	
	
	public static String validarDniNie(String dniNie) {
		// Devuelve el dni con 0's a la izquierda(hasta 8) y letra mayúscula si el dni es válido.
		// null si el dni no es válido
	
		char [] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };
		
		dniNie=dniNie.trim().toUpperCase(); //quitamos espacios y pasamos a mayúsculas
		
		//Distinguimos entre NIE o DNI
		if (dniNie.matches("[XYZ][0-9]{7}[A-Z]")){//NIE
			//Letra inicial
			char letraInicial=dniNie.charAt(0);
			//Letra final
			char letraFinal=dniNie.charAt(dniNie.length()-1);
			//Números
			String digitos=dniNie.substring(1,dniNie.length()-1);
			
			int numero=0; //Aquí almacenaré el número que voy a dividir por 23
			switch (letraInicial) {
			case 'X':
				numero=Integer.valueOf(digitos);
				break;
			case 'Y':
				numero=10000000+Integer.valueOf(digitos);
				break;
			case 'Z':
				numero=20000000+Integer.valueOf(digitos);
				break;
			}
			//Obtenemos la letra del array que corresponde a los dígitos
			char letraCalculada= letras[numero%23];
			//Comparamos letras
			if (letraFinal!=letraCalculada)
				dniNie=null;
			return dniNie;
			
		}else { //DNI
			if (!dniNie.matches("[0-9]{1,8}[A-Z]"))
				return null;
			
			//Letra
			char letra=dniNie.charAt(dniNie.length()-1);
			//Números
			String digitos=dniNie.substring(0,dniNie.length()-1);
			//Obtenemos la letra del array que corresponde a los dígitos
			char letraCalculada= letras[Integer.valueOf(digitos)%23];
			//Comparamos letras
			if (letra==letraCalculada) {
				while (dniNie.length()<9) { //8digitos+letra
					dniNie="0"+dniNie;
				}
			}
			else //dni incorrecto
				dniNie=null;
		
			return dniNie;
		}
			
	
	}
	
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

	public static double redondear(double numeroParaRedondear, int numeroDeDecimalesDeseados) {
		if (numeroDeDecimalesDeseados < 0)
			throw new IllegalArgumentException("El número de decimales para el redondeo no puede ser negativo: "+numeroDeDecimalesDeseados);
		// Movemos coma decimal hacia la derecha o a la izquierda multiplicando o dividiendo por este factor
		double factor = Math.pow(10, numeroDeDecimalesDeseados); 
		double redondeo = Math.round(numeroParaRedondear * factor);
		return redondeo / factor;
	}

	public static void mostrarMatriz(String[][] m) {
		for (int i = 0; i < m.length; i++) {
			//fila i
			for (int j = 0; j < m[i].length; j++) {
				//fila i columna j
				System.out.print(m[i][j]+" ");
			}
			System.out.println(); //tras cada fila
		}
		
	}
	
	public static void mostrarMatriz(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			//fila i
			for (int j = 0; j < m[i].length; j++) {
				//fila i columna j
				System.out.printf("%4d ",m[i][j]);
			}
			System.out.println(); //tras cada fila
		}
	}
	
	public static void mostrarMatriz(double[][] m) {
		for (int i = 0; i < m.length; i++) {
			//fila i
			for (int j = 0; j < m[i].length; j++) {
				//fila i columna j
		        if (m[i][j] == (long) m[i][j]) {
		            // Si el número no tiene parte decimal, lo imprimes como entero
		            System.out.print((long) m[i][j]+" "); 
		        } else {
		            // Si tiene parte decimal, lo imprimes con decimales
		            System.out.println(m[i][j]+" ");
		        }
			}
			System.out.println(); //tras cada fila
		}
	}
	
	public static int[] extraerFila(int[][] m, int indFila) {
		if (indFila < 0 || indFila > m.length - 1)
			throw new IllegalArgumentException("La fila " + indFila + " no existe en la matriz");

		return m[indFila];
	}
	
	public static int[] extraerColumna(int[][] m, int indColumna) {
		if (indColumna < 0 || indColumna > m[0].length - 1)
			throw new IllegalArgumentException("La columna " + indColumna + " no existe en la matriz");
	
		int[] arrayColumna = new int[m.length];
		for (int i = 0; i < m.length; i++) {
			arrayColumna[i] = m[i][indColumna];
		}
		return arrayColumna;
	}
	
	public static double[][] sumarMatrices(double[][] m1, double[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length)
			throw new RuntimeException("No se pueden sumar matrices de diferente dimensión");
		
		double[][] res = new double[m1.length][m1[0].length];//creamos matriz resultado de igual dimensión
		
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				res[i][j]=m1[i][j]+m2[i][j];
			}
		}
		return res;
	}
	
	public static double[][] restarMatrices(double[][] m1, double[][] m2) {
		if (m1.length != m2.length || m1[0].length != m2[0].length)
			throw new RuntimeException("No se pueden restar matrices de diferente dimensión");
		
		double[][] res = new double[m1.length][m1[0].length];//creamos matriz resultado de igual dimensión
		
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				res[i][j]=m1[i][j]-m2[i][j];
			}
		}
		return res;
	}
	
	public static int[][] multiplicarMatrices(int[][] m1, int[][] m2) {
		if (m1[0].length!=m2.length)
			throw new IllegalArgumentException("No se pueden multiplicar estas matrices");
		
		
		int[][] m = new int[m1.length][m2[0].length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				 int [] filaIDeA=extraerFila(m1, i);
				 int [] columnaJDeB=extraerColumna(m2, j);
				 for (int k = 0; k < columnaJDeB.length; k++) {
					m[i][j]= m[i][j]+filaIDeA[k]*columnaJDeB[k];
				 }
					
			}
		}
		return m;
	}
	
	public static void main(String[] args) {
		int [][] a= {{2,4,6},{1,2,3}};
		int [][] b= {{5,5,5},{6,6,6},{7,7,7}};
		
		int[][] mult=multiplicarMatrices(a, b);
		mostrarMatriz(mult);
	}
	
}
