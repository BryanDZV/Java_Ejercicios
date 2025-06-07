package mapas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import utilidades.Entrada;

public class Ejercicio3 {
	public static void main(String[] args) {
		/*
		 * Ejercicio 3 Realiza un programa que escoja al azar 5 palabras en español del
		 * minidiccionario del ejercicio anterior. El programa irá pidiendo que el
		 * usuario teclee la traducción al inglés de cada una de las palabras y
		 * comprobará si son correctas. Al final, el programa deberá mostrar cuántas
		 * respuestas son válidas y cuántas erróneas.
		 */

		Map<String, String> diccEspIng = new HashMap<String, String>();

		diccEspIng.put("ordenador", "computer");
		diccEspIng.put("gato", "cat");
		diccEspIng.put("rojo", "red");
		diccEspIng.put("árbol", "tree");
		diccEspIng.put("pingüino", "penguin");
		diccEspIng.put("sol", "sun");
		diccEspIng.put("agua", "water");
		diccEspIng.put("viento", "wind");
		diccEspIng.put("siesta", "nap");
		diccEspIng.put("arriba", "up");
		diccEspIng.put("ratón", "mouse");
		diccEspIng.put("estadio", "arena");
		diccEspIng.put("calumnia", "calumny");
		diccEspIng.put("aguacate", "avocado");
		diccEspIng.put("cuerpo", "body");
		diccEspIng.put("concurso", "contest");
		diccEspIng.put("cena", "dinner");
		diccEspIng.put("salida", "exit");
		diccEspIng.put("lenteja", "lentil");
		diccEspIng.put("cacerola", "pan");
		diccEspIng.put("pastel", "pie");
		diccEspIng.put("membrillo", "quince");
		
		///"**************minidiccionario JAPONES**********"
		Map<String,String> diccEspJap=new HashMap<String, String>();
		diccEspJap.put("ordenador", "コンピュータ");  // komputer
		diccEspJap.put("gato", "猫");  // neko
		diccEspJap.put("rojo", "赤い");  // akai
		diccEspJap.put("árbol", "木");  // ki
		diccEspJap.put("pingüino", "ペンギン");  // pengin
		diccEspJap.put("sol", "太陽");  // taiyō
		diccEspJap.put("agua", "水");  // mizu
		diccEspJap.put("viento", "風");  // kaze
		diccEspJap.put("siesta", "昼寝");  // hirune
		diccEspJap.put("arriba", "上");  // ue
		diccEspJap.put("ratón", "ねずみ");  // mausu
		diccEspJap.put("estadio", "スタジアム");  // sutajiamu
		diccEspJap.put("calumnia", "中傷");  // chūshō
		diccEspJap.put("aguacate", "アボカド");  // abokado
		diccEspJap.put("cuerpo", "体");  // karada
		diccEspJap.put("concurso", "コンテスト");  // kontesuto
		diccEspJap.put("cena", "夕食");  // yūshoku
		diccEspJap.put("salida", "出口");  // deguchi
		diccEspJap.put("lenteja", "レンズ豆");  // renzu mame
		diccEspJap.put("cacerola", "鍋");  // nabe
		diccEspJap.put("pastel", "パイ");  // pai
		diccEspJap.put("membrillo", "マルメロ");  // marumero


//		System.out.print("Introduzca una palabra en español: ");
//		String palabraIntro = Entrada.cadena();
//
//		if (diccEspIng.containsKey(palabraIntro)) {
//			System.out.println(palabraIntro + " en inglés es " + diccEspIng.get(palabraIntro));
//		} else {
//			System.out.print("La palabra no se encuentra en el diccionario.");
//		}
//		System.out.println("\n");
//		System.out.println("********LISTA CON FOR EACH********");
//		for (String elemento : diccEspIng.keySet()) {
//			System.out.println(elemento + " " + diccEspIng.get(elemento));
//
//		}
		System.out.println("\n");
		System.out.println("********LISTA PERSONALIZADA CON SOLO LAS CLAVES********");
		// LISTA COPIA DE HASHMAP las claves(PARA PODER TRABAJAR CON INDICES)
		List<String> l = new ArrayList<String>(diccEspJap.keySet());
		System.out.println(l);

		System.out.println("****************LISTA PARA GUARDAR LAS 5 PALABRAS AL AZAR**************");
		// LISTA PARA GUARDAR LAS 5 PALABRAS AL AZAR
		List<Adivinar> l1 = new ArrayList<Adivinar>();
		Random rand = new Random();
		int pregunta=1;
		String respuesta;
		int acierto=0;
		int fallo=0;
		do {
			System.out.println("responde con su traduccion pregunta: "+pregunta);
			int numAzar=rand.nextInt(l.size());
			String clave=l.get(numAzar);
			System.out.println(clave);
			respuesta=Entrada.cadena().trim().toLowerCase();
			if (diccEspIng.get(clave).equals(respuesta)) {
				acierto++;
			}else {fallo++;}
			pregunta++;
			String respuestaCorrecta=diccEspIng.get(clave);
			Adivinar nuevaPareja=new Adivinar(clave,respuesta,respuestaCorrecta);
			l1.add(nuevaPareja);
			l.remove(numAzar);
		} while (l1.size()<5);
		
		System.out.println("****TUS REPUESTAS****");
		//System.out.println(l1);
		for (Adivinar elemento : l1) {
			System.out.println(elemento);
		}
		System.out.println("tus aciertos WELL DONE "+acierto );
		System.out.println("tus fallos "+fallo);
		
	
	}// main

}// clase
