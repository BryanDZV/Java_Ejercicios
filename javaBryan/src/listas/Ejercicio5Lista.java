package listas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ejercicio5Lista {

	public static void main(String[] args) {
		/*
		 * crear una lista listDias tipo String con dias de lunes a domingo insertar
		 * Juernes en indice 4
		 */

		List<String> listaDias = new ArrayList<String>();
		listaDias.add("Lunes");
		listaDias.add("Martes");
		listaDias.add("Miercoles");
		listaDias.add("Jueves");
		listaDias.add("Viernes");
		listaDias.add("Sabado");
		listaDias.add("lunes");
		listaDias.add("Domingo");

		System.out.println("lista original\n" + listaDias);


        // Insertar "Juernes" en la posición 4
        listaDias.add(4, "Juernes");
        System.out.println("Lista con Juernes:\n" + listaDias);

        // Copiar la lista a otra
        List<String> listaDos = new ArrayList<>(listaDias);
        System.out.println("Lista DOS:\n" + listaDos);

        // Añadir listaDos a listaDias
        listaDias.addAll(listaDos);
        System.out.println("Lista después de añadir listaDos:\n" + listaDias);

        System.out.println("*********** POSICIONES ***********");
        System.out.println("Lista original posición 3: " + listaDias.get(3));
        System.out.println("Lista original posición 4: " + listaDias.get(4));
        System.out.println("Lista original primer elemento: " + listaDias.get(0));
        System.out.println("Lista original último elemento: " + listaDias.get(listaDias.size() - 1));

        // Eliminar "Juernes"
        System.out.println("*********** BORRADO ***********");
        boolean eliminado = listaDias.remove("Juernes");
        System.out.println("¿Se eliminó 'Juernes'?: " + eliminado);
        System.out.println(listaDias);


		
		System.out.println("***********BUSQUEDA*********");
		boolean encontrado = listaDias.contains("Lunes");
		if (encontrado) {
			System.out.println("econtrado");
			
		}
	
		 // Buscar "Lunes" sin importar mayúsculas/minúsculas
	        System.out.println("*********** BÚSQUEDA SIN DISTINGUIR MAYÚSCULAS ***********");
		 int aux = 0;
		for (int i = 0; i < listaDias.size(); i++) {
		
			if (listaDias.get(i).equalsIgnoreCase("lunes")) {
				aux++;
				System.out.println("encotrado en la posicion::"+i);
			}
			
			
		} // fin for
		System.out.println("encontrado::" + aux);
		 // Mostrar elementos con iterador
        System.out.println("*********** ITERATOR ***********");
       
        Iterator<String> iterador = listaDias.iterator();//aqui lo generas
        while (iterador.hasNext()) {
            System.out.print(iterador.next()+", ");
        }
		//iterador = nombres.iterator(); // Reiniciar el iterator// una vez agotado para volver a usarlo se debe reiniciar
		System.out.println("***********ORDENADA*********");
		listaDias.sort(null);
		System.out.println(listaDias);

	}

}
