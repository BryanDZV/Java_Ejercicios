package validaciones;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class ValidarListaOrdenCreciente {

	public static void main(String[] args) {
		// El usuario introduce números. Al final, dile si estaban en orden creciente.

		boolean salir = false;
		List<Integer> l = new ArrayList<Integer>();
		while (!salir) {
			System.out.println("intrduce un numeros/fin para salir");
			String dato = Entrada.cadena();
			if (!dato.matches("[0-9]+") && dato.equalsIgnoreCase("fin")) {
				System.out.println("saliendo");
				salir = true;
			} else {
				try {
					int num = Integer.parseInt(dato);
					l.add(num);
				} catch (Exception e) {
					System.out.println("solo numeros");
				}

			}
		}
		boolean creciente=false;
		for (int i = 0; i < l.size()-1; i++) {
			if (l.get(i)>l.get(i+1)) {
				creciente=false;
			}else {
				creciente=true;
			}
		}
		System.out.println(creciente ? "Lista creciente Ternaria" : "Lista no está ordenada");
		
		if (creciente) {
			System.out.println("la LISTA ES CRECIENTE");
		}else {
			System.out.println("la lista no es creciente");
		}

	}// main

}// clas
