package coleciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utilidades.Entrada;

public class Ejercicio2 {

	private static int aleatorio;

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<Integer>();
		Random ran = new Random();
		int tama = ran.nextInt(10, 21);
		System.out.println("tamaño elegido  " + tama);

		l = insercion(tama);
		for (Integer elemento : l) {
			System.out.println(elemento);
		}
		System.out.println("que operacion quieres: ");
		System.out.println("suma,media,max,min,todos:");
		String operacion = Entrada.cadena();
		l = operaciones(l, operacion);

	}// main

	private static List<Integer> operaciones(List<Integer> l, String operacion) {
		List<Integer> l1 = new ArrayList<Integer>(l);
		int suma = 0;
		int media = 0;
		int min = l.get(0);
		int max = 0;
		int todos = 0;

		switch (operacion) {
		case "suma": {
			for (int i = 0; i < l.size(); i++) {
				suma += l.get(i);
			}
			l1.add(suma);
			System.out.println("soy suma" + suma);
			break;
		}
		case "media": {
			for (int i = 0; i < l.size(); i++) {
				suma += l.get(i);
			}

			media = suma / l.size();
			l1.add(media);
			System.out.println("soy suma" + media);
			break;
		}
		case "max": {
			for (int i = 0; i < l.size(); i++) {
				if (max < l.get(i)) {
					max = l.get(i);
				} else {
					max = max;
				}

			}
			int minimo = Collections.max(l);
			System.out.println("usando COLECCTION: " + minimo);

			System.out.println("soy Max" + max);
			break;
		}
		case "min": {

			for (int i = 1; i < l.size(); i++) {
				if (min > l.get(i)) {
					min = l.get(i);
				} else {
					min = min;
				}

			}
			l.add(min);
			System.out.println("soy minimo " + min);
			break;
		}

		case "todos": {
			// Suma
			for (int i = 0; i < l.size(); i++) {
				suma += l.get(i);
			}

			// Media
			media = suma / l.size();

			// Mínimo
			min = l.get(0); // por si venía de otro cálculo anterior
			for (int i = 1; i < l.size(); i++) {
				if (min > l.get(i)) {
					min = l.get(i);
				}
			}

			// Máximo
			max = l.get(0); // por si venía de cero
			for (int i = 1; i < l.size(); i++) {
				if (max < l.get(i)) {
					max = l.get(i);
				}
			}

			System.out.println("Suma: " + suma);
			System.out.println("Media: " + media);
			System.out.println("Mínimo: " + min);
			System.out.println("Máximo: " + max);

			l1.add(suma);
			l1.add(media);
			l1.add(min);
			l1.add(max);

			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + operacion);
		}

		return l1;

	}

	private static List<Integer> insercion(int tama) {
		List<Integer> l = new ArrayList<Integer>();
		Random ran = new Random();

		for (int i = 0; i < tama; i++) {
			int ale = ran.nextInt(101);
			l.add(ale);
		}
		return l;
	}

}// clase
