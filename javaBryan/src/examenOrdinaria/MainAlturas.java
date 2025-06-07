package examenOrdinaria;

import java.util.ArrayList;
import java.util.List;

import utilidades.Entrada;

public class MainAlturas {

	public static void main(String[] args) {
		List<Alturas> l = new ArrayList<Alturas>();
		System.out.println("introduce escalones/fin para terminar");
		String escalones = Entrada.cadena();

		while (true) {
			System.out.println("introduce escalones /fin para terminar");
			String escalones2 = Entrada.cadena();

			if (escalones2.equalsIgnoreCase("fin")) {
				break;
			} else if (Integer.parseInt(escalones) >= Integer.parseInt(escalones2)) {
				System.out.println("debe ser un numero mayor que::" + escalones);

			} else {
				l.add(new Alturas(Integer.parseInt(escalones), Integer.parseInt(escalones2)));

			}

		}
		System.out.println("lista ordena por distancia de ASC");
		l.sort(null);
		for (Alturas alturas : l) {
			System.out.println(alturas);
		}
		
		System.out.println("lista ordena por distancia de DESC");
		l.sort(new porOrdenDesc());
		for (Alturas alturas : l) {
			System.out.println(alturas);
		}
	
	}// m

}// c
