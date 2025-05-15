package conjuntos;

import java.util.HashSet;
import java.util.Set;

import objetos1.Persona;
import utilidades.Entrada;

public class ListadoPersonas {
	public static void main(String[] args) {
		Set<Persona> g1 = grupoPersonas("Grupo 1");
		Set<Persona> g2 = grupoPersonas("Grupo 2");
		g1.add(new Persona("Pepe", 19, false));
		g1.add(new Persona("Juan", 23, true));
		g1.add(new Persona("Ale", 40, false));

		g2.add(new Persona("Javier", 19, false));
		g2.add(new Persona("Jose", 85, false));
		g2.add(new Persona("Ortiz", 23, true));

		Set<Persona> g1Copia = new HashSet<Persona>(g1);
		Set<Persona> g2Copia = new HashSet<Persona>(g2);
		System.out.println("===GRUPO 1===");
		for (Persona persona : g1) {
			System.out.println(persona);
		}
		System.out.println("===GRUPO 2===");
		for (Persona persona : g2) {
			System.out.println(persona);
		}
		g1.retainAll(g2);
		g2.retainAll(g1);
		System.out.println("===GRUPO 1 EN GRUPO 2===");
		for (Persona persona : g1) {
			System.out.println(persona);
		}
		System.out.println("===GRUPO 2 EN GRUPO 1===");
		for (Persona persona : g2) {
			System.out.println(persona);
		}
		g1Copia.removeAll(g2);
		g2Copia.removeAll(g1);
		System.out.println("===PERSONAS QUE HAN CAMBIADO EN GRUPO 1===");
		for (Persona persona : g1Copia) {
			System.out.println(persona);
		}
		System.out.println("===PERSONAS QUE HAN CAMBIADO EN GRUPO 2===");
		for (Persona persona : g2Copia) {
			System.out.println(persona);
		}
	}

	static Set<Persona> grupoPersonas(String nombreGrupo) {
		Set<Persona> g = new HashSet<Persona>();
		System.out.println("===" + nombreGrupo + "?");
		String nom = "";
		boolean llevagafas = false;
		int edad = 0;
		while (true) {
			System.out.print("Nombre? ");
			nom = Entrada.cadena();
			if (nom.isBlank())
				return g;
			boolean repetir;
			do {
				try {
					System.out.print("Edad? ");
					edad = Entrada.entero();
					repetir = false;
				} catch (NumberFormatException e) {
					System.out.println("Dato incorrecto, no es un entero.");
					repetir = true;
				}
			} while (repetir);
			do {
				System.out.print("Lleva gafas? ");
				String aux = Entrada.cadena().toLowerCase();
				if (aux.equals("si")) {
					llevagafas = true;
					repetir = false;
				} else if (aux.equals("no")) {
					llevagafas = false;
					repetir = false;
				} else {
					System.out.println("Dato incorrecto, true o false?");
					repetir = true;
				}
			} while (repetir);
			if (g.add(new Persona(nom, edad, llevagafas))) {
				System.out.println(nom + " añadido/a a " + nombreGrupo + ".");
			} else {
				System.out.println("Esa persona ya existe en " + nombreGrupo + ".");
			}
		}
	}
}