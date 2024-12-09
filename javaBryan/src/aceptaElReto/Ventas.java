package aceptaElReto;

import utilidades.Entrada;

public class Ventas {

	public static void main(String[] args) {
		int[] semanaUno = new int[7];
		String[] dias = { "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO", "DOMINGO" };

		// Ciclo principal para evaluar múltiples semanas
		while (true) {
			System.out.println("Introduce los valores de ventas para esta semana:");
			System.out.println("(Escribe -1 para terminar el programa).");

			System.out.println("Día lunes (descanso):");
			semanaUno[0] = Entrada.entero();
			if (semanaUno[0] == -1) {
				break; // Condición para terminar
			}

			for (int i = 1; i < semanaUno.length; i++) {
				System.out.println("Día " + dias[i] + ":");
				semanaUno[i] = Entrada.entero();
			}

			// Procesar la semana
			String resultado = procesarSemana(semanaUno, dias);
			System.out.println(resultado);
		}
	}

	public static String procesarSemana(int[] semanaUno, String[] dias) {
		int maxVenta = semanaUno[1]; // Inicializamos con martes
		int minVenta = semanaUno[1];
		int diaMax = 1, diaMin = 1; // Índices de martes
		boolean empateMax = false, empateMin = false;
		int sumaVentas = 0;

		// Recorremos los días de la semana excepto lunes
		for (int i = 1; i < semanaUno.length; i++) {
			sumaVentas += semanaUno[i];
			if (semanaUno[i] > maxVenta) {
				maxVenta = semanaUno[i];
				diaMax = i;
				empateMax = false;
			} else if (semanaUno[i] == maxVenta) {
				empateMax = true;
			}

			if (semanaUno[i] < minVenta) {
				minVenta = semanaUno[i];
				diaMin = i;
				empateMin = false;
			} else if (semanaUno[i] == minVenta) {
				empateMin = true;
			}
		}

		// Calcular la media semanal
		double mediaSemanal = sumaVentas / 6.0; // Excluye lunes
		boolean domingoSuperaMedia = semanaUno[6] > mediaSemanal;

		// Construir el resultado
		String diaMaxTexto = empateMax ? "EMPATE" : dias[diaMax];
		String diaMinTexto = empateMin ? "EMPATE" : dias[diaMin];
		String superaMediaTexto = domingoSuperaMedia ? "SI" : "NO";

		return "MAS VENDIDO" + diaMaxTexto + " " + "MENOS VENDIDO" + diaMinTexto + " " + superaMediaTexto;
	}
}
