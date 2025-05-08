package ejemplos;

import utilidades.Entrada;

public class MenuTraducir {

	public static void main(String args[])  {
		String [] esp={"cabra","perro","árbol","gato","loro","coche"};
		String [] ing={"goat","dog","tree","cat","parrot","car"};
		int op;
		String pal;
		do {
			//Mostrar opciones del menú
			System.out.println("\n=== Traductor ===");
			System.out.println("1-Traducir de español a inglés");
			System.out.println("2-Traducir de inglés a español");
			System.out.println("0-Salir");
			System.out.println("Elija una opción");
			op = Entrada.entero();
			switch (op) {
			case 1://Esp-->Ing
				System.out.print("Palabra en español? ");
				pal=Entrada.cadena();
				pal=pal.toLowerCase();
				//Busco en diccionario español
				boolean encontrada=false;
				for (int i = 0; i < esp.length; i++) {
					if (pal.equals(esp[i])) {
						System.out.println("Traducción al inglés:"+ing[i]);
						encontrada=true;
					}
				}
				if (!encontrada)
					System.out.println("No existe en español");
				break;
			case 2://Ing-->Esp
				System.out.print("Palabra en inglés? ");
				pal=Entrada.cadena();
				pal=pal.toLowerCase();
				//Busco en diccionario inglés
				encontrada=false;
				for (int i = 0; i < ing.length; i++) {
					if (pal.equals(ing[i])) {
						System.out.println("Traducción al español:"+esp[i]);
						encontrada=true;
					}
				}
				if (!encontrada)
					System.out.println("No existe en inglés");
				break;
			case 0:
				System.out.println("¡ Adiós !");
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		} while (op!=0);
	}
}
