package examenOrdinaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utilidades.Entrada;

public class MainTramos {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		System.out.println("Introduce el primer número (≥ 0):");
		int anterior = Integer.parseInt(Entrada.cadena());
		while (anterior < 0) {
			System.out.println("Debe ser mayor o igual a 0. Intenta de nuevo:");
			anterior = Integer.parseInt(Entrada.cadena());
		}
		l.add(anterior);

		while (true) {
			System.out.println("Introduce un número mayor que " + anterior + " o 'fin':");
			String dato = Entrada.cadena();

			if (dato.equalsIgnoreCase("fin"))
				break;

			int nuevo = Integer.parseInt(dato);
			if (nuevo < 0) {
				System.out.println("Debe ser mayor o igual a 0.");

			}
			if (nuevo > anterior) {
				l.add(nuevo);
				anterior = nuevo;
			} else {
				System.out.println("Debe ser mayor que el anterior.");
			}
		}

		List<Tramos> lTramos = new ArrayList<Tramos>();

		// Recorre hasta el penúltimo índice

		for (int i = 0; i < l.size() - 1; i++) {
			int inicio = l.get(i);
			int fin = l.get(i + 1);
			lTramos.add(new Tramos(inicio, fin));

		}

		// Muestra los tramos
		for (Tramos t : lTramos) {
			int cnt = 0;
			System.out.println("pk" + cnt + t.getPunto1() + " : " + t.getPunto2());
			cnt++;

		}

		// lista asc

		System.out.println("ORDEANO POR TRAMOS ASCEDENTE");
		lTramos.sort(null);
		for (Tramos tramos : lTramos) {
			System.out.println(tramos);
		}

		System.out.println("ORDENADO POR TRAMOS DESCEDENTE");
		lTramos.sort(new ordenDescendete());
		for (Tramos tramos : lTramos) {
			System.out.println(tramos);
		}
	}// main
}// clas
