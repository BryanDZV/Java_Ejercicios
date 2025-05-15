package coleciones;

import java.util.Set;
import java.util.TreeSet;

public class Ejercicio3 {

	public static void main(String[] args) {
		/*
		 * Crea un conjunto al que se le va a llamar jugadores. Inserta en el conjunto
		 * los jugadores del equipo de fútbol Atlético de Madrid: Oblak, Adán, Giménez,
		 * Lodi, Trippier, Savic, Felipe, Vrsaljko, Saúl, Koke, Thomas, Marcos Llorente,
		 * João Félix, Morata, Correa, Carrasco, Diego Costa y Vitolo. Realiza un bucle
		 * sobre los jugadores del conjunto y muestra sus nombres. Consulta si en el
		 * conjunto existe el jugador Arteche. Avisa si existe o no. Crea un segundo
		 * conjunto jugadores2 con los jugadores: Oblak, Maradona, Koke y Butragueño.
		 * Consulta si todos los elementos de jugadores2 existen en jugadores. Realiza
		 * una unión de los conjuntos jugadores y jugadores2. Elimina todos los
		 * jugadores del conjunto jugadores2 y muestra el número de jugadores que tiene
		 * el conjunto jugadores2 (debería ahora ser cero).
		 */
		/*
		 * crea un Treeset jugadores e inserta datos .add muesta sus nombres for each
		 * contain para ver si existe un dato en el connjunto CREa UN 2 CONJUNTO
		 * jugadores2 INSERTA DATOS
		 * 
		 */

		Set<String> jugadores = new TreeSet<String>();

		// AÑADIMOS DATOS
		jugadores.add("OBLAK");
		jugadores.add("ADAN");
		jugadores.add("GIMENEZ");
		jugadores.add("LODI");
		jugadores.add("TRIPPIER");
		jugadores.add("SAVIC");
		jugadores.add("FELIPE");
		jugadores.add("VRSALJKO");
		jugadores.add("SAUL");
		jugadores.add("KOKE");
		jugadores.add("MARCOS");
		jugadores.add("LLORENTE");
		jugadores.add("FELIZ");
		jugadores.add("MORATA");
		jugadores.add("CORREA");
		jugadores.add("CARRASCO");
		jugadores.add("DIEGO");
		jugadores.add("VITOLO");
		// MOSTRAMOS DATOS
		for (String elemento : jugadores) {
			System.out.println(elemento);
			String elmentoCase = elemento.toLowerCase();
		}
		// consultar si existe UN DATO

		if (jugadores.contains("SAUL")) {
			System.out.println("existo");
		} else {
			System.out.println("no existe en jugador ");
		}

		// SEGUNDO CONJUNTO JUGADORES2
		Set<String> jugadores2 = new TreeSet<String>();
		jugadores2.add("OBLAK");
		jugadores2.add("KOKE");
		jugadores2.add("MARADONA");
		jugadores2.add("BUTRAGUEÑO");

		// CONSULTAR JUGADORES2 EXISTEN EN JUGADORES

		if (jugadores.containsAll(jugadores2)) {
			System.out.println("jugadores contiene a todos de jugadores2");
		} else {
			System.out.println("no contiene a todos los jugadores2");
		}
		//interseccion DE LOS DOS CONJUNTOS
		TreeSet<String>interseccionConjuntos=new TreeSet<String>(jugadores);
		
		interseccionConjuntos.retainAll(jugadores2);
		System.out.println("****LISTA INTERSECION****");
		System.out.println(interseccionConjuntos);
		//ELIMINAR TODOS LOS JUGADORES DE JUGADORES2
		jugadores2.clear();
		if (jugadores2.size()==0) {
			System.out.println("jugadores elminados de jugadores2");
			System.out.println(jugadores2.size());
			
		}
		

	}//main

}//clase
