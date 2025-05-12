package examenOrdinaria;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class RutasEntrega {

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
		
		List<Tramos>lTramos=new ArrayList<Tramos>();
		
		for (int i = 0; i < l.size(); i++) {
			if (condition) {
				
			}
			lTramos.add(new Tramos(l.get(i), l.get(i+1)));
		}
		

	}// main
}// clas
