package conceptosBasicosEjercicios;

public class FuncionesConceptos {

	public static void main(String[] args) {
		// main test

		String palabra = "hola";
		char[] resultado = stringToChar(palabra); // Imprimir el resultado
		for (int i = 0; i < resultado.length; i++) {
			char caracter = resultado[i];

			System.out.println(caracter);
		}

	}

	public static String charaToString(int parametro) {
		// en funcion del parametro cambialo
		/* CONVERTIR CARACTER A STRING */

		// METODO 1 CHARACTER.TOSTRING()

//		char letra='a';
//		String letracomoString=Character.toString(letra);

		// METODO 2 CONCATENANDO

		String cambiadaS = "" + parametro;
		return cambiadaS;

	}

	public static char[] stringToChar(String parametro) {
		/* Extracion de caracter de string */

		// METODO 1 CHARAT()
		char[] extracion = new char[parametro.length()];

		for (int i = 0; i < parametro.length(); i++) {
			char cadaCaracter = parametro.charAt(i);
			extracion[i] = cadaCaracter;
		}

		return extracion;

	}

	// SUMAR DIGITOS DDE STRINGS
	public static int valorCaracter(int parametro) {

		// CAMBAIR A STRING MI PARAMETRO

		String numString = "" + parametro;
		int suma = 0;

		// RECORRO STRING Y SACO VALOR CADA CARACTER
		for (int j = 0; j < numString.length(); j++) {
			int valorCaracter = Character.getNumericValue(numString.charAt(j));

			// SUMO VALOR DE CARACTERES
			suma = suma + valorCaracter;

		}

		return suma;

	}

	// LEER EN ORDEN IVERSO UN STRING

	public static String invertirString(String parametro) {

		String pal = "";
		for (int i = parametro.length() - 1; i >= 0; i--) {

			pal = pal + parametro.charAt(i);

		}
		return pal;
	}

	public static String contarLNEO(String parametro) {

		int letras = 0;
		int numeros = 0;
		int espacios = 0;
		int otros = 0;

		for (int i = 0; i < parametro.length(); i++) {
			char valorEncontrado = parametro.charAt(i);
			if (Character.isDigit(valorEncontrado)) {
				numeros++;
			} else if (Character.isLetter(valorEncontrado)) {
				letras++;
			} else if (Character.isSpaceChar(valorEncontrado)) {
				espacios++;
			} else {
				otros++;
			}

		}
		// Construir el resultado como una cadena
		String resultado = "Letras: " + letras + "\nNúmeros: " + numeros + "\nEspacios: " + espacios
				+ "\nOtros caracteres: " + otros;
		return resultado;
	}

	// COMBINACION DE NUMEROS POSIBLES

	public static String numerosPosibles(int pA, int pB, int pC, int pD) {
		String opciones = "";
		int[] numeros = { pA, pB, pC, pD };
		int contadorOpciones = 0;
		for (int i = 0; i <= numeros.length - 1; i++)// longitud!=indice total de array
		{
			for (int j = 0; j <= numeros.length - 1; j++) {
				for (int k = 0; k <= numeros.length - 1; k++) {

					if (k != i && k != j && i != j) {
						contadorOpciones++;
						opciones = opciones + numeros[i] + numeros[j] + numeros[k] + "\n";
					}

				}

			}

		}
		opciones = opciones + "Número total: " + contadorOpciones;
		return opciones;
	}

	// SUMA SUCESIVA

	public static int sumaSucesiva(int parametro) {
		// 5+55+555
		// 5+50+5+500+55
		int n = 0;

		n = n + parametro;

		int nn = n * 10 + n;
		int nnn = n * 100 + nn;

		int formula = n + nn + nnn;

		return formula;
	}

	// LONGITUD DE UN ARRAY

	public static String longitud(String parametroA, String[] parametroB, char[] parametroC) {
		int contadorA = parametroA.length();
		int contadorB = parametroB.length;
		int contadorC = parametroC.length;

		// Inicializar la cadena total
		String total = "";

		for (int i = 0; i < parametroA.length(); i++) {
			char caracter = parametroA.charAt(i);
			total += "Letra: '" + caracter + "' en la posición: " + i + "\n";
		}

		// Añadir las longitudes de parametroB y parametroC al resultado
		total += "Total de elementos en parametroA: " + contadorA + "\n";
		total += "Total de elementos en parametroB: " + contadorB + "\n";
		total += "Total de elementos en parametroC: " + contadorC + "\n";

		return total;

	}

	// IMPARES ENTRE RANGO

	public static String imparesRango(int par1, int par2) {
		int contadorPares = 0;
		String resultado = "";

		while (par1 <= par2) {
			if (par1 % 2 == 0) {
				contadorPares = contadorPares + 1;
				resultado = resultado + "\n numero par " + par1 + " total pares: " + contadorPares;
			}
			par1++;

		}

		return resultado;

	}

	// Aparacion de subcadena

	public static String SubcadenaEncontrda(String palabra, String texto) {
		String resultado = "";
		int posicionPalabra = texto.toUpperCase().indexOf(palabra.toUpperCase());
		if (posicionPalabra != -1) {
			resultado = resultado + "la palabra " + palabra + " empieza en el indice " + posicionPalabra;

		} else {
			resultado = resultado + "no hay coincidencias";

		}

		return resultado;

	}

	// COTIENE LA SUBCADENA

	public static String EncuentraFrase(String texto, String palabra) {
		String resultado = "";
		int contadorPalabra = 0;

		if (texto.toUpperCase().contains(palabra.toUpperCase())) {
			contadorPalabra = +1;
			resultado = resultado + "El texto tiene la palabra  " + palabra.toLowerCase();

		} else {
			resultado = "no hay concidencias";

		}

		return resultado;

	}

	// Mostrar contraseña
	public static String mostrarContraseña(String texto) {
		String arrayContraseña = null;
		arrayContraseña = texto;

		String resultado = "su contraseña era:" + arrayContraseña;
		return resultado;
	}

	// la lógica de formateo

	public static String generarTextoFormateado(String parametro) {
		// Líneas del poema
		String[] lines = parametro.split(",");
		// Niveles de indentación para cada línea
		int[] indentLevels = { 4, 1, 2, 3, 0, 1 };
		// Construcción del texto formateado
		StringBuilder formattedText = new StringBuilder();
		for (int i = 0; i < lines.length; i++) {
			// Construir el texto con la indentación adecuada
			for (int j = 0; j < indentLevels[i]; j++) {
				formattedText.append("\t");
				// Añadir una tabulación por nivel de indentación
			}
			formattedText.append(lines[i]).append("\n");
		}

		return formattedText.toString();
	}

	// CADENA (STRING) A ENTERO

	public static  int cadenaToNumero(String parametro) {
		// coger string y usar metodo to String
		// parametro<=0 && parametro >=0 usando Stringquesea.matches dev boolean parametro.matches("[0-9]+"  LAVALIDACION LA HAGO EN EL MAIN ME ASEGURO DE 
		//PASAR A MI METODO LOS DATOS CORRECTOS DESDE EL MAIN EL METODO SOLO HACE
		int convertidoNum = 0;
		

		convertidoNum = Integer.parseInt(parametro);
		return convertidoNum;
		
		
	}

}// clase ENGLOBA A TODAS SIEMPRE
