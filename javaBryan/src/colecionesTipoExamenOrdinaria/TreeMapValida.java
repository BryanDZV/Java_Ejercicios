package colecionesTipoExamenOrdinaria;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapValida {

	public static void main(String[] args) {
		String[][] ventas = { { "2025-01", "1000" }, { "2025-03", "750" }, { "2025-02", "1250" } };

		Map<String, Integer> m = new TreeMap<String, Integer>();
		// Para calcular la media
		int suma = 0;
		int count = 0;
		for (String[] fila : ventas) {
			String fecha = fila[0];
			for (int i = 1; i < fila.length; i++) {
				int venta = Integer.parseInt(fila[i]);

				if (venta < 0) {
					throw new IllegalArgumentException("no se admite valores negativos");
				}
				m.put(fecha, venta);
				suma += venta; // acumulo venta
				count++; // cuento meses

			}
		}
		for (String elemento : m.keySet()) {
			String[] mes = elemento.split("-");
			System.out.println(mes[1] + "\t" + m.get(elemento));
		}
		double media = suma / (double) count;
		System.out.println("\nVenta media: " + media);

	}// main

}// clase
