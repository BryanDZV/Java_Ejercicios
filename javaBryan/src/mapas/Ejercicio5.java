package mapas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Ejercicio5 {

	public static void main(String[] args) {
		/*
		 * Ejercicio 5 Escribe un programa que genere una secuencia de 15 números
		 * aleatorios entre 1 y 10. Según se vayan generando los números se irán
		 * introduciendo en una mapa Map<Integer,Integer> donde la clave representa uno
		 * de los números aleatorios generados, y el valor el número de veces que
		 * aparece dicho número en la secuencia. Un ejemplo del mapa tras la generación
		 * de los 15 números aleatorios podría ser:
		 */
		/*
		 * 
		 * 
		 */

		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		Random rand = new Random();
		
		for (int i = 0; i < 15; i++) {
			int clave = rand.nextInt(11);
			if (!map.containsKey(clave)) {// no necesito implementar equal ya lo tiene integer
				map.put(clave, 1);

			} else {
				map.put(clave, map.get(clave)+1);
			}

		}

		for (int elemento : map.keySet()) {

			System.out.println("NUM_ALEATORIO\tAPARICIONES");
			System.out.println(elemento + "\t\t\t" + map.get(elemento));
		}
		System.out.println("\n");
		System.out.print("Numeros Diferentes\t" + map.size());
		System.out.println("\n");
		// System.out.println(map.values());
		
		//CLASE PARA ORDER POR EL VALOR
		List<Pares> l = new ArrayList<Pares>();
		for (int clave : map.keySet()) {
			int valor = map.get(clave);
			//System.out.println(valor);
			l.add(new Pares(clave, valor));

		}
		System.out.println("*****ORDEN POR APARICION DESC Y NUMERO ASC SI SON =");
		l.sort(new OrdenPorAparYNum());
		for (Pares pares : l) {
			System.out.println(pares);
		}
		
		

	}// main

}// clase
