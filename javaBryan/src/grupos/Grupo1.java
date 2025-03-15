package grupos;

import java.util.HashSet;
import java.util.Set;
import utilidades.Entrada;

public class Grupo1 {

	private String nombre;
	private int edad;
	private boolean llevaGafas;

	public Grupo1(String nombre, int edad, boolean llevaGafas) {
		this.nombre = nombre;
		this.edad = edad;
		this.llevaGafas = llevaGafas;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", Edad=" + edad + ", Lleva gafas=" + llevaGafas;
	}

	public static void main(String[] args) {
		String nombre;
		int edad;
		boolean llevaGafas;

		Set<Grupo1> conjunto = new HashSet<>();
		Set<Grupo1> conjunto2=new HashSet<>();

		do {

			System.out.println("Introduce el nombre (o 'salir' para terminar): ");
			nombre = Entrada.cadena().trim();

			if (nombre.equalsIgnoreCase("salir")) {
				break;
			}

			System.out.println("Introduce la edad:");
			edad = Entrada.entero();

			System.out.println("¿Lleva gafas? (s/n): ");
			String respuesta = Entrada.cadena().trim().toLowerCase();

			llevaGafas = respuesta.equals("s");

			conjunto.add(new Grupo1(nombre, edad, llevaGafas));

			System.out.println("Persona añadida correctamente.\n");

		} while (true);

		System.out.println("\n Personas en el grupo:");
		for (Grupo1 p : conjunto) {
			System.out.println(p);
		}
	}
}
