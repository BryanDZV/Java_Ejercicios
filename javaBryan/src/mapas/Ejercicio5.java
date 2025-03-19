package mapas;

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
		 * creo un conjunto mapa hacer 15 secuencias
		 * 
		 */
		Random rand = new Random();
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int apariciones = 0;
		NumerosAleatorios v1 ;
		for (int i = 0; i < 15; i++) {
			int claveAzar = rand.nextInt(11);
			if (!map.containsKey(claveAzar)) {
				 v1 = new NumerosAleatorios(claveAzar, apariciones);
				map.put(v1.getClave(), v1.getValor());
			}else {
				v1.getValor();
				
			}

		}
System.out.println("***DATOS MAPA***");
for (Integer clave : map.keySet()) {
	System.out.println("clave: "+clave+" , "+" valor: "+map.get(clave));
}

System.out.println("***APARICIONES DIFERENTES*****");

	}// main

}// clase
