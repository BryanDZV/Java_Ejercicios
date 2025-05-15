package ficherosPractica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class Ejercicio1 {

	public static void main(String[] args) throws Exception {
		System.out.println("escribe  ruta");
		// String ruta = Entrada.cadena().trim();
		String ruta = "src\\\\ficherosPractica\\\\quijote";
		// src\\ficherosPractica\\quijote
		File f = new File(ruta);
		List<String> l = new ArrayList<String>();
		if (!f.exists()) {
			System.out.println("no existe la ruta");
			return;
		} else {
			if (!f.isFile()) {
				System.out.println("la ruta existe pero no es un archivo");
				return;
			}
		}

		while (true) {
			System.out.println("que frase o palabra, letra quieres buscar (ENTER PARA SALIR)");
			String cadena = Entrada.cadena().toLowerCase();
			if (cadena.isEmpty()) {
				System.out.println("fin de programa");
				return;

			} else {
				l = buscarCadena(f, cadena);
				if (l.isEmpty()) {
					System.out.println("No se encontró la cadena: " + cadena);
				} else {
					System.out.println("Líneas que contienen '" + cadena + "':");
					for (String elemento : l) {
						System.out.println(elemento);
					}
				}
			}

		}

	}// main

	private static List<String> buscarCadena(File f, String cadena) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new FileReader(f));
		String linea = bfr.readLine();
		List<String> coincidencias = new ArrayList<String>();

		while (linea != null) {
			if (linea.toLowerCase().contains(cadena.toLowerCase())) {
				String lineaR=linea.replaceAll(cadena, cadena.toUpperCase());
				coincidencias.add(lineaR);
			}
			linea = bfr.readLine();
		}
		bfr.close();
		return coincidencias;
	}// metodo1

}// clase
