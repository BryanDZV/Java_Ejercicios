package examenOrdinaria;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class MainTemperaturas {

	public static void main(String[] args) {
		List<Temperatura> ldia = new ArrayList<Temperatura>();
		while (true) {
			System.out.println("introduce dias de la semana/fin para terminar");
			String dia = Entrada.cadena();
			if (dia.equalsIgnoreCase("fin")) {
				break;
			}
			System.out.println("introduce temperatura");
			int temperatura = Entrada.entero();
			ldia.add(new Temperatura(dia, temperatura));

		}
		System.out.println("ordenador de menor a mayor por temperatura");
		ldia.sort(null);
		for (Temperatura temperatura : ldia) {
			System.out.println(temperatura);
		}
	}

}
