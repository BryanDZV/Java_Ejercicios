package algoritmos;

import utilidades.Entrada;

public class Traductor_menu {

	public static void main(String[] args) {

		String[] esp = { "perro", "gato", "persona", "casa", "puerta" };
		String[] ing = { "dog", "cat", "person", "house", "door" };
		int op;
		String pal;// definida pero dado valor en bucle
		boolean encontrado = false;

		// Mostrar opciones del menú
		do {
			System.out.println("Tradcutor");
			System.out.println("1-Traducir de español al inglés");
			System.out.println("2-Traducir de inglés a español");
			System.out.println("0-Salir");
			System.out.println("Elija una opción");
			op = Entrada.entero();

			switch (op) {

			case 1:// esp -->ing
				System.out.println("Palabra en español");
				pal = Entrada.cadena().toLowerCase();
				// bucle para abuscar en el diccinario
				for (int i = 0; i < esp.length; i++) {
					if (pal.equals(esp[i])) {
						System.out.println("------Traduccion al inglés:--------" + ing[i]);
						encontrado = true;

					}

				}
				// sino la encuentro cubre los dos valores!!NO COMPRAR BOOLEAN USAR !///
				if (!encontrado) {
					System.out.println("no existe en el diccionario de Español");

				}

				break;
			case 2:
				System.out.println("English Word");
				pal=Entrada.cadena().toLowerCase();
				for (int i = 0; i < ing.length; i++) {
					if (pal.equals(ing[i])) {
						System.out.println("------su traduccion es:----- "+esp[i]);
						encontrado=true;
						
					}
					
				}
				
				if (!encontrado) {
					System.out.println("No existe en el diccionario de inglés");
					
					
				}

				break;
			case 0:
				System.out.println("Adiós");

				break;

			default:

				System.out.println("Opción Incorrecta");
				break;
			}

		} while (op != 0);

		// encontrar misma palabra en un array
//		for (int i = 0; i < ing.length; i++) {
//			if (ing[i].equals(esp[i])) {
//				System.out.println(i);
//
//			}
//
//		}

	}

}
