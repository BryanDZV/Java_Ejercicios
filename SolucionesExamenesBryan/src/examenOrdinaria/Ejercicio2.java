package examenOrdinaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utilidades.Entrada;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
//		do {
//			System.out.println("elige una opcion");
//			System.out.println("1.lista de ventas por departamento ");
//			System.out.println("2.lista de poblaciones por departamento ");
//			System.out.println("0. salir");
//			String dato = Entrada.cadena();
//
//			switch (dato) {
//			case "1":
//				
//
//				break;
//			case "2":
//
//				break;
//			case "0":
//
//				break;
//
//			default:
//				System.out.println("opcion no valida");
//				break;
//			}
//
//		} while (true);

		/*----------------------------------------------A*/
		Map<String, List<Integer>> depVen = new HashMap<String, List<Integer>>();
		// lectura
		lectura("Mostoles", depVen);
		lectura("Majadahonda", depVen);
		lectura("Villalba", depVen);
		System.out.println("*************mapa original*********");
		for (String dv : depVen.keySet()) {
			System.out.println(dv + "--" + depVen.get(dv));
		}

		System.out.println("******************Listado ordenado*********");
		Map<String, Integer> depTotalVentas = new HashMap<String, Integer>();
		for (String dep : depVen.keySet()) {
			int sumaVentas = 0;
			for (Integer ventas : depVen.get(dep)) {
				sumaVentas += ventas;

			}
			depTotalVentas.put(dep, sumaVentas);
		}

		List<String> departamentosLista = new ArrayList<String>(depTotalVentas.keySet());
		departamentosLista.sort(new Orden(depTotalVentas));
		
		for (String d : departamentosLista) {
			System.out.println(d+"---"+depTotalVentas.get(d));
		}
		
		/*********************************apartadob***********************/

		
		
		
		

	}// main

	

	private static void lectura(String ficheroNombre, Map<String, List<Integer>> depVen) throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader(ficheroNombre));
		String linea;
		while ((linea = bfr.readLine()) != null) {
			String[] tmp = linea.split(";");
			String departamento = tmp[0];
			int venta = Integer.parseInt(tmp[1]);
			if (!depVen.containsKey(departamento)) {
				depVen.put(departamento, new ArrayList<Integer>());
			}
			depVen.get(departamento).add(venta);
		}

	}
}
