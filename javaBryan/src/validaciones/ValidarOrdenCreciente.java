package validaciones;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class ValidarOrdenCreciente {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<Integer>();
	
		boolean salir = false;
		int anterior = -1;
		while (!salir) {
			System.out.println("intrduce un numero");
			String dato = Entrada.cadena();
			if (!dato.matches("[0-9]+") && dato.equalsIgnoreCase("fin")) {
				salir = true;
			} else {
				try {
					int nuevo = Integer.parseInt(dato);
					if (nuevo > anterior) {
						l.add(nuevo);
						anterior=nuevo;
					} else {
						System.out.println(nuevo+"tiene que ser un numero mayo a " + anterior);
					}
					
				} catch (NumberFormatException e) {
					System.out.println("solo se acepta numeros\n");
				}
			}

		}

	}

}
